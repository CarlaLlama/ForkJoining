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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //TEST
       
        new Assignment_1();
    }
    
    Assignment_1(){
         s.input();
         s.reader();
         float[] data = s.getData();
         for(int i = 1; i <= data.length; i++){
             System.out.println(i+ " "+data[i-1]);
         }
    }
    
}
