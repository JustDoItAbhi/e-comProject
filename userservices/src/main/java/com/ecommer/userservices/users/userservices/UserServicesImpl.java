package com.ecommer.userservices.users.userservices;

import com.ecommer.userservices.entity.Roles;
import com.ecommer.userservices.entity.Users;
import com.ecommer.userservices.kafka.KafkaProducerClinet;
import com.ecommer.userservices.kafka.SendEmailDto;
import com.ecommer.userservices.repository.RoleRepository;
import com.ecommer.userservices.repository.TokenRepository;
import com.ecommer.userservices.repository.UserRepository;
import com.ecommer.userservices.users.userdtos.LogOut;
import com.ecommer.userservices.users.userdtos.Login;
import com.ecommer.userservices.users.userdtos.SignUp;
import com.ecommer.userservices.users.userdtos.UserResponseDto;
import com.ecommer.userservices.users.usermapper.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private TokenRepository tokenRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private KafkaProducerClinet kafkaProducerClinet;
    private ObjectMapper objectMapper;

    public UserServicesImpl(UserRepository userRepository, RoleRepository roleRepository,
                            TokenRepository tokenRepository, BCryptPasswordEncoder passwordEncoder,
                            KafkaProducerClinet kafkaProducerClinet, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.kafkaProducerClinet = kafkaProducerClinet;
        this.objectMapper = objectMapper;
    }

    @Override
    public UserResponseDto signUp(SignUp signUp) throws JsonProcessingException {
        Users users=new Users();
        users.setUserName(signUp.getUserName());
        users.setUserEmail(signUp.getUserEmail());
        users.setUserPassword(passwordEncoder.encode(signUp.getUserPassword()));
        users.setUserPhone(signUp.getUserPhone());
        userRepository.save(users);

      Optional<Roles> savedRole=roleRepository.findByRoleType(signUp.getRoles());
      if(savedRole.isEmpty()) {
          throw new RuntimeException("ROLE NOT FOUND " + signUp.getRoles());
      }
      Roles roles=savedRole.get();
        List<Roles>rolesList=new ArrayList<>();
        roles.setUsers(users);
        rolesList.add(roles);
        roleRepository.save(roles);
        users.setRolesList(rolesList);

        SendEmailDto emailDto=new SendEmailDto();
        emailDto.setTo(users.getUserEmail());
        emailDto.setFrom("Pattorney0@gmail.com");
        emailDto.setSubject("WELCOME TO KAFKA");
        emailDto.setBody("thanks for joining ");
        kafkaProducerClinet.sendMessage("sendemail",
                objectMapper.writeValueAsString(emailDto));

        return UserMapper.fromEntity(users);
            }

    @Override
    public UserResponseDto logIn(Login login) {
       Optional<Users> savedUser=userRepository.findByUserEmail(login.getUserEmail());
       if(!savedUser.isPresent()){
           throw  new UsernameNotFoundException("USER NOT FOUND "+ login.getUserEmail());
       }
       Users users=savedUser.get();
       if(!passwordEncoder.matches(login.getUserPassword(),users.getUserPassword())){
           throw new UsernameNotFoundException("USER PASSWORD IS NOT CORRECT "+ login.getUserPassword());
       }
       SendEmailDto sendEmailDto=new SendEmailDto();
       sendEmailDto.setTo(users.getUserEmail());
        sendEmailDto.setFrom("Pattorney0@gmail.com");
        sendEmailDto.setSubject("YOU SUCESSFULLY LOGIN");
        sendEmailDto.setBody(users.getUserName()+" logged in "+ users.getUserEmail()+" by email "+ users.getUserPhone()+" by phone "
                + users.getId()+" this is your id ");
        return UserMapper.fromEntity(users);
    }

    @Override
    public UserResponseDto logOut(LogOut logOut) {
        Optional<Users>users=userRepository.findByUserEmail(logOut.getEmail());
        if(users.isEmpty()){
            throw new RuntimeException("USER NOT FOUND "+ logOut.getEmail());
        }

        return UserMapper.fromEntity(users.get());
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<Users> user=userRepository.findAll();
        List<UserResponseDto>dtos=new ArrayList<>();
        for(Users users:user){
            dtos.add(UserMapper.fromEntity(users));
        }
        return dtos;
    }



    @Override
    public boolean deleteUser(long id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public UserResponseDto getById(String email) {
        Optional<Users>existingUser=userRepository.findByUserEmail(email);
        if(existingUser.isEmpty()){
            throw new RuntimeException("user not found "+email);
        }

        return UserMapper.fromEntity(existingUser.get());
    }
}
