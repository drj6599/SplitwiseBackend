package dev.dheeraj.splitwise.service;

import dev.dheeraj.splitwise.entity.Group;
import dev.dheeraj.splitwise.entity.User;
import dev.dheeraj.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User signup(String name, String email, String password) {
        User user = new User();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setFriends(new ArrayList<User>());
        user.setGroups(new ArrayList<Group>());
        return userRepository.save(user);
    }

    @Override
    public User getById(int userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public void saveUser(User user) {
        User savedUser = userRepository.save(user);
    }
}
