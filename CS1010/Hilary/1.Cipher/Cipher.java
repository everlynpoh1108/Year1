/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5:  5
        Comment : Yes, all variable names used are meaningful and in lowerCamelCase.
        
 2. Did I indent the code appropriately?
        Mark out of 5: 5
		Comment : Yes, all code were indented appropriately.
		 
 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?
       	Mark out of 20:  10
	   	Comment : No, instead of using a function, I created a constant with all the characters of the alphabet. And used the
	   				encrypt function to assign the cipher text.
	   				
 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:  20
       Comment : The encrypt function took in the user input plain text and a fixed shift value of 5 as parameter and pass
        			the return as cipher text.

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:  20
       Comment :This function basically did the opposite of the encrypt function.

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?
       Mark out of 25 : 25
       Comment : The main function repeatedly obtains a new string and is in the required format of encrypting and decrypting.

 7. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment : Perfect!

 Total Mark out of 100 (Add all the previous marks): 90

*/ 
import java.util.Scanner ;

public class Cipher {
	
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz" ;

	public static void main(String[] args)
    {
		boolean finished = false ;
		
		while (!finished)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nEnter the text for encryption: ");
			String text = new String();
			text = scanner.next();
			System.out.println("Encrypted text : " + encrypt(text, 5));
			System.out.println("Decrypted text : " + decrypt(encrypt(text, 5), 5));
		}
    }
	
    
    public static String encrypt(String plainText, int shift)
    {
        plainText = plainText.toLowerCase();
        String cipherText = "";
        for (int index = 0; index < plainText.length(); index++)
        {
            int characterPosition = ALPHABET.indexOf(plainText.charAt(index));
            int keyVal = (shift + characterPosition) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }
 
    public static String decrypt(String cipherText, int shift)
    {
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int index = 0; index < cipherText.length(); index++)
        {
            int characterPosition = ALPHABET.indexOf(cipherText.charAt(index));
            int keyVal = (characterPosition - shift) % 26;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }
	
}