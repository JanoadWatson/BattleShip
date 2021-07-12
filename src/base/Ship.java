package base;

import java.util.ArrayList;

public abstract class Ship {
    private String name;
    private int length;
    private int hits;
    private String coordinates;
    private String direction;
    private String shipInitial;

    public Ship() {
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public int getHits() {
        return hits;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getDirection() {
        return direction;
    }

    public String getShipInitial() {
        return shipInitial;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setLength(int length) {
        this.length = length;

    }

    public void setHits(int hits) {
        this.hits = hits;

    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public void setDirection(String direction) {
        this.direction = direction;

    }

    public void setShipInitial(String shipInitial) {
        this.shipInitial = shipInitial;

    }



}
