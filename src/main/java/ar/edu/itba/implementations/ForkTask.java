package ar.edu.itba.implementations;

import java.util.concurrent.RecursiveAction;

public class ForkTask extends RecursiveAction {
    private final double[][] A;
    private final double[][] B;
    private final double[][] C;
    private final int start;
    private final int end;
    private final int threshold;

    ForkTask(double[][] A, double[][] B, double[][] C, int start, int end, int threshold) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.start = start;
        this.end = end;
        this.threshold = threshold;

    }

    @Override
    protected void compute() {
        if (end - start <= threshold) {
            for (int i = start; i < end; i++) {
                for (int j = 0; j < C[i].length; j++) {
                    for (int k = 0; k < A[i].length; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        } else {
            int mid = (start + end) / 2;
            ForkTask task1 = new ForkTask(A, B, C, start, mid, threshold);
            ForkTask task2 = new ForkTask(A, B, C, mid, end, threshold);
            invokeAll(task1, task2);
        }
    }
}
