package assignment_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SetupUtilClass {
    private String fileIn;
    private String fileOut;
    private int filterSize;
    private double[] dataIn;
    
    public void input(){
        System.out.println("input file filtersize output file:");
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        fileIn = in[0];
        int temp = Integer.parseInt(in[1]);
        if((temp< 3)||(temp%2!=1)||(temp>21)){
            System.out.println("Invalid filter size, please enter correct filter size:");
            filterSize = s.nextInt();
        }else{
            filterSize = temp;
        }
        fileOut = in[2];
    }
    
    public void reader(){
        try {
            BufferedReader b = new BufferedReader(new FileReader(fileIn));
            int noLines = Integer.parseInt(b.readLine());
            dataIn = new double[noLines];
            for(int i= 0; i < noLines; i++){
                String[] temp = b.readLine().split(" ");
                dataIn[i] = Double.parseDouble(temp[1]);
            }
        }catch (IOException | NumberFormatException ex) {
                System.out.println(ex);
            }
    }
    
    public void writer(double[] dataOut){
        try {
            BufferedWriter b = new BufferedWriter(new FileWriter(fileOut));
            b.write(dataOut.length);
            b.newLine();
            for (int i = 0; i < dataOut.length; i++) {
                b.write((i+1)+" "+dataOut[i]);
            }
            b.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public int getFilterSize(){
        return filterSize;
    }
    
    public double[] getData(){
        return dataIn;
    }
}
