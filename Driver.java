import java.io.*;
import java.util.*;

class Driver {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("ERROR Missing log file name");
            return;
        }
        String logFile = args[0];
        Process logger = new ProcessBuilder("java", "Logger", logFile).start();
        Process encryptor = new ProcessBuilder("java", "Encryption").start();
        
        Scanner userInput = new Scanner(System.in);
        PrintWriter logWriter = new PrintWriter(logger.getOutputStream(), true);
        PrintWriter encWriter = new PrintWriter(encryptor.getOutputStream(), true);
        Scanner encReader = new Scanner(encryptor.getInputStream());
        
        List<String> history = new ArrayList<>();
        
        logWriter.println("START Driver started");
        while (true) {
            System.out.println("Enter command (password, encrypt, decrypt, history, quit):");
            String command = userInput.nextLine().toLowerCase();
            logWriter.println("COMMAND " + command);
            
            if (command.equals("password")) {
                System.out.println("Enter passkey:");
                String passkey = userInput.nextLine().toUpperCase();
                encWriter.println("PASS " + passkey);
                logWriter.println("PASSWORD set");
            } else if (command.equals("encrypt")) {
                System.out.println("Enter string to encrypt:");
                String text = userInput.nextLine().toUpperCase();
                history.add(text);
                encWriter.println("ENCRYPT " + text);
                System.out.println(encReader.nextLine());
            } else if (command.equals("decrypt")) {
                System.out.println("Enter string to decrypt:");
                String text = userInput.nextLine().toUpperCase();
                history.add(text);
                encWriter.println("DECRYPT " + text);
                System.out.println(encReader.nextLine());
            } else if (command.equals("history")) {
                System.out.println("History:");
                for (int i = 0; i < history.size(); i++) {
                    System.out.println(i + ": " + history.get(i));
                }
            } else if (command.equals("quit")) {
                encWriter.println("QUIT");
                logWriter.println("QUIT Driver exiting");
                logger.destroy();
                encryptor.destroy();
                break;
            } else {
                System.out.println("ERROR Unknown command");
            }
        }
    }
}
