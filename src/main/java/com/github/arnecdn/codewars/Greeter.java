package com.github.arnecdn.codewars;

public class Greeter {
    public static String greet(String name) {

        return (name.equals("Johnny")) ? "Hello, my love!" : String.format("Hello, %s!", name);
    }
}
