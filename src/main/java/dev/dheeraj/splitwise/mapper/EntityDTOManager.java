package dev.dheeraj.splitwise.mapper;

import dev.dheeraj.splitwise.dto.*;
import dev.dheeraj.splitwise.entity.Expense;
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

    public static GroupResponseDto toGroupDto(Group group){
        GroupResponseDto dto = new GroupResponseDto();
        dto.setName(group.getName());
        dto.setTotalAmountSpent(group.getTotalAmountSpent());
        dto.setExpenses(group.getExpenses());
        dto.setMembers(group.getMembers());
        return dto;
    }

    public static ExpenseResponseDto toExpenseResponseDto(Expense expense) {
        ExpenseResponseDto dto = new ExpenseResponseDto();
        dto.setAmount(expense.getAmount());
        dto.setExpenseTime(expense.getExpenseTime());
        dto.setDescription(expense.getDescription());
        return dto;
    }
}
