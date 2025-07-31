package com.company.count;

import java.io.*;
import java.util.Scanner;
public class CountWords {
    public static void main(String[] args) {
        String countText="";a
        try {
            // Object to write text
            BufferedWriter w = new BufferedWriter(new FileWriter("count.txt"));
            // taking input to count the words
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter a Text to count");
            countText=sc.next();
            // writing the text in the file
            w.write(countText); 
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // object of readtext to read the file
        ReadText r=new ReadText(countText);
    }
}