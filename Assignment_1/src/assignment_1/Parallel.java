package assignment_1;

import java.util.concurrent.ForkJoinPool;

public class Parallel {
    static final ForkJoinPool fjPool = new ForkJoinPool();

    static double[] medianFilter(double[] array, int filterSize) {
        double[] output = new double[array.length];
        int border = (int)Math.floor(filterSize/2);
        System.arraycopy(array, 0, output, 0, border);
        System.arraycopy(array, array.length-border, output, output.length-border, border);
        return fjPool.invoke(new ThreadInit(array, output, 0, array.length, filterSize));
    }
}