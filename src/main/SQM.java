package main;

import java.math.BigInteger;
import java.util.Scanner;

public class SQM {

	public static void main(String[] args) {
		// a^b mod c = d
		System.out.println("a^b mod c = u");
		Scanner input = new Scanner(System.in);
		BigInteger a, b, c, u;

		System.out.print("Please enter the a: "); 
		a = new BigInteger(input.next());
		System.out.print("Please enter the b: "); 
		b = new BigInteger(input.next());
		System.out.print("Please enter the c: "); 
		c = new BigInteger(input.next());
		input.close();
		
		u = Square_multiple(a,b,c);
		
		System.out.println(a+ "^"+ b+" mod "+c +" = " +u);
	}
	
	public static BigInteger Square_multiple(BigInteger a, BigInteger b, BigInteger c) {
		BigInteger u;
		String b_string = b.toString(2);
		String[] b_stringArray = b_string.split("");

		u=BigInteger.ONE;
		for(int i=0;i<b_stringArray.length;i++) {
			u = u.multiply(u);
			u = u.mod(c);
			if(b_stringArray[i].equals("1")) {
				u = u.multiply(a);
				u=u.mod(c);
			}
		}
		return u;
	}
}
