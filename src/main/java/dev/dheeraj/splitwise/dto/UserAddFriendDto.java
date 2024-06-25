package dev.dheeraj.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddFriendDto {
    private int userId;
    private int friendId;
}
