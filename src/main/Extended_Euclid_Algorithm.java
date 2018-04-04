package main;

import java.math.BigInteger;

public class Extended_Euclid_Algorithm {
	public static BigInteger x =new BigInteger("0");
	public static BigInteger y=new BigInteger("0");
	public static int i=0;
	
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
}
