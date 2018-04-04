package main;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Scanner;

public class App {
	public static BigInteger p, q, b, n, a, n_phi;
	public static String x, y;
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the length: "); 
		int length = Integer.parseInt(input.nextLine());
		System.out.print("Please enter the message: "); 
		x = input.nextLine();
		input.close();
		Initialize.Initialize(length);
		
		///
		int charCount = x.getBytes("UTF-8").length*8;
		System.out.println("charcount "+ charCount);
		///
		
		BigInteger cipher = RSA.Encrypt(x);
		String plaintext = RSA.Decrypt(cipher);

		System.out.println("Public Key: "+ Initialize.getB());
		System.out.println("Private Key: "+ Initialize.getA());
		
		System.out.println("ciphertext: "+cipher);
		System.out.println("decrypt result: "+plaintext);
	}
}