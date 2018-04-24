package com.sqli.echallenge.parking.enities.bays;

public class AvailableBay extends Bay {
    private String character = "U";

    @Override
    public boolean isAvailable() {
        return character.equals("U");
    }

    @Override
    public String print() {
        return character;
    }

    @Override
    public boolean unparkCar() {
        boolean result = !isAvailable();
        this.character = result ? "U" : character;
        return result;
    }

    @Override
    public void parkCar(String carName) {
        this.character = carName;
    }

}
