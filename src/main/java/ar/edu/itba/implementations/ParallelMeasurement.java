package ar.edu.itba.implementations;

import ar.edu.itba.interfaces.IMeasure;
import ar.edu.itba.interfaces.Matrix;

public class ParallelMeasurement implements IMeasure {

    private final int iterations;
    private final int[] threads;

    public ParallelMeasurement(int iterations, int[] threads) {
        this.iterations = iterations;
        this.threads = threads;
    }

    @Override
    public void measure() {
        for (int thread : threads) {
            long totalTime = 0;
            for (int i = 0; i < iterations; i++) {
                long startTime = System.nanoTime();
                Matrix matrix = new ParallelMatrixMultiplication(thread);
                matrix.execute();
                long endTime = System.nanoTime();
                totalTime += endTime - startTime;
            }
            System.out.println("Parallel matrix execution time for thread " + thread + " is " + (totalTime / iterations) / 1_000_000 + "ms");

        }
    }
}
