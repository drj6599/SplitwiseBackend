package dev.dheeraj.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequestDto {
    private String name;
    private String email;
    private String password;
}
