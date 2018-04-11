package RSA;
import java.math.BigInteger;

public class SQM {
	
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
