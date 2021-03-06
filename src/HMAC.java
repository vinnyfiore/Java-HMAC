/**
 *@author Vincent Fiore
 *This program is an implementation of HMAC with SHA-256.
 *
 * Note: This program uses a method found online to properly convert the byte array after being
 * decrypted using the built in Java methods.
 * This code can be found at https://community.oracle.com/message/8677690 and did not include the formal name of
 * any creator or licensing information and is used in lieu of similar code provided directly by Apache for conversion to hex.
 *
 *Created for CUS 1185 homework assignment 6 question 6.6.
 */

import javax.crypto.*;
import javax.crypto.spec.*;


	   public class HMAC {

	     public static void main(String[] args) throws Exception {
	    	 
	    	 
	    	 //The secret keys-------------------------------------------

	    	 byte secretKeyBytes[] = new byte[] {(byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, 
	    			 (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, 
	    			 (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, 
	    			 (byte) 0x0b, (byte) 0x0b, (byte) 0x0b, (byte) 0x0b};
	    	 //The key, in hex, in a byte array.
	    	 
	    	 byte cipherText[] = new byte[] {(byte)0x4D, (byte)0x41, (byte)0x43, (byte)0x73, (byte)0x20, (byte)0x61, (byte)0x72, (byte)0x65, (byte)0x20, (byte)0x76, (byte)0x65
		   				, (byte)0x72, (byte)0x79, (byte)0x20, (byte)0x75, (byte)0x73, (byte)0x65, (byte)0x66, (byte)0x75, (byte)0x6C, (byte)0x20, (byte)0x69
		   				, (byte)0x6E, (byte)0x20, (byte)0x63, (byte)0x72, (byte)0x79, (byte)0x70, (byte)0x74, (byte)0x6F, (byte)0x67, (byte)0x72, (byte)0x61,
		   				(byte)0x70, (byte)0x68, (byte)0x79, (byte)0x21};
	    	 //The first cipher text.
	    	 
	    	 Mac HMAC = Mac.getInstance("HmacSHA256");
	    	 //Grabs the instance of the MAC.
	       
	    	 SecretKeySpec secKeySpec = new SecretKeySpec(secretKeyBytes, "HmacSHA256");
	    	 //Creates the Secret Key.
	    	 
	    	 HMAC.init(secKeySpec);
	    	 //Initializes the HMAC.

	    	 
	    	 byte[] finalMAC = HMAC.doFinal(cipherText);
	    	 //Calls the MAC method.
	    	 
	    	 System.out.println("The HMAC is: " + (asHex(finalMAC)).toUpperCase());
	    	 //Prints the final result in upper case.
	    			 
	    		 
	    		 
	    	 
	       
	     }
	     
	     public static String asHex (byte buffer[]) {
	    	 //This method takes the byte array that encryption produces and converts it into a hex string to be printed. 
		      StringBuffer strbuf = new StringBuffer(buffer.length * 2);
		      //Creates a string buffer with twice the length of the byte array to hold the converted info.
		      int i;
		      for (i = 0; i < buffer.length; i++) {
		       if (((int) buffer[i] & 0xff) < 0x10)
			    strbuf.append("0");
		       strbuf.append(Long.toString((int) buffer[i] & 0xff, 16));
		       //Does the actual conversion on every byte in the array.
		      }
		      return strbuf.toString();
		      //Returns the array as a string to be printed.
		     }
	     
	     
	   }






