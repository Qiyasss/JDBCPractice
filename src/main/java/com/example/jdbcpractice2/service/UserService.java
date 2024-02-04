package com.example.jdbcpractice2.service;

import com.example.jdbcpractice2.dao.User;

import java.util.List;

public interface UserService {

    void create (User user);

    User getById (Long id);

    List<User> getAll();

    void update(User user, Long id);

    void delete(Long id);

}
