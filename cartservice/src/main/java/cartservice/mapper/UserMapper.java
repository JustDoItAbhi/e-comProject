package cartservice.mapper;

import cartservice.entity.UserDetails;
import cartservice.userdtos.UserResponseDto;

public class UserMapper {
    public static UserDetails fromEntity(UserResponseDto dto){
            UserDetails details=new UserDetails();
            details.setUserId(dto.getUserId());
            details.setUserEmail(dto.getUserEmail());
            details.setUserName(dto.getUserName());
            details.setUserPhone(dto.getUserPhone());
            details.setUserPassword(dto.getUserPassword());
            return details;
    }
}
