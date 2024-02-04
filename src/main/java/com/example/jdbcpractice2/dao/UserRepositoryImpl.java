package com.example.jdbcpractice2.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements  UserRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into users(id, name, surname, age) values (?,?,?,?)",
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getAge());
    }

    @Override
    public User getById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from users where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        new User(

                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("surname"),
                                rs.getInt("age")
                        ));
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query(
                "select * from users ",
                new Object[]{},
                (rs, rowNum) ->
                        new User(

                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("surname"),
                                rs.getInt("age")
                        ));
    }

    @Override
    public void update(User user, Long id) {
        jdbcTemplate.update("update users set name = ? where id = ?",
                user.getName(), id) ;

    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from users where id= ?", id);
    }
}
