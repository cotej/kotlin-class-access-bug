package com.cotej.accessbug.lower;

public class Lower {

    private final String _message;

    private Lower(String message) {
        _message = message;
    }

    public static Lower getInstance(String message) {
        return new Lower(message);
    }

    @Override
    public String toString() {
        return "lower: " + _message;
    }
}
