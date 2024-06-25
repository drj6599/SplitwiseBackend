package dev.dheeraj.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserLoginResponseDto {
    private int Id;
    private String name;
    private String email;
    private List<UserFriendResponseDto> friendList;
    private List<UserGroupResponseDto> groupList;
}
