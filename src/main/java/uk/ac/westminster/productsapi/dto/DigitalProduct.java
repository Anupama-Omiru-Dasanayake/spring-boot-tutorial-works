package uk.ac.westminster.productsapi.dto;

public class DigitalProduct extends Product implements Discountable{

    private String downloadUrl;
    private Double fileSizeMb;

    public DigitalProduct(Long id, String name, Double price, String downloadUrl, Double fileSizeMb){
        super(id, name, price);

        this.downloadUrl = downloadUrl;
        this.fileSizeMb = fileSizeMb;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getFileSizeMb() {
        return fileSizeMb;
    }

    public void setFileSizeMb(double fileSizeMb) {
        this.fileSizeMb = fileSizeMb;
    }

    @Override
    public String getSummary(){
        return "Id: " + getId()
                + " | Name: " + getName()
                + " | Price: " + getPrice()
                + " | Download Url: " + getDownloadUrl()
                + " | Download Size: " + getFileSizeMb();
    }

    private double discountedPrice;

    public void applyDiscount(double rate){
        discountedPrice = getPrice() * (1-rate);
    }

    public double getDiscountedPrice(){
        return discountedPrice;
    }


}
