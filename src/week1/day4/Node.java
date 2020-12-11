package week1.day4;

class Node<T> {

    private T data;
    private Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }

    public void setData(T data) {
        this.data = data;
    }

    T getData() {
        return this.data;
    }

    void setNext(Node next) {
        this.next = next;
    }

    Node getNext() {
        return this.next;
    }
}
