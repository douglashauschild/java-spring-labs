package com.github.douglashauschild.java24;

import java.lang.ScopedValue;

public class ScopedValuesDemo {
	
	static final ScopedValue<String> LOGGED_USER = ScopedValue.newInstance();

    public static void main(String[] args) {
        ScopedValue.where(LOGGED_USER, "Douglas").run(() -> {
            logAccess();
        });
    }

    private static void logAccess() {
        String user = LOGGED_USER.get();
        System.out.println("Logged user: " + user);
    }
}
