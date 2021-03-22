package com.github.cliffdurden.jmh.example;

public class StringConcatenation {

    private StringConcatenation() {
        throw new RuntimeException("Utility class");
    }

    public static String stringAdd(String i) {
        return "Result: " + i;
    }

    public static String stringFormat(String i) {
        return String.format("Result: %s", i);
    }

    public static String stringConcat(String i) {
        return "Result: ".concat(i);
    }
}
