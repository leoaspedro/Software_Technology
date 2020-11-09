package FIFO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedQueueTest {
    private FIFO.LinkedQueue QInt;
    private FIFO.LinkedQueue QString;


    @BeforeEach
    void StartMethod() {
        QInt = new LinkedQueue<Integer>();
        QString = new LinkedQueue<String>();
    }


    @Test
    public void testsize() {
        QInt.enqueue(1);
        assertEquals(1, QInt.size());//Expecting a return of 1

        QInt.enqueue(2);
        QInt.enqueue(3);
        QInt.enqueue(4);
        assertEquals(4, QInt.size()); //Expecting a return of 4
    }

    @Test
    public void testisEmpty() {
        assertEquals(true, QInt.isEmpty());

        QInt.enqueue(new Object());
        assertEquals(false, QInt.isEmpty());

        QInt.dequeue();
        assertEquals(true, QInt.isEmpty());
    }

    @Test
    public void testenqueue() {
        QString.enqueue("Element 1");
        assertEquals("Element 1", QString.first());

        QString.enqueue("Element 2");
        QString.enqueue("Element 3");
        QString.enqueue("Element 4");
        assertEquals("Element 4", QString.last());
        assertEquals("Element 1", QString.first());
    }

    @Test
    public void testdequeue() {

        try {
            QString.dequeue();

        } catch (RuntimeException e) {
            assertTrue(true);
        }
        QString.enqueue("Hello");
        Object Obj1 = QString.dequeue();
        assertEquals(Obj1, "Hello");

        QString.enqueue("It's");
        QString.enqueue("Me!!!");
        QString.enqueue("Java");
        Object Obj2 = QString.dequeue();
        Object Obj3 = QString.dequeue();
        assertEquals(Obj2, "It's");
        assertEquals(Obj3, "Me!!!");

        QString.dequeue();
        assertEquals(true, QString.isEmpty());
    }

    @Test
    public void testfirst() {
        try {
            QInt.first();
        } catch (RuntimeException e) {
            assertTrue(true);
        }
        QInt.enqueue(1);
        QInt.enqueue(2);
        QInt.enqueue(3);
        QInt.enqueue(4);
        assertEquals(1, QInt.first());
        QInt.dequeue();
        QInt.dequeue();
        assertEquals(3, QInt.first());
    }

    @Test
    public void testlast() {
        try {
            QInt.last();
        } catch (RuntimeException e) {
            assertTrue(true);
        }
        QInt.enqueue(1);
        QInt.enqueue(2);
        assertEquals(2, QInt.last()); //Check if the last is equals to "2"

        QInt.enqueue(3);
        QInt.enqueue(4);
        QInt.enqueue(5);
        assertEquals(5, QInt.last());

        QInt.dequeue();
        assertEquals(5, QInt.last());
    }

    @Test
    public void testtoString() {
        QString.enqueue("element 1");
        QString.enqueue("element 2");
        QString.enqueue("element 3");
        String str = "Queue: element 1 element 2 element 3 ";
        assertEquals(str, QString.toString());
    }

    @Test
    public void testIterator() {
        Iterator<Object> it = QString.iterator();

        assertEquals(false, it.hasNext());

        boolean check = false;
        try {
            it.next();
        } catch (NullPointerException e) {
            assertTrue(true);
        }

        QString.enqueue("First Element");
        it = QString.iterator();
        assertTrue(it.hasNext());
        assertEquals("First Element", it.next());
        QString.enqueue("Second Element");
        QString.enqueue("Third Element");
        QString.enqueue("Fourth Element");
        it = QString.iterator();
        it.next();
        assertEquals("Second Element", it.next());
        assertEquals("Third Element", it.next());
        assertEquals("Fourth Element", it.next());
    }
}

