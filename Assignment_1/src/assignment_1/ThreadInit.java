/*
 * Initialization class for each thread
 * @author Carla Wilby
 * Completed 10/08/2015
 */
package assignment_1;
import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

class ThreadInit extends RecursiveTask<double[]> {
     
/**
 * This sequential threshold can (and will)
 * be changed in the report to help determine
 * the best threshold for parallel benefit.
 */    
static int SEQUENTIAL_THRESHOLD = 1000;
double[] in;            //unfiltered input array
double[] out;           //array in which filtered output is placed
int start;              //index at which to start splitting array (for divide and conquer)
int end;                //index at which to end the array portion (for divide and conquer)
int filterSize;

ThreadInit(double[] in,double[] out, int start, int end, int f) { this.in=in; this.out=out; this.start = start; this.end = end; filterSize=f;}
@Override
    public double[] compute() {
        //When split portion of input array is smaller than sequential threshold
        //then execute
        if(end - start <= SEQUENTIAL_THRESHOLD) {
            //Edge case where entire input is smaller than sequential threshold
            //Need to return out immediately
            if(start==0 && end==in.length){
                for(int i = start; i < end-filterSize + 1; i++){
                double[] temp = new double[filterSize];
                System.arraycopy(in, i, temp, 0, filterSize);
                Arrays.sort(temp);
                out[i+(filterSize/2)] = calcMedian(temp);
            }
            return out;
            //Else, for all other cases:
            }else{
            for(int i = start; i < end-filterSize + 1; i++){
                double[] temp = new double[filterSize];
                System.arraycopy(in, i, temp, 0, filterSize);
                Arrays.sort(temp);
                out[i+(filterSize/2)] = calcMedian(temp);
            }
            return null;
            }
        }else{
            //Else continue to segment the array portions into new threads
            //Each split is half of the previous splits
            //As in divide and conquer technique
            ThreadInit left = new ThreadInit(in,out,start,(start+end)/2, filterSize);
            ThreadInit right = new ThreadInit(in,out,(end+start)/2,end, filterSize);
            left.fork();
            right.compute();
            left.join();
            return out;
        }
    }
    /**
     * Median calculator
     * @param temp - sorted array of filter size
     * @return double median
     */
        public double calcMedian(double temp[]){
        double median = 0;
        for (int i = 0; i < temp.length; i++) {
            median = temp[temp.length/2];
        }
        return median;
    }
}