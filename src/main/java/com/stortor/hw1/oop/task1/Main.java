package com.stortor.hw1.oop.task1;

public class Main {
    public static void main(String[] args) {
        Person.PersonBuilder personBuilder = new Person.PersonBuilder();
        Person person = personBuilder.setPhone("44444").setAddress("Moscow").build();
        System.out.println(person);
    }
}
