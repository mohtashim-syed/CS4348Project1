import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static void main(String[] args) {
        if (args.length != 1) {
              System.err.println("Usage: java Logger <log_file>");
              System.exit(1);
          }
  
      String logFile = args[0];
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  
      try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))){
        String line;
        while((line = br.readLine()) != null) {
          line = line.trim();
          if(line.equals"QUIT")) {
            break;
          }
  
        String[] parts = line.split("\\s+", 2);
        String actions = parts.length > 0 ? part[0] : "";
        String message = parts.length > 1 ? parts[1] : "";
  
        String timestamp = LocalDateTime.now().format(dtf);
        String logEntry = String.format("%s [%s] %s%n", timestamp, action, message);
        writer.write(logEntry);
        writer.flush();
        }
  
      } catch (IOEXception e){
        e.printStackTrace();
      }
    }
}
