import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Logger {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("ERROR Missing log file name");
            return;
        }
        String logFile = args[0];
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFile, true));
             Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if ("QUIT".equals(input)) break;
                logWriter.println(new Date() + " [LOG] " + input);
                logWriter.flush();
            }
        } catch (IOException e) {
            System.out.println("ERROR Could not write to log file");
        }
    }
}
