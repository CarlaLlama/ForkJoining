/*
 * Setup Utilities class for reading and writing
 * @author Carla Wilby
 * Completed 10/08/2015
 */
package assignment_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SetupUtilClass {
    private String fileIn;
    private String fileOut;
    private int filterSize;
    private double[] dataIn;
    
    
/*
 * Read input string from user
 * In the following format:
 * <input file> <filter size> <output file>
 */
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
    
    /**
     * Reads data in from the input file specified
     * In the following format:
     * First line: number of lines in the file
     * All subsequent lines: <line number> <data piece>
     */
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
    
    /**
     * Passes data to the output file specified in the same
     * format as the input file.
     * @param dataOut (array containing the data to be written to file)
     */
    public void writer(double[] dataOut){
        try {
            try (BufferedWriter b = new BufferedWriter(new FileWriter(fileOut))) {
                String len = (dataOut.length)+"";
                b.write(len);
                for (int i = 0; i < dataOut.length; i++) {
                    b.newLine();
                    b.write((i+1)+" "+dataOut[i]);
                    
                }
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    /**
     * Safely pass the filter Size to other classes
     * @return filter size
     */
    public int getFilterSize(){
        return filterSize;
    }
    
    /**
     * Safely pass the array containing the unchanged data
     * to other classes.
     * @return data array
     */
    public double[] getData(){
        return dataIn;
    }
}
