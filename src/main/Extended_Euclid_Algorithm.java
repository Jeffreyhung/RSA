package main;

import java.math.BigInteger;
import java.util.Scanner;

public class Extended_Euclid_Algorithm {
	public static BigInteger x =new BigInteger("0");
	public static BigInteger y=new BigInteger("0");
	public static int i=0;

	public static void main(String[] args) {
		BigInteger result;
		BigInteger a = new BigInteger("92204805");
		BigInteger b = new BigInteger("139928096");
		System.out.print("Enter the first number: ");
		Scanner input = new Scanner(System.in);
		a = new BigInteger(input.nextLine());
		System.out.print("Enter the second number: ");
		b= new BigInteger(input.nextLine());
		input.close();
		exchange(a, b); // make sure a > b, x > y
		result = gcd(x,y);
		System.out.println("gcd("+x+","+y+")="+result);
		BigInteger[] coeff = Euclid(x,y,BigInteger.ONE,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ONE, result);
		System.out.println("("+coeff[0]+"*"+x+")+("+coeff[1]+"*"+y+")="+result);
		
	}
	
	public static BigInteger[] Euclid(BigInteger a, BigInteger b, BigInteger s1, BigInteger t1, BigInteger s2, BigInteger t2, BigInteger GCD) {
		BigInteger[] coeff = new BigInteger[] {s1,t1};
		BigInteger[] coeff2 = new BigInteger[] {s2,t2};
		BigInteger[] temp = new BigInteger[2];
		temp[0] = BigInteger.ZERO;
		temp[1] = BigInteger.ZERO;
		BigInteger times = a.divide(b);
		BigInteger sub = a.subtract(times.multiply(b));
		temp[0] = coeff[0].subtract(times.multiply(coeff2[0]));
		temp[1] = coeff[1].subtract(times.multiply(coeff2[1]));
		if(sub.equals(GCD)) {
			return temp;
		}else {
			return Euclid(b, sub, s2, t2, temp[0], temp[1], GCD);
		}
	}
	
	public static BigInteger gcd(BigInteger a, BigInteger b) {
		BigInteger temp = BigInteger.ZERO;
		temp = a.mod(b);
		if(temp.equals(BigInteger.ZERO)) {
			return b;
		}else {
			return gcd(b, temp);
		}
		
	}
	
	public static void exchange(BigInteger a, BigInteger b) {
		if(a.compareTo(b)==1) {
			x = a;
			y = b;
		}else {
			x=b;
			y=a;
		}
	}

}
