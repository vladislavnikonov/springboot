package ru.dyoyng.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dyoyng.springboot.entity.ToDoEntity;
import ru.dyoyng.springboot.entity.UserEntity;
import ru.dyoyng.springboot.exception.PostNotFindException;
import ru.dyoyng.springboot.model.ToDo;
import ru.dyoyng.springboot.model.User;
import ru.dyoyng.springboot.repository.ToDoRepository;
import ru.dyoyng.springboot.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private UserRepository userRepository;
    private ToDoRepository toDoRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setToDoRepository(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public void create(ToDoEntity toDoEntity, Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        toDoEntity.setUser(userEntity);
        toDoRepository.save(toDoEntity);
    }

    public ToDo getPost(Long id) throws PostNotFindException{
        if (toDoRepository.findById(id) == null)
            throw new PostNotFindException("Post not find");
        ToDoEntity toDoEntity = toDoRepository.findById(id).get();
        return new ToDo(toDoEntity);
    }

    public List<ToDo> getPosts() {
        List<ToDo> todos = new ArrayList<>();
        Iterable<ToDoEntity> entities = toDoRepository.findAll();
        for (ToDoEntity todo : entities)
            todos.add(new ToDo(todo));
        return todos;
    }

    public ToDo updatePost(Long id, ToDoEntity toDoEntity) {
        ToDoEntity updatedPost = toDoRepository.findById(id).get();
        updatedPost.setCompleted(toDoEntity.getCompleted());
//        updatedPost.setTitle(toDoEntity.getTitle());
        return new ToDo(updatedPost);
    }

    public void delete(long id) {
        toDoRepository.deleteById(id);
    }
}
