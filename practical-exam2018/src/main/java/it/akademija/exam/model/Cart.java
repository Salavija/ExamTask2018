package it.akademija.exam.model;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Cart {

//    public productsByUsername
//    ConcurrentHashMap<String, Set<CartProduct>>

    public String username;
    public Set<CartProduct> products;

}
