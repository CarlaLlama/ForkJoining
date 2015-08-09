/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1;
import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

class ThreadInit extends RecursiveTask<double[]> {
     
static int SEQUENTIAL_THRESHOLD = 10000;
double[] in;
double[] out;
int start;
int end;
int filterSize;

ThreadInit(double[] in,double[] out, int start, int end, int f) { this.in=in; this.out=out; this.start = start; this.end = end; filterSize=f;}
@Override
    public double[] compute() {
        if(end - start <= SEQUENTIAL_THRESHOLD) {
            if(start==0 && end==in.length){
                 for(int i = start; i < end-filterSize + 1; i++){
                double[] temp = new double[filterSize];
                System.arraycopy(in, i, temp, 0, filterSize);
                Arrays.sort(temp);
                out[i+(filterSize/2)] = calcMedian(temp);
            }
            return out;
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
            ThreadInit left = new ThreadInit(in,out,start,(start+end)/2, filterSize);
            ThreadInit right = new ThreadInit(in,out,(end+start)/2,end, filterSize);
            left.fork();
            right.compute();
            left.join();
            return out;
        }
    }
        public double calcMedian(double temp[]){
        double median = 0;
        for (int i = 0; i < temp.length; i++) {
            median = temp[temp.length/2];
        }
        return median;
    }
}