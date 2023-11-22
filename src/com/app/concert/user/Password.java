/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concertdb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author Kohner Smith
 */
public class Password {
    private String password;
	
	public Password()
	{
	
		this.password = null;
		
	}
	
	
	/**
	 * Returns the encrypted version of the password
	 * 
	 * @param None
	 * @return String representation of an encrypted password
	 */
	public String toString() {return this.password;}
	
	/**
	 * Returns the encrypted version of the password
	 * 
	 * @param None
	 * @return String representation of the decrypted password
	 */
	public String decrypt() {
		
		String decryptedPass = "";
		char unmaskedChar;
		
		
		// Remember, this is a simple Ceaser cypher that should be changed later on
		for (int i = 0; i < this.password.length(); i++) {
			unmaskedChar = (char) (this.password.charAt(i) - 5);
			decryptedPass = decryptedPass + unmaskedChar;
		}
		
		return decryptedPass;
		
	}
	
	/**
	 * Sets a new encrypted password based off of the inputed new password.
	 * @param newPass: A string referencing the new password
	 */
	public void setPassword(String inputPass) {
		
		// While this is just a simple Ceaser cypher, I would like
		// this to be something more complex later on
		
		char newChar;
		String newPass = "";
		
		for(int i = 0; i < inputPass.length(); i++) {
			newChar = (char) (inputPass.charAt(i) + 5); 	// Shifts the character value over by 5
			newPass = newPass + newChar;
		}
		
		this.password = newPass;
		
	}
	
	/**
	 * Checks a password to see if it fulfills the requirements below:
	 * <ul>
	 * 	<li>Has at least 8 characters and no more than 50 characters</li>
	 * 	<li>Has at least one capital letter</li>
	 * 	<li>Has at least one number</li>
	 * 	<li>Has at least one special character</li>
	 * </ul>
	 * @param none
	 * @return true if password is valid<br>false if the password is not valid
	 */
	public boolean isValid(String inputPass) {
			
		if(inputPass.length()>= 8 && inputPass.length() <= 50) {
			Pattern letter = Pattern.compile("[A-Z]");
	    	Pattern digit = Pattern.compile("[0-9]");
	    	Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

	    	Matcher hasCapital = letter.matcher(inputPass);
	    	Matcher hasNumber = digit.matcher(inputPass);
	    	Matcher hasSpecial = special.matcher(inputPass);
	    	return hasCapital.find() && hasNumber.find() && hasSpecial.find();
		}
		
		return false;
	}
}
