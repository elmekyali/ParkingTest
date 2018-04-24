package com.sqli.echallenge.parking.enities.bays;

import com.sqli.echallenge.parking.enities.Type;

public class BayFactory {
    public Bay getBay(Type type) {
        switch (type) {
            case PEDESTRIAN : return new Pedestrian();
            case DISABLED : return new DisabledBay();
            case AVAILABLE : return new AvailableBay();
            default: return null;
        }
    }
}
