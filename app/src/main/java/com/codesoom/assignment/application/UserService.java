package com.codesoom.assignment.application;

import com.codesoom.assignment.domain.User;
import com.codesoom.assignment.domain.UserRepository;
import com.codesoom.assignment.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User update(Long id, User updateUser) {
        User originUser = get(id);
        modelMapper.map(updateUser, originUser);
        return originUser;
    }

    public void delete(Long id) {
        userRepository.delete(get(id));
    }
}
