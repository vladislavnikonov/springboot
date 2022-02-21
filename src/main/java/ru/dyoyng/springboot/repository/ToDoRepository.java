package ru.dyoyng.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dyoyng.springboot.entity.ToDoEntity;
import ru.dyoyng.springboot.model.ToDo;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDoEntity, Long> {
}
