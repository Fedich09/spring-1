package service;

import dto.UserResponseDto;
import model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setId(user.getId());
        return userResponseDto;
    }
}
