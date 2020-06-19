package com.test.azure.restexample;

class Greeting {

    private String message;

    // Required for JSON deserialization
    Greeting() {
    }

    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
