package ar.edu.itba.implementations;

import ar.edu.itba.interfaces.Matrix;

import java.util.concurrent.ForkJoinPool;

public class ForkMatrixMultiplication extends Matrix {
    private final int threads;

    public ForkMatrixMultiplication(int threads) {
        this.threads = threads;
    }

    @Override
    public void execute() {
        try (ForkJoinPool pool = new ForkJoinPool(threads)) {
            pool.invoke(new ForkTask(this.getA(), this.getB(), this.getC(), 0, SIZE));
            //System.out.println("Fin: " + this.getC()[0][0]);
        }
    }
}
