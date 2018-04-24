package com.sqli.echallenge.parking;

import com.sqli.echallenge.parking.enities.Type;
import com.sqli.echallenge.parking.enities.bays.Bay;
import com.sqli.echallenge.parking.enities.bays.BayFactory;

import java.util.ArrayList;
import java.util.List;

public class ParkingBuilder {

    private List<Bay> parking;
    private BayFactory bayFactory = new BayFactory();

    public ParkingBuilder withSquareSize(int size) {
        this.parking = new ArrayList<>();
        int parkingSize = (int) Math.pow(size, 2);
        while (parkingSize-- > 0) {
            parking.add(bayFactory.getBay(Type.AVAILABLE));
        }
        return this;
    }

    public ParkingBuilder withPedestrianExit(int pedestrianIndex) {
        parking.set(pedestrianIndex, bayFactory.getBay(Type.PEDESTRIAN));
        return this;
    }

    public ParkingBuilder withDisabledBay(int disabledBayIndex) {
        parking.set(disabledBayIndex, bayFactory.getBay(Type.DISABLED));
        return this;
    }

    public Parking build() {
        return new Parking(parking);
    }
}
