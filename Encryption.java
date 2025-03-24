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
                if (passkey.isEmpty()) System.out.println("ERROR Password not set");
                else System.out.println("RESULT " + cipherText(argument, generateKey(argument, passkey)));
            } else if (command.equals("DECRYPT")) {
                if (passkey.isEmpty()) System.out.println("ERROR Password not set");
                else System.out.println("RESULT " + originalText(argument, generateKey(argument, passkey)));
            } else if (command.equals("QUIT")) {
                break;
            }
        }
    }
    
    private static String generateKey(String str, String key) {
        int x = str.length();
        StringBuilder keyBuilder = new StringBuilder(key);
        for (int i = 0; ; i++) {
            if (keyBuilder.length() == x) break;
            keyBuilder.append(key.charAt(i % key.length()));
        }
        return keyBuilder.toString();
    }
    
    private static String cipherText(String str, String key) {
        StringBuilder cipher_text = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int x = (str.charAt(i) + key.charAt(i) - 2 * 'A') % 26;
            x += 'A';
            cipher_text.append((char) x);
        }
        return cipher_text.toString();
    }
    
    private static String originalText(String cipher_text, String key) {
        StringBuilder orig_text = new StringBuilder();
        for (int i = 0; i < cipher_text.length(); i++) {
            int x = (cipher_text.charAt(i) - key.charAt(i) + 26) % 26;
            x += 'A';
            orig_text.append((char) x);
        }
        return orig_text.toString();
    }
}
