package assignment_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SetupUtilClass {
    private String fileIn;
    private String fileOut;
    private int filterSize;
    private float[] dataIn;
    
    public void input(){
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        fileIn = in[0];
        int temp = Integer.parseInt(in[1]);
        if((temp< 3)||(temp%2!=1)){
            System.out.println("Invalid filter size, please enter correct filter size:");
            filterSize = s.nextInt();
        }else{
            filterSize = temp;
        }
        fileOut = in[2];
    }
    
    public void reader(){
        try {
            BufferedReader b = new BufferedReader(new FileReader("in.txt"));
            int noLines = Integer.parseInt(b.readLine());
            dataIn = new float[noLines];
            for(int i= 0; i < noLines; i++){
                String[] temp = b.readLine().split(" ");
                dataIn[i] = Float.parseFloat(temp[1]);
            }
        }catch (IOException | NumberFormatException ex) {
                System.out.println(ex);
            
            }
    }
    
    public void writer(){
        
    }
    
    public int getFilterSize(){
        return filterSize;
    }
    
    public float[] getData(){
        return dataIn;
    }
    
    
    
}
