package lr222qp_assign3;

public class MultiDisplay {//FIELDS
 private String Message;
 private int Count;

public 	MultiDisplay() {//Constructors
	Message = "";
	Count = 0;
	

}
public void setDisplayMsg (String msg) {
	Message = msg;
}
public void setDisplayCount(int n) {
	Count = n;
}
public void display() {
	for(int i=0;i<Count;i++) {
		System.out.println(Message);
	}
	
}
public void display (String msg, int n) {
	Message = msg;
 for(int i =0; i<n;i++) {
	 System.out.println(msg);
 }
	
}
public String getDisplayMsg() {
	return Message;
	
}
public int getDisplayCount() {
	return Count;
}
}
