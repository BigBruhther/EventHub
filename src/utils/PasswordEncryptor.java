/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 * @author Kohner Smith
 */
public class PasswordEncryptor 
{
	
    public static String encrypt(String password) 
    {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] mdRet = md.digest(password.getBytes());
            result = Base64.getEncoder().encodeToString(mdRet);
        } catch(NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordEncryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
