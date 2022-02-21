package ru.dyoyng.springboot.entity;

import ru.dyoyng.springboot.model.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
    private List<ToDoEntity> todos;

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ToDoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<ToDoEntity> todos) {
        this.todos = todos;
    }
}
