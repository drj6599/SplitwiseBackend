package dev.dheeraj.splitwise.controller;

import dev.dheeraj.splitwise.dto.UserAddFriendDto;
import dev.dheeraj.splitwise.dto.UserLoginRequestDto;
import dev.dheeraj.splitwise.dto.UserRegistrationRequestDto;
import dev.dheeraj.splitwise.entity.User;
import dev.dheeraj.splitwise.exception.UserRegistrationInvalidData;
import dev.dheeraj.splitwise.mapper.EntityDTOManager;
import dev.dheeraj.splitwise.service.UserService.UserService;
import dev.dheeraj.splitwise.validation.EmailValidator;
import dev.dheeraj.splitwise.validation.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserRegistrationRequestDto user)
    {
        validateUserDetails(user);
        User savedUser = userService.signup(user.getName(), user.getEmail(), user.getPassword());
        return ResponseEntity.ok(EntityDTOManager.toDto(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDto user)
    {
        validateUserDetails(user);
        User savedUser = userService.login(user.getEmail(),user.getPassword());
        return ResponseEntity.ok(EntityDTOManager.toDto(savedUser));
    }

    @PostMapping("/addFriend")
    public ResponseEntity addFriend(@RequestBody UserAddFriendDto dto)
    {
        User user = userService.getById(dto.getUserId());
        User friend = userService.getById(dto.getFriendId());
        user.getFriends().add(friend);
        friend.getFriends().add(user);
        userService.saveUser(user);
        userService.saveUser(friend);
        return ResponseEntity.ok(EntityDTOManager.toDto(user));
    }

    private void validateUserDetails(UserRegistrationRequestDto user)
    {
        if(user.getEmail() == null || user.getName() == null || user.getPassword() == null)
        {
            throw new UserRegistrationInvalidData("Invalid signup data");
        }

        if(!EmailValidator.isValidEmail(user.getEmail()))
        {
            throw new UserRegistrationInvalidData("Invalid email");
        }

        if(!PasswordValidator.isValidPassword(user.getPassword()))
        {
            throw new UserRegistrationInvalidData("Invalid password");
        }
    }

    private void validateUserDetails(UserLoginRequestDto user)
    {
        if(user.getEmail() == null || user.getPassword() == null)
        {
            throw new UserRegistrationInvalidData("Invalid signup data");
        }

        if(!EmailValidator.isValidEmail(user.getEmail()))
        {
            throw new UserRegistrationInvalidData("Invalid email");
        }

        if(!PasswordValidator.isValidPassword(user.getPassword()))
        {
            throw new UserRegistrationInvalidData("Invalid password");
        }
    }
}
