package ru.dyoyng.springboot.exception;

public class UsersNotFindException extends Exception {
    public UsersNotFindException(String message) {
        super(message);
    }
}
