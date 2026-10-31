package uk.ac.westminster.productsapi.dto;

public class PhysicalProduct extends Product implements Discountable{

    private Double weightKg;
    private String dimensions;

    public PhysicalProduct(){}

    public PhysicalProduct(Long id, String name, Double price, Double weightKg, String dimensions){
        super(id, name, price);

        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String getSummary(){
        return "Id: " + getId()
                + " | Name: " + getName()
                + " | Price: " + getPrice()
                + " | Weight: " + getWeightKg()
                + " | Dimensions: " + getDimensions();
    }

    private double discountedPrice;

    @Override
    public void applyDiscount(double rate){
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice()  * (1-rate);

    }

    @Override
    public double getDiscountedPrice(){
        return discountedPrice;

    }
}
