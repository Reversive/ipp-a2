package ar.edu.itba;

import ar.edu.itba.implementations.ForkMeasurement;
import ar.edu.itba.implementations.ParallelMeasurement;
import ar.edu.itba.implementations.SequentialMeasurement;

public class Main {
    public static void main(String[] args) {
        int[] threads = {2, 4, 8, 16};
        int[] thresholds = {64};
        ForkMeasurement forkMeasurement = new ForkMeasurement(100, threads, thresholds);
        forkMeasurement.measure();

//        ParallelMeasurement parallelMeasurement = new ParallelMeasurement(100, threads);
//        parallelMeasurement.measure();
//
//        SequentialMeasurement sequentialMeasurement = new SequentialMeasurement(100);
//        sequentialMeasurement.measure();
    }
}