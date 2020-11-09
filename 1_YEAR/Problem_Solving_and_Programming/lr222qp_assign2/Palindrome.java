package lr222qp_assign2;
import java.util.Scanner;
import java.lang.Character;
public class Palindrome {
public static boolean isLetter(char a) {
	if(Character.isLetter(a));
	return true;
}
public static boolean isUpperCase(char b) {
	if(Character.isUpperCase(b));
	return true;
}
public static char toLowerCase(char c) {
	char Lc = Character.toLowerCase(c);
	return Lc;	
}
	
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Provide a line fo text: ");
	String text = sc.nextLine();
	StringBuilder original = new StringBuilder();
	StringBuilder reverse = new StringBuilder();
	sc.close();
	int length = text.length();
	
//original 
for(int i = 0;i<length;i++) {
	char help = text.charAt(i);
	if(isLetter(help)) {
		if(isUpperCase(help)) {
		original.append(toLowerCase(help));
		}
		else {
			original.append(help);
		}
		}
		}
//reverse
for(int i = 0;i<length;i++) {
	char help1 = text.charAt((length-1)-i);
	if(isLetter(help1)) {
		if(isUpperCase(help1)){
			
	reverse.append(toLowerCase(help1));
		}
		else {
			reverse.append(help1);
		}
		}
		}
String OG = original.toString();
String REV = reverse.toString();
if(OG.equals(REV)) {
	System.out.print("PALINDROME mothafucka!!");
}
else {
	System.out.print("U SUCK.");
}
}
}
