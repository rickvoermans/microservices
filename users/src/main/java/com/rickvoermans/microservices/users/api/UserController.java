package com.rickvoermans.microservices.users.api;

import com.rickvoermans.microservices.users.api.errors.exceptions.ExistingUserException;
import com.rickvoermans.microservices.users.api.models.Response;
import com.rickvoermans.microservices.users.api.models.User;
import com.rickvoermans.microservices.users.api.models.data_transfer_objects.UserDto;
import com.rickvoermans.microservices.users.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(path = "users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public Response addUser(@RequestBody UserDto userDto) {
        boolean existingUser = userRepository.findByUsername(userDto.getUsername()).isPresent();

        if (!existingUser) {
            // user does not exist:
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());

            userRepository.save(user);
            return new Response<>(LocalDate.now(), HttpStatus.OK.value(), HttpStatus.OK.toString(), user);
        } else {
            throw new ExistingUserException("Username: " + userDto.getUsername() + " already exists");
        }
    }

    //todo: @RequestBody with username and password and InvalidCredentialsException
    @GetMapping
    public Response login(@RequestHeader("username") String username,
                          @RequestHeader("password") String password) throws Exception {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);

        if (user.isPresent()) {
            return new Response<>(LocalDate.now(), HttpStatus.OK.value(), HttpStatus.OK.toString(), user);
        } else {
            throw new Exception("Username or password is incorrect, please try again.");
        }
    }
}
