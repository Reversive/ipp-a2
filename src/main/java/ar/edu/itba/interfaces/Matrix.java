package ar.edu.itba.interfaces;
import java.util.Random;

public abstract class Matrix implements IExecute {
    public final int SIZE = 1024;
    final long SEED = 6834723;
    final double[][] A;
    final double[][] B;
    final double[][] C;
    final Random rand;

    public Matrix() {
        A = new double[SIZE][SIZE];
        B = new double[SIZE][SIZE];
        C = new double[SIZE][SIZE];
        rand = new Random(SEED);
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                A[i][j] = rand.nextDouble();
                B[i][j] = rand.nextDouble();
                C[i][j] = 0.0;
            }
        }
    }

    public double[][] getA() {
        return A;
    }

    public double[][] getB() {
        return B;
    }

    public double[][] getC() {
        return C;
    }
}
