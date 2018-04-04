package main;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Initialize {
	public static BigInteger p, q, b, n, a, n_phi;
	
	public static void Initialize(int length) {
		SecureRandom random = new SecureRandom();
		p = BigInteger.probablePrime(length/2, random);
		q = BigInteger.probablePrime(length/2, random);
		b = new BigInteger("65537"); 
		
		n=p.multiply(q);
		n_phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		BigInteger gcd = Extended_Euclid_Algorithm.gcd(b,n_phi);
		BigInteger[] coeff = Extended_Euclid_Algorithm.Euclid(b,n_phi,BigInteger.ONE,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ONE, gcd);
		a = coeff[0];
		if(a.compareTo(BigInteger.ZERO)<0) {
			a = a.add(n_phi);
		}
	}
	
	public static BigInteger getP() {
		return p;
	}
	public static BigInteger getQ() {
		return q;
	}
	public static BigInteger getB() {
		return b;
	}
	public static BigInteger getA() {
		return a;
	}
	public static BigInteger getN() {
		return n;
	}
}
