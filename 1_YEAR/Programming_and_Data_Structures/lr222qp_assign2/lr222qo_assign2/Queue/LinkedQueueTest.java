package lr222qo_assign2.Queue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedQueueTest {
private LinkedQueue MyLQ;


@BeforeEach
	public void start(){
	MyLQ = new LinkedQueue();
}

@Test
	public void testSize(){
	MyLQ.enqueue(new Object());
	assertEquals(1,MyLQ.size());

	MyLQ.enqueue(new Object());
	MyLQ.enqueue(new Object());
	assertEquals(3,MyLQ.size());
}
@Test
	public void testEmpty(){
	assertEquals(true,MyLQ.isEmpty());

	MyLQ.enqueue(new Object());
	assertEquals(false,MyLQ.isEmpty());

	MyLQ.dequeue();
	assertEquals(true,MyLQ.isEmpty());
}
	@Test
	public void testEnqueue() {
		MyLQ.enqueue("Element 1");
		assertEquals("Element 1", MyLQ.first());

		MyLQ.enqueue("Element 2");
		MyLQ.enqueue("Element 3");

		assertEquals("Element 3", MyLQ.last());
		assertEquals("Element 1", MyLQ.first());
	}
	@Test
	public void testDequeue(){

		try{
			MyLQ.dequeue();
		}catch(NullPointerException e){
			assertTrue(true);
		}
		MyLQ.enqueue("Leonardo");
		Object Name = MyLQ.dequeue();
		assertEquals(Name,"Leonardo");

		MyLQ.enqueue("Rochinha");
		MyLQ.enqueue("Pedro");

		Object Name2 = MyLQ.dequeue();
		Object Name3 = MyLQ.dequeue();

		assertEquals(Name2,"Rochinha");
		assertEquals(Name3,"Pedro");

		MyLQ.dequeue();
		assertEquals(true,MyLQ.isEmpty());
	}
	@Test
	public void testFirst(){
		try{
			MyLQ.first();
		}catch (NoSuchElementException e){
			assertTrue(true);
		}
		MyLQ.enqueue(1);
		MyLQ.enqueue(2);
		MyLQ.enqueue(3);
		MyLQ.enqueue(4);

		assertEquals(1,MyLQ.first());
		MyLQ.dequeue();
		MyLQ.dequeue();
		assertEquals(3,MyLQ.first());
	}

	@Test
	public void testLast(){
		try{
			MyLQ.last();
		}catch(NoSuchElementException e){
			assertTrue(true);
		}
		MyLQ.enqueue(1);
		MyLQ.enqueue(2);
		assertEquals(2,MyLQ.last());

		MyLQ.enqueue(3);
		MyLQ.enqueue(4);
		MyLQ.enqueue(5);
		assertEquals(5,MyLQ.last());

		MyLQ.dequeue();
		assertEquals(5,MyLQ.last());
	}
	@Test
	public void testToString(){
		MyLQ.enqueue("element 1");
		MyLQ.enqueue("element 2");
		MyLQ.enqueue("element 3");
		String str = "element 1 element 2 element 3  ";
		assertEquals(str,MyLQ.toString());
	}
	@Test
	public void testIterator(){
		Iterator<Object> IT = MyLQ.iterator();

		assertEquals(false,IT.hasNext());

		boolean check=false;
		try{
			IT.next();
		}catch (NullPointerException e){
			assertTrue(true);
		}

		MyLQ.enqueue("First Element");
		IT = MyLQ.iterator();
		assertTrue(IT.hasNext());
		assertEquals("First Element",IT.next());
		MyLQ.enqueue("Second Element");
		MyLQ.enqueue("Third Element");

		IT= MyLQ.iterator();
		((Iterator) IT).next();
		assertEquals("Second Element",IT.next());
		assertEquals("Third Element",IT.next());

	}


}