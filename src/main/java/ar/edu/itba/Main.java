package ar.edu.itba;

import ar.edu.itba.implementations.ForkMeasurement;

public class Main {
    public static void main(String[] args) {
        int[] threads = {2, 4, 8, 16};
        int[] thresholds = {64};
        ForkMeasurement measurement = new ForkMeasurement(100, threads, thresholds);
        measurement.measure();
    }
}