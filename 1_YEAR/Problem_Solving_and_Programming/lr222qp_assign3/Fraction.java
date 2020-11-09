package lr222qp_assign3;

public class Fraction {
private int N;
private int D;

public int getNumerator() {
	return N;
}
public int getDenominator() {
return D;
}
public Fraction (int Nvalue, int Dvalue) {
	N = Nvalue;
	D = Dvalue;
}
public Fraction() {
	N = 0;
	D = 0;
}
public String toString() {
	String text = "("+N+ "/"+ D+")";
	return text;
}
public boolean isNegative() {
	if((N<0 || D<0) && !(N<0 && D<0))
		return true;
	else
		return false;
}
public String add(Fraction f2) {
	int addtop = (N*f2.D)+(f2.N*D);
	int bot = (D*f2.D);
	String add = "("+addtop + "/"+bot+")";
	return add;
	
}
public String subtract(Fraction f2) {
	int subtop = (N*f2.D)-(f2.N*D);
	int bot = (D*f2.D);
	String subtract = "("+subtop + "/"+bot+")";
	return subtract;
}
public String multiply(Fraction f2) {
	int top =(N*f2.N);
	int bot =(D*f2.D);
	String multiply = "("+top + "/"+bot+")";
	return multiply;
}
public String divide(Fraction f2) {
	int top =(N*f2.D);
	int bot =(D*f2.N);
	String divide = "("+top + "/"+bot+")";
	return divide;
}
public boolean isEqualTo (Fraction f2) {
	if(N == f2.N && D == f2.D) {
		return true;
	}
	else {
		return false;
	}
}

}

