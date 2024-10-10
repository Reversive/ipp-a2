package ar.edu.itba.implementations;

import ar.edu.itba.interfaces.IMeasure;
import ar.edu.itba.interfaces.Matrix;

public class SequentialMeasurement implements IMeasure {
    final private int iterations;

    public SequentialMeasurement(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public void measure() {
        long totalTime = 0;
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            Matrix matrix = new SequentialMatrixMultiplication();
            matrix.execute();
            long endTime = System.nanoTime();
            totalTime += endTime - startTime;
        }
        System.out.println("Sequential measurement took: " + (totalTime / iterations) / 1_000_000 + " ms");
    }
}
