package lr222qp_assign3;

public class FractionMain {
	
public static void main(String[]args) {
	Fraction F = new Fraction (1,2);
	Fraction F2 = new Fraction (3,2);

System.out.println(F.toString());   
System.out.println(F2.toString()); 

if(F.isNegative()) {
	System.out.println(F+ " is negative.");
}
	else {
		System.out.println(F+ " is positive.");
	}
if(F2.isNegative()) {
	System.out.println(F2+" is negative.");
}
	else {
		System.out.println(F2+" is positive.");
	}

System.out.println(F+"+"+F2+"="+(F.add(F2)) );

System.out.println(F+"-"+F2+"="+F.subtract(F2) );

System.out.println((F+"x"+F2+"="+F.multiply(F2)));

System.out.println((F+":"+F2+"="+F.divide(F2)));


if(F.isEqualTo(F2)){
	System.out.println("Both fratcions are the same.");
}
else {
	System.out.println("These two fractions are different.");
	}

}
}
