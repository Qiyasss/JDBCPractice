package com.example.jdbcpractice2.controller;

import com.example.jdbcpractice2.dao.User;
import com.example.jdbcpractice2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(CREATED)
    void create (@RequestBody  User user){
        userService.create(user);
    }

    @GetMapping("/{id}")
    User getById (@PathVariable Long id){
      return userService.getById(id);
    }

    @GetMapping
    List<User> getAll(){
        return userService.getAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    void update(@RequestBody User user, @PathVariable Long id){
        userService.update(user, id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
