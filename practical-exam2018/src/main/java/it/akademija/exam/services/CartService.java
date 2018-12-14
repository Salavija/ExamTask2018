package it.akademija.exam.services;

import it.akademija.exam.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface CartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    BigDecimal getTotal();
}
