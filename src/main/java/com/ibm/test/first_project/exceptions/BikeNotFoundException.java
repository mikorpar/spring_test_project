package com.ibm.test.first_project.exceptions;

public class BikeNotFoundException extends Exception{
    public BikeNotFoundException() {
        super();
    }

    public BikeNotFoundException(String message) {
        super(message);
    }
}
