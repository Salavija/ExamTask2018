package it.akademija.exam.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {

//    public productsByUsername
//    ConcurrentHashMap<String, Set<CartProduct>>

//    public String username;
//    public Set<CartProduct> products;


    @Id
    private Integer id;

    @OneToMany(mappedBy="cart")
    private Set<CartProduct> cartProducts = new HashSet();

    public void addGood(CartProduct cartProduct) {
        this.cartProducts.add(cartProduct);
        cartProduct.setCart(this);
    }

}

