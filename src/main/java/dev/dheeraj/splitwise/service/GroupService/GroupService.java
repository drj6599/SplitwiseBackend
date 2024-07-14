package dev.dheeraj.splitwise.service.GroupService;

import dev.dheeraj.splitwise.entity.Group;
import dev.dheeraj.splitwise.entity.SettlementTransaction;

import java.util.List;

public interface GroupService {
    List<SettlementTransaction> settleUp(int groupId);

    Group createGroup(String groupName);
}
