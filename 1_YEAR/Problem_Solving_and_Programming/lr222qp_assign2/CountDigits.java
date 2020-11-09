package lr222qp_assign2;
import java.util.Scanner;

public class CountDigits {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner (System.in);
	        int Even = 0, Odd = 0, Zeros = 0;
	   
	        System.out.print("Provide a positive integer: ");
	        String value = sc.nextLine();
	        
	       int length = value.length();
	       sc.close();
	       
	      for (int i = 0;i<length;i++) {
	    	 char c = value.charAt(i);
	    	int N = Character.getNumericValue(c);
	    	 
	    			 if ((N %2 ==0) && !(N==0) ) {
	    				 Even++;
	    			 }
	    			 else {
	    				 Odd++;
	    			 }
	    			if (N ==0)
	    				Zeros++;
	    			 
	      }
	      	System.out.println("Zeros: "+Zeros); 
		    System.out.println("Even: "+Even); 
		    System.out.println("Odd: "+Odd);
	        
	        
	        
	        
	        
	        
	        
	    
	    
	 
	 }

    
	
	
	          
	          }
	
	
	
	


