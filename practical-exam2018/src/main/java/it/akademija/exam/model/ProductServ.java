package it.akademija.exam.model;

import java.math.BigDecimal;

public class ProductServ {

    private String titleS;
    private String describtionS;
    private BigDecimal priceS;
    private Integer quantityS;

    public ProductServ(){}

    public ProductServ(String titleS, String describtionS, BigDecimal priceS, Integer quantityS) {
        this.titleS = titleS;
        this.describtionS = describtionS;
        this.priceS = priceS;
        this.quantityS = quantityS;
    }

    public String getTitleS() {
        return titleS;
    }

    public void setTitleS(String titleS) {
        this.titleS = titleS;
    }

    public String getDescribtionS() {
        return describtionS;
    }

    public void setDescribtionS(String describtionS) {
        this.describtionS = describtionS;
    }

    public BigDecimal getPriceS() {
        return priceS;
    }

    public void setPriceS(BigDecimal priceS) {
        this.priceS = priceS;
    }

    public Integer getQuantityS() {
        return quantityS;
    }

    public void setQuantityS(Integer quantityS) {
        this.quantityS = quantityS;
    }
}
