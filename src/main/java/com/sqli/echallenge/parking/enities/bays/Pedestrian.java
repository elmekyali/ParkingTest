package com.sqli.echallenge.parking.enities.bays;

public class Pedestrian extends Bay {
    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public String print() {
        return "=";
    }

    @Override
    public boolean unparkCar() {
        return false;
    }

    @Override
    public void parkCar(String carName) {

    }

}
