package com.cotej.accessbug.upper;

import com.cotej.accessbug.lower.Lower;

public class Upper {

    private final Lower _lower;

    private Upper(Lower lower) {
        _lower = lower;
    }

    public static Upper getInstance(Lower lower) {
        return new Upper(lower);
    }

    @Override
    public String toString() {
        return "UPPER: " + _lower;
    }
}
