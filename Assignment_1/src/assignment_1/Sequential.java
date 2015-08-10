/*
 * Sequential class
 * Executes the method sequentially
 * @author Carla Wilby
 * Completed 10/08/2015
 */
package assignment_1;

import java.util.Arrays;

public class Sequential {
    
    /**
     * Method to execute sequential filtering
     * @param unfiltered array to filter
     * @param filSize of filter to use
     * @return filtered array
     */
    public double[] sequentialFiltering(double[] unfiltered, int filSize){
        double[] filtered = new double[unfiltered.length];              //New array to store filtered data in
        int border = (int) Math.floor(filSize/2);                       //Establish size of border
        
        for (int i = 0; i < unfiltered.length-filSize+1; i++) {         //For each portion of unfiltered array
            double[] temp = new double[filSize];                        //Make new temp array the size of the filter
            System.arraycopy(unfiltered, i, temp, 0, filSize);          //Copy the unfiltered data corresponding directly into temp array
            Arrays.sort(temp);                                          //Sort the data in temp array
            filtered[i+(filSize/2)] = calcMedian(temp);                 //Place the median of the sorted temp array into corresponding position in filtered array
        }
        //Sort out edge cases
        System.arraycopy(unfiltered, 0, filtered, 0, border);           //Place border values on the left
        System.arraycopy(unfiltered, unfiltered.length-border, filtered, unfiltered.length-border, border);         //Place border values on the right
        return filtered;
    }
    
    /**
     * Method to calculate the median value in a sorted array
     * @param temp - sorted array
     * @return double median value
     */
    public double calcMedian(double temp[]){
        double median = 0;
        for (int i = 0; i < temp.length; i++) {
            median = temp[temp.length/2];
        }
        return median;
    }
}