package it.akademija.exam.model;

import java.math.BigDecimal;

public class ProductRest {

    private String titleRe;
//    private String imageRe;
    private String describtionRe;
    private BigDecimal priceRe;
    private Integer quantityRe;

    public ProductRest(){}

    public ProductRest(String titleRe, String describtionRe, BigDecimal priceRe, Integer quantityRe) {
        this.titleRe = titleRe;
//        this.imageRe = imageRe;
        this.describtionRe = describtionRe;
        this.priceRe = priceRe;
        this.quantityRe = quantityRe;
    }

    public String getTitleRe() {
        return titleRe;
    }

    public void setTitleRe(String titleRe) {
        this.titleRe = titleRe;
    }
//
//    public String getImageRe() {
//        return imageRe;
//    }
//
//    public void setImageRe(String imageRe) {
//        this.imageRe = imageRe;
//    }

    public String getDescribtionRe() {
        return describtionRe;
    }

    public void setDescribtionRe(String describtionRe) {
        this.describtionRe = describtionRe;
    }

    public BigDecimal getPriceRe() {
        return priceRe;
    }

    public void setPriceRe(BigDecimal priceRe) {
        this.priceRe = priceRe;
    }

    public Integer getQuantityRe() {
        return quantityRe;
    }

    public void setQuantityRe(Integer quantityRe) {
        this.quantityRe = quantityRe;
    }
}

