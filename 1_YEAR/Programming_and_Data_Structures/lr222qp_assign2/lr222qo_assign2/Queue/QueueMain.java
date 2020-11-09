package lr222qo_assign2.Queue;

import java.util.Iterator;

public class QueueMain {

	public static void main(String[] args) {
		LinkedQueue MyQ = new LinkedQueue();
        System.out.println("This is an empty Queue: " + MyQ.isEmpty());
 
        
        System.out.println("Now we added one element: Leonardo");
        String Name = "Leonardo";
        MyQ.enqueue(Name);
        
        System.out.print("\n");
        
        System.out.println("Empty: " + MyQ.isEmpty());
        System.out.println("Head: " + MyQ.first());
        System.out.println("Tail: " + MyQ.last());
        
        System.out.print("\n");
        System.out.println("Now we added more elements: Rochinha, Pedro.");
        String MiddleName = "Rochinha";
        MyQ.enqueue(MiddleName);
        
        String LastName = "Pedro";
        MyQ.enqueue(LastName);
        
        System.out.println("Empty: " + MyQ.isEmpty());
        System.out.println("Head: " + MyQ.first());
        System.out.println("Tail: " + MyQ.last());
        
        
        
        System.out.println("\nChecking Iterator");
        Iterator<Object> IT = MyQ.iterator();
        
        while (IT.hasNext()){
            System.out.println(IT.next().toString());
        }
        System.out.println("\nChecking Queue elements:" + MyQ.toString());

        System.out.println("\nDequeue one: " + MyQ.dequeue());
        System.out.println("Dequeue another one: " + MyQ.dequeue());
      
        
        System.out.println("Empty: "+MyQ.isEmpty());
}

	}


