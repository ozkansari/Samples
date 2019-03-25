package com.ozkansari.java8;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;

public class UserBuilderSample {
    public static void main(String[] args) {
        User u = User.builder().firstName("Jane").lastName("Doe").age(99);
        System.out.println("..." + u);
    }
}
// Partial function application and the Builder pattern to construct a User instance
class User {
    private String firstName;
    private String lastName;
    private int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String toString() {
        return firstName + " " + lastName + " " + age;
    }

    public static FirstName builder() {
        return firstName - > lastName - > age - > new User(firstName, lastName, age);
    }
    protected interface FirstName {
        LastName firstName(String firstName);
    }
    protected interface LastName {
        Age lastName(String lastName);
    }
    protected interface Age {
        User age(int age);
    }
}
