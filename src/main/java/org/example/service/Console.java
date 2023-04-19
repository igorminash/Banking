package org.example.service;

import java.util.Scanner;

public class Console {
    public static String  AskString(String message){
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static int  AskInteger(String message){
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
