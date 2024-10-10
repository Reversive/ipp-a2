package ar.edu.itba.implementations;

import ar.edu.itba.interfaces.Matrix;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelMatrixMultiplication extends Matrix {
    private final int threads;

    public ParallelMatrixMultiplication(int threads) {
        this.threads = threads;
    }

    @Override
    public void execute() {
        try (ExecutorService executor = Executors.newFixedThreadPool(threads)) {
            for (int i = 0; i < SIZE; i++) {
                final int currentRow = i;
                executor.execute(() -> {
                    for (int j = 0; j < SIZE; j++) {
                        for (int k = 0; k < SIZE; k++) {
                            this.getC()[currentRow][j] += this.getA()[currentRow][k] * this.getB()[k][j];
                        }
                    }
                });
            }
            executor.shutdown();
            if(executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
                //System.out.println("Fin: " + this.getC()[0][0]);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
