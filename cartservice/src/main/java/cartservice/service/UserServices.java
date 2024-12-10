package cartservice.service;

import cartservice.entity.UserDetails;
import cartservice.userdtos.UserResponseDto;

public interface UserServices {
    UserDetails createUser(String email);
    boolean deleteUser(long id);
}
