package com.rickvoermans.microservices.users.api;

import com.rickvoermans.microservices.users.api.models.User;
import com.rickvoermans.microservices.users.api.models.UserDto;
import com.rickvoermans.microservices.users.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void addUser(@RequestBody UserDto userDto) {
        boolean existingUser = userRepository.findByUsername(userDto.getUsername()).isPresent();

        if (!existingUser) {
            // user does not exist:
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());

            userRepository.save(user);
        }
    }

    @GetMapping
    public Long login(@RequestHeader("username") String username, @RequestHeader("password") String password) {
        Optional<User> user =userRepository.findByUsernameAndPassword(username, password);

        return user.map(User::getId).orElseThrow(IllegalArgumentException::new);
    }
}
