package com.company;

import java.util.Scanner;

public class Main {
    public static String encrypt(String line, final String key)
    {
        String result = "";
        line = line.toUpperCase();
        for (int i = 0, j = 0; i < line.length(); i++)
        {
            char c = line.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            result += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return result;
    }
    public static String decrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c <'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        System.out.println("Write key:");
        String key = in.nextLine();
        System.out.println("Write text:");
        String message = in.nextLine();
        key = key.toUpperCase();

        String encryptedMsg = encrypt(message, key);
        System.out.println("Message: " + message);
        System.out.println("Encrypted message: " + encryptedMsg);
        System.out.println("Decrypted message: " + decrypt(encryptedMsg, key));

    }
}
