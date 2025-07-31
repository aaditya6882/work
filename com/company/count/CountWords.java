package com.company.count;

import java.io.*;
import java.util.Scanner;
public class CountWords {
    public static void main(String[] args) {
        String countText="";a
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter("count.txt"));
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter a Text to count");
            countText=sc.next();
            w.write(countText); 
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReadText r=new ReadText(countText);
    }
}