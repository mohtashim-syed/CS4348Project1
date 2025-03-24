import java.io.*;
import java.util.*;

class Encryption {
    private static String passkey = "";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String argument = (parts.length > 1) ? parts[1] : "";
            
            if (command.equals("PASS")) {
                passkey = argument;
                System.out.println("RESULT");
            } else if (command.equals("ENCRYPT")) {
                if (passkey.isEmpty()) {
                    System.out.println("ERROR Password not set");
                } else {
                    // Use methods from Encryption.java
                    String text = Encryption.LowerToUpper(argument);
                    String key = Encryption.LowerToUpper(passkey);
                    String generatedKey = Encryption.generateKey(text, key);
                    System.out.println("RESULT " + Encryption.cipherText(text, generatedKey));
                }
            } else if (command.equals("DECRYPT")) {
                if (passkey.isEmpty()) {
                    System.out.println("ERROR Password not set");
                } else {
                    // Use methods from Encryption.java
                    String text = Encryption.LowerToUpper(argument);
                    String key = Encryption.LowerToUpper(passkey);
                    String generatedKey = Encryption.generateKey(text, key);
                    System.out.println("RESULT " + Encryption.originalText(argument, generatedKey));
                }
            } else if (command.equals("QUIT")) {
                break;
            }
        }
    }
    
    public static String generateKey(String str, String key) {
        int x = str.length();

        for (int i = 0; ; i++) {
            if (x == i)
                i = 0;
            if (key.length() == str.length())
                break;
            key += (key.charAt(i));
        }
        return key;
    }

    // This function returns the encrypted text generated with the help of the key
    public static String cipherText(String str, String key) {
        String cipher_text = "";

        for (int i = 0; i < str.length(); i++) {
            // converting in range 0-25
            int x = (str.charAt(i) + key.charAt(i)) % 26;

            // convert into alphabets(ASCII)
            x += 'A';

            cipher_text += (char) (x);
        }
        return cipher_text;
    }

    // This function decrypts the encrypted text and returns the original text
    public static String originalText(String cipher_text, String key) {
        String orig_text = "";

        for (int i = 0; i < cipher_text.length() && i < key.length(); i++) {
            // converting in range 0-25
            int x = (cipher_text.charAt(i) - key.charAt(i) + 26) % 26;

            // convert into alphabets(ASCII)
            x += 'A';
            orig_text += (char) (x);
        }
        return orig_text;
    }

    // This function will convert the lowercase character to Upper case
    public static String LowerToUpper(String s) {
        StringBuffer str = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
        s = str.toString();
        return s;
    }
}
