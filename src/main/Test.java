package main;

import java.math.BigInteger;

public class Test {
	public static void main(String[] args) {
		BigInteger number = string_to_num("atesdt test");
		String text = num_to_string(number);
		
	}
	
	public static BigInteger string_to_num(String text) {
		char[] charArray = text.toCharArray();
		String temp="";
		int num=0;
		for(int i=0;i<charArray.length;i++) {
			num =(int)charArray[i];
			if((num/10) == 0)
				temp = temp + "0";
			else if((num/100) == 0)
				temp = temp + "0";
			temp = temp + num;
		}
		BigInteger tmp=new BigInteger(temp);
		return tmp;
	}
	
	public static String num_to_string(BigInteger num) {
		String temp="";
		int[] vocabulary = spliter(num);
		for(int i=0;i<vocabulary.length;i++) {
			temp=temp.concat(Character.toString ((char) vocabulary[i]));
		}
		return temp;
	}
	
	private static int[] spliter(BigInteger num) {
		String text = num.toString();
        int length = text.length();
        int arrayLength = length / 3;
        String tempText=text;
        int remain = length%3;
        if(remain != 0) {
        	arrayLength++;
        }
        int array[] = new int[arrayLength];
        if(remain == 1) {
        	array[0]=Integer.parseInt(tempText.substring(0, 1));
        	tempText=tempText.substring(1);
        	for (int i = 1; i < arrayLength; i++) {
                if(tempText.length()>3){
                	array[i]=Integer.parseInt(tempText.substring(0, 3));
                	tempText=tempText.substring(3);
                }else{
                	array[i]=Integer.parseInt(tempText);
                }
            }
        }else if(remain == 2) {
        	array[0]=Integer.parseInt(tempText.substring(0, 2));
        	tempText=tempText.substring(2);
        	for (int i = 1; i < arrayLength; i++) {
                if(tempText.length()>3){
                	array[i]=Integer.parseInt(tempText.substring(0, 3));
                	tempText=tempText.substring(3);
                }else{
                	array[i]=Integer.parseInt(tempText);
                }
            }
        }else {
        	for (int i = 0; i < arrayLength; i++) {
                if(tempText.length()>3){
                	array[i]=Integer.parseInt(tempText.substring(0, 3));
                	tempText=tempText.substring(3);
                }else{
                	array[i]=Integer.parseInt(tempText);
                }
            }
        } 
		return array;
    }
	
	public static int getDigitCount(BigInteger number) {
		  double factor = Math.log(2) / Math.log(10);
		  int digitCount = (int) (factor * number.bitLength() + 1);
		  if (BigInteger.TEN.pow(digitCount - 1).compareTo(number) > 0) {
		    return digitCount - 1;
		  }
		  return digitCount;
		}
}
