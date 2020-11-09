package lr222qp_assign3;

public class MultiDisplaiMain {
public static void main(String[]args) {
	MultiDisplay md = new MultiDisplay();
	
md.setDisplayMsg("Hello World!");
md.setDisplayCount(3);
md.display();                           // ==> print-out
			
md.display("Goodbye cruel world!", 2);  // ==> print-out
			
System.out.println("Current Message: "+ md.getDisplayMsg());
}
}