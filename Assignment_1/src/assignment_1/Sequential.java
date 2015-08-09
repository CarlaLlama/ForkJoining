package assignment_1;

import java.util.Arrays;

/**
 *
 * @author carla
 */
public class Sequential {
    
    public double[] sequentialFiltering(double[] unfiltered, int filSize){
        double[] filtered = new double[unfiltered.length];
        int border = (int) Math.floor(filSize/2);
        
        for (int i = 0; i < unfiltered.length-filSize+1; i++) {
            double[] temp = new double[filSize];
            System.arraycopy(unfiltered, i, temp, 0, filSize);
            //double[] sorted = fil.swap(temp);
            Arrays.sort(temp);
            filtered[i+1] = calcMedian(temp);
        }
        System.arraycopy(unfiltered, 0, filtered, 0, border);
        System.arraycopy(unfiltered, unfiltered.length-border, filtered, unfiltered.length-border, border);
        return filtered;
    }
    public double calcMedian(double temp[]){
        double median = 0;
        for (int i = 0; i < temp.length; i++) {
            median = temp[temp.length/2];
        }
        return median;
    }
}