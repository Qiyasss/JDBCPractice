package com.example.jdbcpractice2.service;

import com.example.jdbcpractice2.dao.User;
import com.example.jdbcpractice2.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void update(User user, Long id) {
    userRepository.update(user, id);
    }

    @Override
    public void delete(Long id) {
     userRepository.delete(id);
    }
}
