package com.github.douglashauschild.java24;

public class PatternMatchingDemo {
    public static void main(String[] args) {
        Object value = "Java 24 is here!";

        switch (value) {
            case String s -> System.out.println("It's a string: " + s.toUpperCase());
            case Integer i -> System.out.println("It's an integer: " + (i * 2));
            default -> System.out.println("Unsupported type");
        }
    }
}