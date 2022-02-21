package ru.dyoyng.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dyoyng.springboot.entity.ToDoEntity;
import ru.dyoyng.springboot.exception.PostNotFindException;
import ru.dyoyng.springboot.service.ToDoService;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    private ToDoService toDoService;

    @Autowired
    public void setToDoService(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody ToDoEntity toDoEntity, @RequestParam Long id) {
        toDoService.create(toDoEntity, id);
        return  ResponseEntity.ok("Post created");
    }

    @GetMapping("/{id}")
    public ResponseEntity getPost(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(toDoService.getPost(id));
        } catch (PostNotFindException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erooor");
        }
    }

    @GetMapping()
    public ResponseEntity getPosts() {
        try {
            return ResponseEntity.ok().body(toDoService.getPosts());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erooor");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePost(@PathVariable Long id, @RequestBody ToDoEntity toDoEntity) {
        try {
            return ResponseEntity.ok().body(toDoService.updatePost(id, toDoEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erooor");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            toDoService.delete(id);
            return ResponseEntity.ok("Post delete");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("errror");
        }
    }
}
