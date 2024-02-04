package com.example.jdbcpractice2.dao;

import lombok.RequiredArgsConstructor;

import java.util.List;


public interface UserRepository {

    void save (User user);

    User getById(Long id);

    List<User> getAll ();

    void update (User user, Long id);

    void delete (Long id);
}
