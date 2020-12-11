package week1.day4;

import java.util.LinkedList;
import java.util.NoSuchElementException;

class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    MyLinkedList() {
        this.first = this.last = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    void add(T data) {
        Node<T> node = new Node(data);
        if (this.first == null) {
            this.first = this.last = node;
        }else{
            this.last.setNext(node);
            this.last = node;
        }
        this.size++;
    }

//    void replace(T name, T data) {
//        Node<T> node = new Node(data);
//        if (this.first == null) {
//            throw new NoSuchElementException();
//        } else if (this.first.getData().equals(name)) {
//            this.first = this.first.getNext();
//            return;
//        }
//        Node<T> current = this.first;
//        Node<T> next = current.getNext();
//        if (next.getData().equals(name)) {
//            current.setNext(node);
//
//            if (node.getNext() == null) {
//                this.last = current;
//            }
//
//        }
//
//    }

    void remove(T data) {
        if (this.first == null) {
            throw new NoSuchElementException();
        } else if (this.first.getData().equals(data)) {
            this.first = this.first.getNext();
            this.size--;
            return;
        }

        Node<T> current = this.first;
        Node<T> next = current.getNext();
        while (next != null) {
            if (next.getData().equals(data)) {
                current.setNext(next.getNext());
                if (current.getNext() == null) {
                    this.last = current;
                }
                this.size--;
                return;
            }
            current = next;
            next = current.getNext();
        }

    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        Node<T> current = this.first;
        while (current != null) {
            builder.append(current.getData());

            if (current.getNext() != null) {
                builder.append(", ");
            }

            current = current.getNext();
        }


        return builder.toString();
    }
}
