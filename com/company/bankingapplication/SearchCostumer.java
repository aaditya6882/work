package com.company.bankingapplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchCostumer {
    public static void search(String key) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"));
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7 && (parts[4].equals(key))) {
                    System.out.println("Customer Found: " + line);
                    found = true;
                }
            }
            reader.close();
            if (!found) {
                System.out.println("No customer found with key: " + key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
