package lr222qp_assign2;

public class Reverse {
	public static void main(String[]args) {
		char[] text = { '!', 'y', 's', 'a', 'E', ' ', 's', 'a', 'w', ' ', 
     			's', 'i', 'h', 'T' };
		System.out.println(text);
		int length = text.length;
		for(int i = 0;i<length/2;i++) {
			char help = text[i];
			text[i] = text[(length-1)-i];
			text[(length -1)-i]= help;
			}
		System.out.println(text);
	}

}
