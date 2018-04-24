package com.sqli.echallenge.parking.enities.bays;

public class DisabledBay extends Bay {
    private String character = "@";
    @Override
    public boolean isAvailable() {
        return character.equals("@");
    }

    @Override
    public String print() {
        return character;
    }
    @Override
    public boolean unparkCar() {
        boolean result = !isAvailable();
        this.character = result ? "@" : character;
        return result;
    }

    @Override
    public void parkCar(String carName) {
        this.character = carName;
    }
}
