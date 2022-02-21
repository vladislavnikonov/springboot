package ru.dyoyng.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dyoyng.springboot.entity.UserEntity;
import ru.dyoyng.springboot.exception.UserAlredyExistExseption;
import ru.dyoyng.springboot.exception.UserNotFindException;
import ru.dyoyng.springboot.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    public UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable long id) {
        try {
            return ResponseEntity.ok().body(userService.getUser(id));
        } catch (UserNotFindException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping()
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok().body(userService.getUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity registration(@RequestBody UserEntity userEntity) {
        try {
            userService.registration(userEntity);
            return ResponseEntity.ok("User good");
        } catch (UserAlredyExistExseption ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User not registration");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok("User delete");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("errror");
        }
    }
}
