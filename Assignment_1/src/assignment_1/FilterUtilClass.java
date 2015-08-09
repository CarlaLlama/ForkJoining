/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1;

public class FilterUtilClass {
    
    public void naiveFilteringMethod(double unsorted[]){
        for (int i = 0; i < unsorted.length; i++) {      
        }
    }
    
    public double calcMedian(double temp[]){
        double median = 0;
        for (int i = 0; i < temp.length; i++) {
            median = temp[temp.length/2];
        }
        return median;
    }
    
    public double[] swap(double temp[]){
        for (int i = 0; i < temp.length-1; i++) {
            for (int j = 0; j < temp.length -i -1; j++) {
                if(temp[j]>temp[j+1]){
                  double tempNum = temp[j];
                  temp[j] = temp[j+1];
                  temp[j+1] = tempNum;
        }
            }
        }
         return temp;
    }
}
