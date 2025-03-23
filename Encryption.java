import java.io.*;
import java.util.*;

class Encryption{
  private static String passkey = "";
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    while (scnr.hasNextLine()){
      String input = scnr.nextLine();
      String[] parts = input.split(" ", 2);
      String command = parts[0];
      String argument = (parts.length > 1) ? parts[1] : "";

      if (command.equals("PASS")){
        passkey = argument;
        System.out.println("RESULT");
      }else if (command.equals("ENCRYPT"){
        if (passkey.isEmpty())
          System.out.println("ERROR: password isn't set");
        else
          System.out.println("RESULT " + 
