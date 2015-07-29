package assignment_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class UtilClass {
    
    
    public void input(){
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        String fileIn = in[0];
        int filterSize = Integer.parseInt(in[1]);
        String fileOut = in[2];
    }
    
    public void reader(){
        try {
            BufferedReader b = new BufferedReader(new FileReader("in.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void writer(){
        
    }
    
    
    
}
