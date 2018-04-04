package main;

import java.math.BigInteger;

public class CRT {
	public static BigInteger CRT(BigInteger x, BigInteger a, BigInteger n, BigInteger p, BigInteger q) {
		BigInteger x_p = x.mod(p);
		BigInteger x_q = x.mod(q);
		BigInteger a_p = a.mod(p.subtract(BigInteger.ONE));
		BigInteger a_q = a.mod(q.subtract(BigInteger.ONE));
		
		BigInteger y_p = SQM.Square_multiple(x_p, a_p, p);
		BigInteger y_q = SQM.Square_multiple(x_q, a_q, q);
		BigInteger u_p, u_q;
		BigInteger gcd = Extended_Euclid_Algorithm.gcd(p, q);
		BigInteger[] coeff = Extended_Euclid_Algorithm.Euclid(q,p,BigInteger.ONE,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ONE, gcd);
		u_p = coeff[0];
		if(u_p.compareTo(BigInteger.ZERO)<0) {
			u_p = u_p.add(p);
		}
		u_q = coeff[1];
		if(u_q.compareTo(BigInteger.ZERO)<0) {
			u_q = u_q.add(q);
		}
		BigInteger result = x_p.multiply(q.multiply(u_p)).add(x_q.multiply(p.multiply(u_q))).mod(n);
		
		return result;
		
	}
}
