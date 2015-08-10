/*
 * Parallel class
 * Executes the parallel method by invoking the ThreadInit class
 * For each Thread  
 * @author Carla Wilby
 * Completed 10/08/2015
 */
package assignment_1;

import java.util.concurrent.ForkJoinPool;

public class Parallel {
    static final ForkJoinPool fjPool = new ForkJoinPool();

    /**
     * Median Filter class to run parallel execution
     * @param array of unfiltered data
     * @param filterSize
     * @return sorted array
     */
    static double[] medianFilter(double[] array, int filterSize) {
        //Empty output array
        double[] output = new double[array.length];
        int border = filterSize/2;
        //Place unchanged data in border positions
        System.arraycopy(array, 0, output, 0, border);
        System.arraycopy(array, array.length-border, output, output.length-border, border);
        //Create Fork Join pool and initial thread
        return fjPool.invoke(new ThreadInit(array, output, 0, array.length, filterSize));
    }
}