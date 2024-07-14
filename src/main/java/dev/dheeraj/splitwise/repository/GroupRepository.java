package dev.dheeraj.splitwise.repository;

import dev.dheeraj.splitwise.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    Group findByName(String name);
}
