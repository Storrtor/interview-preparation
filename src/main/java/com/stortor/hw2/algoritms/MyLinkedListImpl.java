package com.stortor.hw2.algoritms;

public class MyLinkedListImpl<E> implements LinkedList<E>{
    protected int size;
    protected Node<E> first;
    protected Node<E> last;

    @Override
    public void insertFirst(E value) {
        Node<E> actualFirst = first;
        Node<E> newFirst = new Node<>(value, actualFirst);
        this.first = newFirst;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return removedNode.item;
    }

    @Override
    public boolean remove(int index) {
        Node<E> prev = null;
        Node<E> current = first;

        while (current != null) {
            if (current.item.equals(index)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == first) {
            removeFirst();
            return true;
        }
        if (current == last) {
            last = prev;
            last.next = null;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    private Node<E> indexOf(E value) {
        Node<E> current = first;

        while (current != null) {
            if (current.item.equals(value)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        last.next = last  = new Node<>(value, null);
        size++;
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public E getLast() {
        return last.item;
    }


    @Override
    public void add(E value) {
        insertLast(value);
    }

    @Override
    public E get(int index) {
        if (index > size / 2) {
            int count = 0;
            Node<E> current = first;
            while (index != count) {
                current = current.next;
                count++;
            }
            return current.item;
        } else {
            int count = size;
            Node<E> current = last;
            while (index != count) {
                current = current.next;
                count--;
            }
            return current.item;
        }
    }




}
