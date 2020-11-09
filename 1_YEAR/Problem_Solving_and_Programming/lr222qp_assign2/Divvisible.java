package lr222qp_assign2;

public class Divvisible {
public static void main(String []args) {
	int count =0;
	
	for(int i = 100;i<201;i++) {
		if((i % 4==0 || i % 5==0) && !(i % 4==0 && i % 5==0)) {
			System.out.print(i +" ");
		      count++;
		}
		if (count==10){
   System.out.print("\n");
    count = 0;
	}
}
}
}

    
    