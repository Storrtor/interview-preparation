package com.stortor.hw2.algoritms;

public interface LinkedList<E> extends MyList<E>{

    boolean contains(E value);

    void insertFirst(E value);

    E removeFirst();

    void insertLast(E value);

    E getLast();

    E getFirst();

    class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
