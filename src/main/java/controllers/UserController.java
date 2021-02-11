package controllers;

import dto.UserResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserMapper;
import service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/inject")
    public String inject() {
        User user = new User();
        user.setName("bob");
        User user1 = new User();
        user1.setName("alice");
        User user2 = new User();
        user2.setName("john");
        User user3 = new User();
        user3.setName("ken");
        userService.add(user);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        return "success";
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return userMapper.toDto(userService.get(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
