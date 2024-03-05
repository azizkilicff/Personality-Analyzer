package org.example;

public class InvalidPersonalityException extends RuntimeException{
    public InvalidPersonalityException() {
        super("Person not found");
    }

}
