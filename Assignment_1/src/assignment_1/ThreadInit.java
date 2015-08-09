/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1;
import java.util.concurrent.RecursiveTask;

class ThreadInit extends RecursiveTask<double[]> {
     
static int SEQUENTIAL_THRESHOLD = 1000;
double[] in;
double[] out;
int start;
int end;
int filterSize;

ThreadInit(double[] in,double[] out, int start, int end, int f) { this.in=in; this.out=out; this.start = start; this.end = end; filterSize=f;}
    FilterUtilClass fil = new FilterUtilClass();
@Override
    public double[] compute() {
        if(end - start <= SEQUENTIAL_THRESHOLD) {
            for(int i=0; i < in.length-filterSize+1; ++i){
                double[] temp = new double[filterSize];
                System.arraycopy(in, i, temp, 0, filterSize);
                double sorted[] = fil.swap(temp);
               out[i+1] = fil.calcMedian(sorted);
            }
            return out;
        }else{
            ThreadInit left = new ThreadInit(in,out,start,(start+end)/2, filterSize);
            ThreadInit right = new ThreadInit(in,out,(end+start)/2,end, filterSize);
            left.fork();
            right.compute();
            left.join();
            
            return out;
        }
    }
}