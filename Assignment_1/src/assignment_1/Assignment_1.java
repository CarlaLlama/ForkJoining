/*
 * Median filter main class and interface
 * @author Carla Wilby
 * Completed 10/08/2015
 */
package assignment_1;

import java.util.Scanner;

public class Assignment_1 {
    SetupUtilClass s = new SetupUtilClass();
    Sequential cls = new Sequential();
    Parallel par = new Parallel();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){ 
        new Assignment_1();
    }
    
    Assignment_1(){
        String intro = "Welcome to:\n*******A Sophomoric Investigation into Parallel Programming******\n***************Using the Java Fork-Join Framework****************";
        System.out.println(intro);
        //Read data in using SetupUtilClass:
        s.input();
        s.reader();
        
        double[] data = s.getData();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount of times to test this:");
        int numTimes = Integer.parseInt(scan.next());
        //Run testing
        tester(data, numTimes);
    }
    
    public void tester(double[] data, int numTimes){
        double[] seqFiltered = null;
        double[] parFiltered = null;
        double[] seqTimes = new double[numTimes];
        double[] parTimes = new double[numTimes];
        double[] speedUps = new double[numTimes];
        boolean written = false;
        for(int i = 1; i < numTimes+1; i++){
            //Run and time sequential:
            double startTime = System.currentTimeMillis();
            seqFiltered = cls.sequentialFiltering(data, s.getFilterSize());
            double seqTimeTaken = System.currentTimeMillis() - startTime;
            System.out.println(i+". Sequential time: "+seqTimeTaken+"ms");
            seqTimes[i-1] = seqTimeTaken; //Add time taken to array
            
            //Run and time parallel:
            double parStartTime = System.currentTimeMillis();
            parFiltered = Parallel.medianFilter(data, s.getFilterSize());
            double parTimeTaken = System.currentTimeMillis() - parStartTime;
            System.out.println("     Parallel time: "+parTimeTaken+"ms");
            parTimes[i-1] = parTimeTaken; //Add time taken to array

            //Print out speed up
            double speedUp = (double)Math.round((seqTimeTaken/parTimeTaken)*100)/100;
            System.out.println("     Speedup: "+speedUp);
            speedUps[i-1] = speedUp;
            
            System.out.println("-------------------------");
            
            //Write output to file once
            if(!written){
                //Write data to file:
                s.writer(seqFiltered);
                written = true;
            }
        }
        
        System.out.println("The average sequential time taken: "+s.calcAvgTime(seqTimes)+"ms");
        System.out.println("The average parallel time taken: "+s.calcAvgTime(parTimes)+"ms");
        System.out.println();
        System.out.println("The average speedup is: "+s.calcAvgTime(speedUps));
        System.out.println("-------------------------");
       
         //Run checking:
        boolean equal = s.comparator(seqFiltered, parFiltered);
        if(equal){
            System.out.println("Both produced identical outputs");
        }else{
            System.out.println("Outputs not identical");
        }
        

    }
}
