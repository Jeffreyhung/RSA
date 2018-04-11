package RSA;
import java.math.BigInteger;
import java.util.Base64;
import java.util.Scanner;

public class App {
	public static BigInteger p, q, b, n, a, n_phi;
	public static String x, y;
	
	public static void main(String[] args) {
		long startTime, endTime, gap;
		BigInteger cipher = null;
		String plaintext = null;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the length: "); 
		int length = Integer.parseInt(input.nextLine());
		System.out.print("Please enter the message: "); 
		x = input.nextLine();
		System.out.print("Use Chinese Remainder Theorem? (T/F): "); 
		String def = input.nextLine();
		input.close();
		Initialize.Init(length);
		
		startTime = System.nanoTime();
		if(def.equals("F")||def.equals("f")) {
			cipher = RSA.Encrypt_SQM(x);
			plaintext = RSA.Decrypt_SQM(cipher);
		}else {
			cipher = RSA.Encrypt(x);
			plaintext = RSA.Decrypt(cipher);
		}
		endTime = System.nanoTime(); 
		gap = endTime - startTime;
		
//		String plaintext2 = RSA.Decrypt_non(RSA.Encrypt_non(x));
		
		System.out.println("");
		String PubKey = new String(Base64.getEncoder().encode(Initialize.getB().toByteArray()));
		System.out.println("Public Key: \t"+ PubKey);
		String PriKey = new String(Base64.getEncoder().encode(Initialize.getA().toByteArray()));
		System.out.println("Private Key: \t"+ PriKey);
		
		String ciphertext = new String(Base64.getEncoder().encode(cipher.toByteArray()));
		System.out.println("Ciphertext: \t"+ciphertext);
		System.out.println("Decrypt Result: "+plaintext);
		System.out.println("");
		System.out.println("Time Spent: " + gap +" nanoseconds.");		
	}
}