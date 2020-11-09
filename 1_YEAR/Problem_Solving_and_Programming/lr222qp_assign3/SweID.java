package lr222qp_assign3;

public class SweID {
public static void main(String[]args) {
	String ID = "(981202-T112)";
	String ID2 = "(971202-T113)";
	
	System.out.println("Ex.1\nFirst Part: "+(getFirstPart(ID)));
	System.out.println("Ex.2\nSecond Part: "+(getSecondPart(ID)));
	System.out.println("Ex.3\nThis number belongs to a woman: "+isFemaleNumber(ID));
	System.out.println("Ex.4\n" +ID+ " and " +ID2+ " are the same ID number: "+areEqual(ID,ID2));
}
private static String getFirstPart(String sweID) {
	String firstPart = sweID.substring(1, 7);
	return firstPart;
}
private static String getSecondPart(String sweID) {
	String secondPart = sweID.substring(8, 12);
	return secondPart;
}
private static boolean isFemaleNumber(String sweID) {
	boolean isFemaleNumber = true;
	if(sweID.charAt(11)%2 == 0) {
		isFemaleNumber = true;
	}
		else {
			isFemaleNumber = false;
		}
	return isFemaleNumber;
}

private static boolean areEqual(String id1, String id2) {
	boolean areEqual = true;
if (id1 ==id2) {
	areEqual = true;
}
else {
	areEqual = false;
}
return areEqual;
}
}

