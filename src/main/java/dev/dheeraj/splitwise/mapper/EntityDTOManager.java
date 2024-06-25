package dev.dheeraj.splitwise.mapper;

import dev.dheeraj.splitwise.dto.UserFriendResponseDto;
import dev.dheeraj.splitwise.dto.UserGroupResponseDto;
import dev.dheeraj.splitwise.dto.UserLoginResponseDto;
import dev.dheeraj.splitwise.entity.Group;
import dev.dheeraj.splitwise.entity.User;

import java.util.ArrayList;
import java.util.List;

public class EntityDTOManager {
    public static UserLoginResponseDto toDto(User user)
    {
        UserLoginResponseDto dto = new UserLoginResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        List<UserFriendResponseDto> friendList = new ArrayList<>();
        for(User friend : user.getFriends())
        {
            friendList.add(toFriendDto(friend));
        }
        dto.setFriendList(friendList);
        List<UserGroupResponseDto> groupList = new ArrayList<>();
        for (Group group : user.getGroups())
        {
            groupList.add(toGroupDto(group));
        }
        dto.setGroupList(groupList);
        return dto;
    }

    public static UserFriendResponseDto toFriendDto(User user){
        UserFriendResponseDto dto = new UserFriendResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        return dto;
    }

    public static UserGroupResponseDto toGroupDto(Group group){
        UserGroupResponseDto dto = new UserGroupResponseDto();
        dto.setId(group.getId());
        dto.setName(group.getName());
        dto.setNumberOfMembers(group.getMembers().size());
        return dto;
    }
}
