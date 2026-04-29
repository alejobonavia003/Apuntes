import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublyLinkedListTest {

    @Test
    public void testGet0() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(10, list.get(0));
        assertEquals("[10, 20, 30]", list.toString());
    }

    @Test
    public void testGet1() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(20, list.get(1));
        assertEquals("[10, 20, 30]", list.toString());
    }

    @Test
    public void testGet2() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(30, list.get(2));
        assertEquals("[10, 20, 30]", list.toString());
    }

    @Test
    public void testAddAtIndexBeginning() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        assertEquals("[10]", list.toString());
    }

    @Test
    public void testAddAtIndexEnd() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 30);
        assertEquals("[10, 30]", list.toString());
    }

    @Test
    public void testAddAtIndexMiddle() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 30);
        list.add(1, 20);
        assertEquals("[10, 20, 30]", list.toString());
    }

    @Test
    public void testAddAtIndexBeginningAgain() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(0, 5);
        assertEquals("[5, 10, 20, 30]", list.toString());
    }

    @Test
    public void testAddAtIndexEndAgain() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        assertEquals("[10, 20, 30, 40]", list.toString());
    }

    @Test
    public void testRemoveHead() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        list.remove(0);
        assertEquals("[20, 30, 40]", list.toString());
    }

    @Test
    public void testRemoveMedium() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        list.remove(2);
        assertEquals("[10, 20, 40]", list.toString());
    }

    @Test
    public void testRemoveTail() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        list.remove(3);
        assertEquals("[10, 20, 30]", list.toString());
    }

    @Test
    public void testIndexOf() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        int result = list.indexOf(list.get(3));
        assertEquals(3, result);
    }
    @Test


    public void testRemoveTaile() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        list.remove(list.get(3));
        assertEquals("[10, 20, 30]", list.toString());
    }



}
