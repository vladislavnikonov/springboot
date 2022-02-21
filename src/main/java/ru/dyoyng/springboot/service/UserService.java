package ru.dyoyng.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.dyoyng.springboot.entity.UserEntity;
import ru.dyoyng.springboot.exception.UserAlredyExistExseption;
import ru.dyoyng.springboot.exception.UserNotFindException;
import ru.dyoyng.springboot.exception.UsersNotFindException;
import ru.dyoyng.springboot.model.User;
import ru.dyoyng.springboot.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity registration(UserEntity userEntity) throws UserAlredyExistExseption {
        if (userRepository.findByUsername(userEntity.getUsername()) != null)
            throw new UserAlredyExistExseption("user has been");
        userRepository.save(userEntity);
        return ResponseEntity.ok().body("user registration");
    }

    public User getUser(long id) throws UserNotFindException {
        UserEntity userEntity = userRepository.findById(id).get();
        if (userEntity == null)
            throw new UserNotFindException("user not find");
//        return User.getOne(userEntity);
        return new User(userEntity);
    }

    public List<User> getUsers() throws UsersNotFindException {
        List<User> users = new ArrayList<>();
        Iterable<UserEntity> entities = userRepository.findAll();
        if (entities == null)
            throw new UsersNotFindException("users not find");
        for (UserEntity userEntity : entities)
            users.add(new User(userEntity));
        return users;
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
