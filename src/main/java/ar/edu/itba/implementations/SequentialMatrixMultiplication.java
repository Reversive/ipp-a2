package ar.edu.itba.implementations;

import ar.edu.itba.interfaces.Matrix;

public class SequentialMatrixMultiplication extends Matrix {
    @Override
    public void execute() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    this.getC()[i][j] += this.getA()[i][k] * this.getB()[k][j];
                }
            }
        }
        //System.out.println("Fin: " + this.getC()[0][0]);
    }
}
