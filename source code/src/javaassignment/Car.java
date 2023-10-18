package javaassignment;

public class Car {
    private int serialNo;
    private String model,colour,carPlate,status;
    private double bookPrice;

    public Car(int serialNo, String model, String colour, String carPlate, String status, double bookPrice) {
        this.serialNo = serialNo;
        this.model = model;
        this.colour = colour;
        this.carPlate = carPlate;
        this.status = status;
        this.bookPrice = bookPrice;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }
    
    
}
    


