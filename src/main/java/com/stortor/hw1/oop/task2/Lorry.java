package com.stortor.hw1.oop.task2;

// extends от классов, implements от интерфейсов
class Lorry extends Car implements Moveable, Stopable {

    public void move(){
        System.out.println("Car is moving");
    }
    public void stop(){
        System.out.println("Car is stop");
    }

    // обязательно переопределить абстрактный метод класса
    @Override
    void open() {

    }
}
