package com.fitflow.fitflowbackend.service;

import com.fitflow.fitflowbackend.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User userDetails);
    boolean deleteUser(Long id);
}
