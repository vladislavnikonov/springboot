package ru.dyoyng.springboot.model;

import ru.dyoyng.springboot.entity.ToDoEntity;

public class ToDo {
    private Long id;
    private String title;
    private Boolean completed;
    private String creator;

    public ToDo() {
    }

    public ToDo(ToDoEntity toDoEntity) {
        this.id = toDoEntity.getId();
        this.title = toDoEntity.getTitle();
        this.completed = toDoEntity.getCompleted();
        this.creator = toDoEntity.getUser().getUsername();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
