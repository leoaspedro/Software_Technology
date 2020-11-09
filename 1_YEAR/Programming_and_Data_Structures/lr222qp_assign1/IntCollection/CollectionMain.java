package lr222qp.assign1.IntCollection;

public class CollectionMain {
public static void main (String []args) {
	
	ArrayIntList Testing = new ArrayIntList();
	
	Testing.add(5);
	Testing.add(15);
	Testing.add(25);
	Testing.add(35);
	Testing.add(45);
	Testing.add(55);
	
	System.out.println(Testing);
	
	Testing.addAt(100,2);
	Testing.addAt(100,4);
	Testing.addAt(100,6);

	System.out.println(Testing);
	
	
	Testing.remove(0);
	System.out.println(Testing);
	
	System.out.println(Testing.get(1));
	System.out.println(Testing.indexOf(5)+", "+Testing.indexOf(15)+", "+Testing.indexOf(25));

	//Intstack 
	System.out.println("-------------|Intstack|-------------");
	ArrayIntStack Testing2 = new ArrayIntStack();
	
	Testing2.push(5);
	Testing2.push(35);
	Testing2.push(55);
	System.out.println(Testing2);
	
	System.out.println(Testing2.pop());
	System.out.println(Testing2.peek());
	
	System.out.println(Testing2);
}
}