package it.akademija.exam.model;

import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Component
public class CartProduct {

    private Integer quantity;

    @Id
    private Long id;

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
