package it.akademija.exam.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartProduct {

    private Integer quantity;

    @ManyToOne
    private Product product;

    @Id
    public Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
