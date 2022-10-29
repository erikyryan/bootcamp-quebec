package me.dio.parking.models.dto;

public class ParkingCreateDTO {

    private String license;
    private String model;
    private String color;
    private String state;

    public ParkingCreateDTO() {
    }

    public ParkingCreateDTO(String license, String model, String color, String state) {
        this.license = license;
        this.model = model;
        this.color = color;
        this.state = state;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
