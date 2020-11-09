package lr222qp_assign2;

public class Divisible {

public static void main(String[]args) {

	int counter = 0;
for (int i =100; i<= 200; i++){

    if((i % 4==0 || i % 5==0) && !(i % 4==0 && i % 5==0)) {
    	System.out.print(i +" ");
          counter++;
    }
        if (counter==10){
       System.out.print("\n");
        counter = 0;
        
    }
}
}
}
