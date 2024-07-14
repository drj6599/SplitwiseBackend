package dev.dheeraj.splitwise.controller;

import dev.dheeraj.splitwise.dto.createGroupDto;
import dev.dheeraj.splitwise.entity.Group;
import dev.dheeraj.splitwise.mapper.EntityDTOManager;
import dev.dheeraj.splitwise.service.GroupService.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/createGroup")
    public ResponseEntity createGroup(@RequestBody createGroupDto groupName){
        Group newGroup = groupService.createGroup(groupName.getName());
        return ResponseEntity.ok(EntityDTOManager.toGroupDto(newGroup));
    }
}
