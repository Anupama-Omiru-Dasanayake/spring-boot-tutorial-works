package uk.ac.westminster.productsapi.dto;

public class DigitalProduct extends Product{

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

}
