# Encryption and Logging System

## Overview

This project implements an encryption system using the Vigenère cipher, along with logging functionality. It consists of three separate programs:

Logger - Logs all activities to a specified log file.

Encryption Program - Encrypts and decrypts text using the Vigenère cipher.

Driver Program - Handles user interaction and manages the other two programs via subprocesses.

## Features

Implements a case-insensitive Vigenère cipher encryption and decryption.

Logs all commands and system activity.

Maintains a session-based history of encrypted and decrypted messages.

Uses inter-process communication via Java's ProcessBuilder class.

## Installation & Compilation

Ensure you have Java installed. Then, compile all the Java files:

` javac Logger.java Encryption.java Driver.java `

## Running the Program

Start the driver program, which will launch the logger and encryption program as subprocesses:

` java Driver log.txt `

This command creates a log file (log.txt) where all operations will be recorded.

## Usage

The program provides the following commands:

password -> Set the encryption passkey.

encrypt -> Encrypt a message.

decrypt -> Decrypt a message.

history -> View the history of encrypted and decrypted messages.

quit -> Exit the program.

## Example Interaction

```
Enter command (password, encrypt, decrypt, history, quit):
password
Enter passkey:
HELLO

Enter command:
encrypt
Enter string to encrypt:
WORLD
RESULT ZPSME

Enter command:
decrypt
Enter string to decrypt:
ZPSME
RESULT WORLD

Enter command:
history
History:
0: WORLD
1: ZPSME

Enter command:
quit
```

## Log File Example

```
2025-03-02 11:32 [LOG] START Driver started
2025-03-02 11:33 [LOG] PASSWORD set
2025-03-02 11:34 [LOG] COMMAND encrypt
2025-03-02 11:35 [LOG] COMMAND decrypt
2025-03-02 11:36 [LOG] COMMAND history
2025-03-02 11:37 [LOG] QUIT Driver exiting
```

## Notes

Only uppercase letters are allowed in encryption and decryption.

The encryption passkey must be set before using encrypt or decrypt.

The program maintains history only for the current session.

## License

This project is for educational purposes only.
