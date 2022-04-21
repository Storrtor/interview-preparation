package com.stortor.hw1.oop.task3;

public class Main {
    public static void main(String[] args) {
        Figure circle = new Circle();
        Figure square = new Square();
        Figure triangle = new Triangle();

        Figure[] figures = new Figure[]{circle, square, triangle};
        for (int i = 0; i < figures.length; i++) {
            figures[i].printFigure();
        }
    }
}
