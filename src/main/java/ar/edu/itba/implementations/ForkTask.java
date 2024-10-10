package ar.edu.itba.implementations;

import java.util.concurrent.RecursiveAction;

public class ForkTask extends RecursiveAction {
    static final int THRESHOLD = 64;
    private final double[][] A;
    private final double[][] B;
    private final double[][] C;
    private final int start;
    private final int end;

    ForkTask(double[][] A, double[][] B, double[][] C, int start, int end) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                for (int j = 0; j < C[i].length; j++) {
                    for (int k = 0; k < A[i].length; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        } else {
            int mid = (start + end) / 2;
            ForkTask task1 = new ForkTask(A, B, C, start, mid);
            ForkTask task2 = new ForkTask(A, B, C, mid, end);
            invokeAll(task1, task2);
        }
    }
}
