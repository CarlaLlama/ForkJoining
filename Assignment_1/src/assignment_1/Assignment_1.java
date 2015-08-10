/*
 * Median filter main class
 * @author Carla Wilby
 * Completed 10/08/2015
 */
package assignment_1;

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
        //Read data in using SetupUtilClass:
        s.input();
        s.reader();
        double[] data = s.getData();
         
        //Run and time sequential:
        double startTime = System.currentTimeMillis();
        double[] seqFiltered = cls.sequentialFiltering(data, s.getFilterSize());
        double seqTimeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Sequential run took: "+seqTimeTaken+"ms");
         
        //Run and time parallel:
        double parStartTime = System.currentTimeMillis();
        double[] parFiltered = Parallel.medianFilter(data, s.getFilterSize());
        double parTimeTaken = System.currentTimeMillis() - parStartTime;
        System.out.println("Parallel run took: "+parTimeTaken+"ms");

        //Write data to file:
        s.writer(seqFiltered);
    }
    
}
