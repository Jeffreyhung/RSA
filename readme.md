RSA Implementation
==================

Introduction
------------




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
	
