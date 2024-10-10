package ar.edu.itba.implementations;

import ar.edu.itba.interfaces.IMeasure;
import ar.edu.itba.interfaces.Matrix;

public class ForkMeasurement implements IMeasure {
    private final int iterations;
    private final int[] threads;
    private final int[] thresholds;

    public ForkMeasurement(int iterations, int[] threads, int[] thresholds) {
        this.iterations = iterations;
        this.threads = threads;
        this.thresholds = thresholds;
    }

    @Override
    public void measure() {
        for (int thread : threads) {
            for(int threshold : thresholds) {
                long totalTime = 0;
                for (int i = 0; i < iterations; i++) {
                    long startTime = System.nanoTime();
                    Matrix matrix = new ForkMatrixMultiplication(thread, threshold);
                    matrix.execute();
                    long endTime = System.nanoTime();
                    totalTime += endTime - startTime;
                }
                System.out.println("Fork matrix with threshold " + threshold + " execution time for thread " + thread + " is " + (totalTime / iterations) / 1_000_000 + "ms");
            }
        }
    }
}
