



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

/**
 * The test class CircularQueueTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CircularQueueTest
{
    //test empty constructor con repOk
    @Test
    public void test0() {
        Queue<Integer> queue = new CircularQueue<Integer>();
        assertTrue(queue.repOK());
    }
    
    //test empty constructor con toString
    @Test
    public void test1() {
        Queue<Integer> queue = new CircularQueue<Integer>();
        assertEquals("[]", queue.toString());
    }
    
    //test isEmpty con empty constructor
    @Test
    public void test2() {
        Queue<Integer> queue = new CircularQueue<Integer>();
        assertTrue(queue.isEmpty());
    }

    //test size() con empty constructor
    @Test
    public void test3() {
        Queue<Integer> queue = new CircularQueue<Integer>();
        assertEquals(0,queue.size());
    }
    
    //test enqueue con 1 elemento y repOk
    @Test
    public void test4() {
        Queue<Integer> queue = new CircularQueue<Integer>();
        queue.enqueue(1);
        assertTrue(queue.repOK());
    }

    //test enqueue con 1 elemento y la estructura interna
    @Test
    public void test5() {
        CircularQueue<Integer> queue = new CircularQueue<Integer>();
        queue.enqueue(1);
        Integer[] res = new Integer[] {1, null, null, null, null, null, null, null};
        assertArrayEquals(res, queue.queue);
    }

    //test enqueue con 100 elementos y repOk
    @Test
    public void test6() {
        Queue<Integer> queue = new CircularQueue<Integer>();
        for(int i = 0; i < 100; i++) {
            queue.enqueue(i);
        }
        assertTrue(queue.repOK());
    }
//test enqueue con 100 elementos y size()
    @Test
    public void test7() {
        Queue<Integer> queue = new CircularQueue<Integer>();
        for(int i = 0; i < 100; i++) {
            queue.enqueue(i);
        }
        assertEquals(100,queue.size());
    }
//test enqueue/resize con INIT_CAPACITY elementos y estructura interna
    @Test
    public void test8() {
        CircularQueue<Integer> queue = new CircularQueue<Integer>();
        Integer[] res = new Integer[CircularQueue.INIT_CAPACITY * 2];
        for(int i = 0; i <= CircularQueue.INIT_CAPACITY; i++) {
            queue.enqueue(i);
            res[i] = i;
        }
        assertArrayEquals(res, queue.queue);
    }
//test enqueue/resize con INIT_CAPACITY elementos y size
    @Test
    public void test9() {
        Queue<Integer> queue = new CircularQueue<Integer>();
        for(int i = 0; i <= CircularQueue.INIT_CAPACITY; i++) {
            queue.enqueue(i);
        }
        assertEquals(CircularQueue.INIT_CAPACITY + 1,queue.size());
    }
//test dequeue y repOk
    @Test
    public void test10() {
        Queue<Integer> queue = new CircularQueue<Integer>();
        queue.enqueue(1);
        queue.dequeue();
        assertTrue(queue.repOK());
    }
//test dequeue 1 y estruct interna    
    @Test
    public void test11() {
        CircularQueue<Integer> queue = new CircularQueue<Integer>();
        queue.enqueue(1);
        queue.dequeue();
        Integer[] res = new Integer[] {null, null, null, null, null, null, null, null};
        assertArrayEquals(res, queue.queue);
    }
   
    //test dequeue 1 y size
    @Test
    public void test12() {
        Queue<Integer> queue = new CircularQueue<Integer>();
        queue.enqueue(1);
        queue.dequeue();
        assertEquals(0, queue.size());
    }
//test dequeue 2 y estruct interna    
    @Test
    public void test13() {
        CircularQueue<Integer> queue = new CircularQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        Integer[] res = new Integer[] {null, 2, null, null, null, null, null, null};
        assertArrayEquals(res, queue.queue);
    }
  
    //test dequeue casi todos y estruct interna 
    @Test
    public void test14() {
        CircularQueue<Integer> queue = new CircularQueue<Integer>();
        for(int i = 0; i < CircularQueue.INIT_CAPACITY; i++) {
            queue.enqueue(i);
        }
        for(int i = 0; i < CircularQueue.INIT_CAPACITY -1; i++) {
            queue.dequeue();
        }
        Integer[] res = new Integer[] {null, null, null, null, null, null, null, 7};
        assertArrayEquals(res, queue.queue);
    }
    
    //test toString libres
    @Test
    public void test15() {
        CircularQueue<Integer> queue = new CircularQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8]", queue.toString());
    }
    
    //test toString libres
    @Test
    public void test16() {
        CircularQueue<Integer> queue = new CircularQueue<Integer>();
        for(int i = 0; i < CircularQueue.INIT_CAPACITY; i++) {
            queue.enqueue(i);
        }
        for(int i = 0; i < CircularQueue.INIT_CAPACITY -1; i++) {
            queue.dequeue();
        }
        assertEquals("[7]", queue.toString());
    }

    @Test
    public void test17() {
        CircularQueue<Integer> queue = new CircularQueue<Integer>();
        for(int i = 0; i < CircularQueue.INIT_CAPACITY; i++) {
            queue.enqueue(i);
        }
        for(int i = 0; i < CircularQueue.INIT_CAPACITY ; i++) {
            queue.dequeue();
        }
        assertThrows(NoSuchElementException.class,
                () -> queue.dequeue());
    }  
    
}
