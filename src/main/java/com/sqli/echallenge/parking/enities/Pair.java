package com.sqli.echallenge.parking.enities;

public class Pair {
    private final int pedestrianPosition;
    private final int bayPosition;

    public Pair(int pedestrianPosition, int bayPosition) {
        this.pedestrianPosition = pedestrianPosition;
        this.bayPosition = bayPosition;
    }

    public int getBayPosition() {
        return bayPosition;
    }
    public int distance () {
        if (bayPosition == -1) return -1;
       return Math.abs(pedestrianPosition - bayPosition);
    }
}
