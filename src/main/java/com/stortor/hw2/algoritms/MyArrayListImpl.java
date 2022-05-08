package com.stortor.hw2.algoritms;

public class MyArrayListImpl<E> implements ArrayList<E> {

    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    @Override
    public void add(E value) {
        if (pointer == array.length - 1)
            resize(array.length * 2);
        array[pointer++] = value;
    }

    @Override
    public boolean remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2);

        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public boolean contains(E value) {
        return false;
    }

    @Override
    public E get(int index) {
        return (E) array[index];
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
