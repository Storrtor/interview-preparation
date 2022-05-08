package com.stortor.hw3.multithreading;

public class Counter {
    private int num;

    public synchronized void inc() {
        num++;
    }

    public synchronized void dec() {
        num--;
    }

    public synchronized int value() {
        return num;
    }
}
