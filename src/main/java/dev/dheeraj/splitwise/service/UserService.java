package dev.dheeraj.splitwise.service;

import dev.dheeraj.splitwise.entity.User;

public interface UserService {
    User signup(String name, String email, String password);
}