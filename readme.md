RSA Implementation
==================

RSA Introduction
------------
Find two prime p and q<br>
Compute n and Φ(n), where n=p*q and Φ(n)=(p-1)(q-1)<br>
Find prime number b<br>
Compute a, where a = b^(-1) mod Φ(n) <br>

Public Key: (n, b)<br>
Private Key: (p, q, a)<br>

Encryption: e(X) = X^b mod n<br>
Decryption: d(Y) = Y^a mod n<br>

Implementation
--------------
**Computation** <br>
Using Euclid’s Algorithm to find GCD of two numbers <br>
>Find GCD of X and Y

Using Euclid’s Totient function to find Φ(n) <br>
>Find Φ(n) = (p-1)(q-1) Because p & q are prime

Using Extended Euclid's Algorithm to find Multiplicative Inverse <br>
>Compute r and s, where r * X + s * Y = GCD(X, Y)



**Efficiency**<br>
Square and multiply algorithm
>Compute x^b mod n<br>
>Express the exponent b as a binary number
>>b = b<sub>k-1</sub> b<sub>k-2</sub> b<sub>k-3</sub> b<sub>k-4</sub>…b<sub>2</sub> b<sub>1</sub> b<sub>0</sub> <br>
>>b = b<sub>k-1</sub> 2<sup>k-1</sup> +b<sub>k-2</sub> 2<sup>k-2</sup> + b<sub>k-3</sub> 2<sup>k-3</sup> +…+b<sub>1</sub>2<sup>1</sup> + b<sub>0</sub>

>We can write it as <br>
>>b = (((…(b<sub>k-1</sub>2 +b<sub>k-2</sub>)2+b<sub>k-3</sub>)2+…+b<sub>1</sub>)2+b<sub>0</sub>

>Algorithm
>>When b<sub>i</sub> =1, you square AND you multiply
>>When b<sub>i</sub> =0, you only square

Chinese Remainder Thereom
>Compute y<sup>a</sup> mod n = X<br>
>Find y<sub>p</sub> and y<sub>q</sub> <br>
>>y<sub>p</sub> = y mod p<br>
>>y<sub>q</sub> = y mod q<br>

>Find a<sub>p</sub> and a<sub>q</sub> <br>
>>a<sub>p</sub> = a mod (p-1)<br>
>>a<sub>q</sub> = a mod (q-1)<br>

>Find X<sub>p</sub> and X<sub>q</sub> <br>
>>X<sub>p</sub> = y<sub>p</sub><sup>ap</sup> mod p<br>
>>X<sub>q</sub> = y<sub>q</sub><sup>aq</sup> mod q<br>

>Find U<sub>p</sub> and U<sub>q</sub> <br>
>>U<sub>p</sub> = q<sup>-1</sup> mod p<br>
>>U<sub>q</sub> = p<sup>-1</sup> mod q<br>

>X = X<sub>p</sub> q U<sub>p</sub> + X<sub>q</sub> P U<sub>q</sub> <br>

Efficiency Compare
------------------
![image](https://github.com/Jeffreyhung/RSA/blob/master/Comparison_Chart.jpg) <br>
When the key length exceed around 900 bits long, the CRT algorithm starts to out perform than the one's with out CRT algorithm.


Usage
-----
run the RSA.jar file: 
>	java -jar RSA.jar

User will be ask to input key length and message to input with the following command:
>	Please enter the length: <br>
>	Please enter the message: 

The key length should only be numbers, the message can be any characters.<br>
Note that if the message has a longer length than the key, the encrypted and decrypted result will be garbled.


User can choose to use Chinese Remainder Thereom for the encryption and decryption or not with the following command:
>	Use Chinese Remainder Thereom? (T/F):

The Input should be only T, t, F or f, any other inputs will be consider as true.


The application will show the Public Key, Private Key, Ciphertext and decrypt result with the following command:
>	Public Key: 	<br>
>	Private Key: 	<br>
>	ciphertext: 	<br>
>	decrypt result: 

The Public Key, Private Key, Ciphertext will be encoded with Base64, and the decrypt result will be shown in normal text form.


The application will also show the time spent to encrypt and decrypt with the following command:
>	Time Spent:

The time will be shown in the unit of nanoseconds.
	
