package org.learn.carservice.rest;

public class Car {
    private Integer id;
    private String type;
    private String color;
    private int seats;

    public Car(Integer id, String type, String color, int seats) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.seats = seats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Car car = (Car) o;

        return id != null ? id.equals(car.id) : car.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Car{" +
            "id='" + id + '\'' +
            ", type='" + type + '\'' +
            ", color='" + color + '\'' +
            ", seats=" + seats +
            '}';
    }
}
