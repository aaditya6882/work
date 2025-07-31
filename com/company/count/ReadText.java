package com.company.count;

import java.io.*;
class ReadText {
     ReadText(String countText) { 
             try {
                // onjecct to read the text and counting the text 
            BufferedReader r= new BufferedReader(new FileReader("count.txt"));
            int count=0;
            String line;
            while ((line=r.readLine())!=null) {
                String[] words=line.trim().split("\\s");
                for (int i = 0; i < words.length; i++) {
                    count+=1;
                }
            }
            r.close();
            System.out.println(countText +" has "+ count+" words");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}
