package lr222qp_assign1;
import java.util.Scanner;
public class Change {
public static void main(String[]args) {

System.out.print("Price: ");
Scanner sc = new Scanner(System.in);
double price = sc.nextDouble();

System.out.print("Payment: ");
int payment = sc.nextInt();
sc.close();

int P = (int) price;
//calculator
int change = payment - P ;
int r = (int)Math.round(change);
System.out.println("Change: "+r);

int onek = change/1000;
int helpv = change%1000;

int fh = helpv/500;
helpv = helpv%500;

int th = helpv/200;
helpv = helpv%200;

int oh = helpv/100;
helpv = helpv%100;

int ff = helpv/50;
helpv = helpv%50;

int tw = helpv/20;
helpv = helpv%20;

int ten = helpv/10;
helpv = helpv%10;

int f = helpv/5;
helpv = helpv%5;

int t = helpv/2;
helpv = helpv%2;

int o = helpv/1;
helpv = helpv%1;

System.out.println("1000kr bills: "+onek);
System.out.println("500kr bills: "+fh);
System.out.println("200kr bills: "+th);
System.out.println("100kr bills: "+oh);
System.out.println("50kr bills: "+ff);
System.out.println("20kr bills: "+tw);
System.out.println("10kr coins: "+ten);
System.out.println("5kr coins: "+f);
System.out.println("2kr coins: "+t);
System.out.println("1kr coins: "+o);

}
}