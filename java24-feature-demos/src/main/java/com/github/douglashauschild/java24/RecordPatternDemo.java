package com.github.douglashauschild.java24;

public class RecordPatternDemo {
	
	record User(String name, int age) {}

    public static void main(String[] args) {
        User user = new User("Douglas", 30);

        if (user instanceof User(String name, int age) && age > 18) {
            System.out.println(name + " is an adult");
        }
    }
}
