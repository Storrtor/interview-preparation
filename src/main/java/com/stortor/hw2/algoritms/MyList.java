package com.stortor.hw2.algoritms;

public interface MyList<E> {

    void add(E value);

    boolean remove(int index);

    boolean isEmpty();

    int size();

    boolean contains(E value);

    E get(int index);


}
