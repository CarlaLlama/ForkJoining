/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1;

import java.io.IOException;

/**
 *
 * @author carla
 */
public class Assignment_1 {
    SetupUtilClass s = new SetupUtilClass();
    Sequential cls = new Sequential();
    Parallel par = new Parallel();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //TEST
       
        new Assignment_1();
    }
    
    Assignment_1(){
        //Read data in:
         s.input();
         s.reader();
         double[] data = s.getData();
         //Run sequential:
         double startTime = System.currentTimeMillis();
         double[] seqFiltered = cls.sequentialFiltering(data, s.getFilterSize());
         double seqTimeTaken = System.currentTimeMillis() - startTime;
         
         //Run parallel:
         double parStartTime = System.currentTimeMillis();
         double[] parFiltered = Parallel.medianFilter(data, s.getFilterSize());
         double parTimeTaken = System.currentTimeMillis() - parStartTime;
          //Print timing:
         System.out.println("Parallel run took: "+parTimeTaken+"ms");
         System.out.println("Sequential run took: "+seqTimeTaken+"ms");
         
        
        
        //Write data to file:
         s.writer(seqFiltered);
    }
    
}
