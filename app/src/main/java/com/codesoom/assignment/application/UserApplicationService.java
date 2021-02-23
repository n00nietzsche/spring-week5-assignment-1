package com.codesoom.assignment.application;

import com.codesoom.assignment.domain.User;
import com.codesoom.assignment.domain.UserRepository;

public class UserApplicationService {
    private UserRepository userRepository;

    public UserApplicationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String mail, String password) {
        Long id = userRepository.nextId();
        User user = new User(id, name, mail, password);

        userRepository.save(user);
        return user;
    }

    public User changeName(Long id, String newName) {
        User user = userRepository.findById(id).get();
        user.changeName(newName);
        userRepository.save(user);
        return user;
    }
}
