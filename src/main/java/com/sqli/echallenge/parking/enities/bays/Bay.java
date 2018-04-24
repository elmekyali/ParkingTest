package com.sqli.echallenge.parking.enities.bays;

public abstract class Bay {
    public abstract boolean isAvailable();
    public abstract String print();
    public abstract boolean unparkCar();
    public abstract void parkCar(String carName);
}
