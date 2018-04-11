package main;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Scanner;

public class App {
	public static BigInteger p, q, b, n, a, n_phi;
	public static String x, y;
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		long startTime, endTime, gap0, gap1, gap2;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the length: "); 
		int length = Integer.parseInt(input.nextLine());
		System.out.print("Please enter the message: "); 
		x = input.nextLine();
		input.close();
		Initialize.Init(length);
		
		
		startTime = System.nanoTime();    
		BigInteger cipher = RSA.Encrypt(x);
		String plaintext = RSA.Decrypt(cipher);
		endTime = System.nanoTime();    
		gap0 = endTime - startTime;
		
		startTime = System.nanoTime();    
		RSA.Decrypt_SQM(RSA.Encrypt_SQM(x));
		endTime = System.nanoTime();
		gap1 = endTime - startTime;
		
		startTime = System.nanoTime();
//		String plaintext2 = RSA.Decrypt_non(RSA.Encrypt_non(x));
		endTime = System.nanoTime();    
		gap2 = endTime - startTime;
		

		System.out.println("Public Key: "+ Initialize.getB());
		System.out.println("Private Key: "+ Initialize.getA());
		
		System.out.println("ciphertext: "+cipher);
		System.out.println("decrypt result: "+plaintext);
		System.out.println("");
		System.out.println("Time With SQM & CRT: " + gap0);
		System.out.println("Time With SQM: " + gap1);
		System.out.println("Normal Time: " + gap2);
		System.out.println(gap0-gap1);
		
	}
}