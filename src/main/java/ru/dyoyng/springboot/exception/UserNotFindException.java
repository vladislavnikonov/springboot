package ru.dyoyng.springboot.exception;

public class UserNotFindException extends Exception {
    public UserNotFindException(String message) {
        super(message);
    }
}
