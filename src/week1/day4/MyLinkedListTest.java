package week1.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void size() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        assertEquals(3, myLinkedList.size());
    }

    @Test
    void add() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
        myLinkedList.add("First");
        myLinkedList.add("Second");
        myLinkedList.add("Third");
        assertEquals("First, Second, Third", myLinkedList.toString());
    }

    @Test
    void remove() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.add(5);
        myLinkedList.add(13);
        myLinkedList.add(1);
        myLinkedList.add(7);
        assertEquals("5, 13, 1, 7", myLinkedList.toString());
        myLinkedList.remove(13);
        assertEquals("5, 1, 7", myLinkedList.toString());
        assertNotEquals("5, 13, 1, 7", myLinkedList.toString());
    }

    @Test
    void replace() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.add(5);
        myLinkedList.add(13);
        myLinkedList.add(1);
        myLinkedList.add(7);
        myLinkedList.replace(13, 15);
        assertEquals("5, 15, 1, 7", myLinkedList.toString());
    }
}