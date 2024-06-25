package dev.dheeraj.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGroupResponseDto {
    private int id;
    private String name;
    private int numberOfMembers;
}
