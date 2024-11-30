package com.kisiwani.sufeeds;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

    // Static method for hashing a string using SHA-256
    public static String hashPassword(String input) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Update the MessageDigest with the input string (converted to bytes)
            md.update(input.getBytes());
            
            // Perform the hash calculation
            byte[] hashedBytes = md.digest();
            
            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }
            
            return hexString.toString();  // Return the hashed string
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception if the algorithm is not found
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }
}
