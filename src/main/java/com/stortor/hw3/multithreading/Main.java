package com.stortor.hw3.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private String previousWord = "pong";
    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
//        main.writePingPong();
        main.count();

    }

    public void writePingPong() {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    if (previousWord.equals("pong")) {
                        lock.notifyAll();
                        try {
                            System.out.println("ping");
                            previousWord = "ping";
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    if (previousWord.equals("ping")) {
                        lock.notifyAll();
                        try {
                            System.out.println("pong");
                            previousWord = "pong";
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

    public void count() throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter.inc();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter.dec();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counter = " + counter.value());

    }


}
