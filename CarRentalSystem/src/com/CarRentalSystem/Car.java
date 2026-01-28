package models;


public class Car {
   
    private String plateNo;    
    private String model;        
    private String category;     
    private double ratePerDay;    
    private String status;        
    
   
    public Car(String plateNo, String model, String category, double ratePerDay, String status) {
        this.plateNo = plateNo;
        this.model = model;
        this.category = category;
        this.ratePerDay = ratePerDay;
        this.status = status;
    }
    
    
    public String getPlateNo() {
        return plateNo;
    }
    
    public String getModel() {
        return model;
    }
    
    public String getCategory() {
        return category;
    }
    
    public double getRatePerDay() {
        return ratePerDay;
    }
    
    public String getStatus() {
        return status;
    }
    
    
    public void setStatus(String status) {
        this.status = status;
    }
    
   
    public void displayCarInfo() {
        System.out.println("========================================");
        System.out.println("Plate Number: " + plateNo);
        System.out.println("Model: " + model);
        System.out.println("Category: " + category);
        System.out.println("Rate: ₹" + ratePerDay + " per day");
        System.out.println("Status: " + status);
        System.out.println("========================================");
    }
}
