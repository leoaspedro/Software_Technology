package lr222qp_assign2;
import java.util.ArrayList;
import java.util.Scanner;
public class ReverseOrder {
public static void main(String[]args) {
ArrayList <Integer> list = new ArrayList <Integer>();
Scanner sc = new Scanner(System.in);
int integer = 0;
int count = 0;
do {
	System.out.print("Integer "+(count+1)+": ");
	integer =sc.nextInt();
	if (integer>=0) {
		list.add(integer);
		count++;
		
	}
	else 
		break;
	
}while(integer>=0);
int length=list.size();
System.out.println("\nNumber of positive integer: "+count);
System.out.print("In reverse order: ");

for(int i=0;i<count;i++) {
	System.out.print(list.get((length-1)-i));
	if (((length-1)-i)>0) {
		System.out.print(", ");
	}
	else 
		System.out.print(" ");
	
	}
sc.close();
}

}

