package com.sqli.echallenge.parking;

import com.sqli.echallenge.parking.enities.Type;
import com.sqli.echallenge.parking.enities.Pair;
import com.sqli.echallenge.parking.enities.bays.AvailableBay;
import com.sqli.echallenge.parking.enities.bays.Bay;
import com.sqli.echallenge.parking.enities.bays.DisabledBay;
import com.sqli.echallenge.parking.enities.bays.Pedestrian;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Parking {

    private List<Bay> parking;

    Parking(List<Bay> parking) {
        this.parking = parking;
    }

    public int getAvailableBays() {
        return (int) parking.stream().filter(Bay::isAvailable).count();
    }

    public int parkCar(char carName) {
        Type type = Type.AVAILABLE;
        if (carName == 'D') type = Type.DISABLED;
        int positionOfAvailableBay = getPositionOfFirstAvailableBay(type);
        if (positionOfAvailableBay != -1)
            parking.get(positionOfAvailableBay).parkCar(String.valueOf(carName));
        return positionOfAvailableBay;
    }

    public boolean unparkCar(int bayIndex) {
        return parking.get(bayIndex).unparkCar();
    }

    private int getPositionOfFirstAvailableBay(Type type) {

        return IntStream.range(0, parking.size())
                .filter(index -> parking.get(index) instanceof Pedestrian)
                .mapToObj(index -> getPairOfTheShortDistance(type, index))
                .sorted(Comparator.comparing(Pair::distance))
                .findFirst()
                .get()
                .getBayPosition();

    }

    private Pair getPairOfTheShortDistance(Type type, int pedestrianPosition) {

        Optional<Pair> out = IntStream.range(0, parking.size())
                .filter(index -> type == Type.AVAILABLE ? parking.get(index) instanceof AvailableBay : parking.get(index) instanceof DisabledBay)
                .filter(index -> parking.get(index).isAvailable())
                .boxed()
                .map(bayPosition -> new Pair(pedestrianPosition, bayPosition))
                .sorted(Comparator.comparing(Pair::distance))
                .findFirst();
        return out.orElseGet(() -> new Pair(pedestrianPosition, -1));
    }

    @Override
    public String toString() {
        List<String> out = new LinkedList<>();
        int startPosition = 0;
        int squareSize = (int) Math.sqrt(parking.size());
        int endPosition = squareSize;
        boolean hasReversed = false;
        while (endPosition <= parking.size()) {

            String layer = IntStream.range(startPosition, endPosition)
                    .mapToObj(index -> parking.get(index).print())
                    .collect(joining());

            if (hasReversed) layer = new StringBuilder(layer).reverse().toString();
            out.add(layer);
            hasReversed = !hasReversed;
            startPosition = endPosition;
            endPosition = endPosition + squareSize;
        }
        return String.join("\n", out);
    }
}
