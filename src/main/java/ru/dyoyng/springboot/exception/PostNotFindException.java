package ru.dyoyng.springboot.exception;

public class PostNotFindException extends Exception {
    public PostNotFindException(String message) {
        super(message);
    }
}
