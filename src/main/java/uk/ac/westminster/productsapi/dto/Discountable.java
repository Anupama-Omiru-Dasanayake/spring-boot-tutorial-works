package uk.ac.westminster.productsapi.dto;

public interface Discountable {
    void applyDiscount(double rate);

    double getDiscountedPrice();


}
