package dev.dheeraj.splitwise.service.GroupService;

import dev.dheeraj.splitwise.entity.Group;
import dev.dheeraj.splitwise.entity.SettlementTransaction;
import dev.dheeraj.splitwise.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<SettlementTransaction> settleUp(int groupId) {
        return List.of();
    }

    @Override
    public Group createGroup(String groupName) {
        Group newGroup = new Group();
        newGroup.setName(groupName);
        newGroup.setExpenses(new ArrayList<>());
        newGroup.setMembers(new ArrayList<>());
        newGroup.setSettlementTransactions(new ArrayList<>());
        newGroup.setTotalAmountSpent(0);
        return groupRepository.save(newGroup);
    }
}
