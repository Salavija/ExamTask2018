package it.akademija.exam.controllers;

import it.akademija.exam.model.CartProduct;
import it.akademija.exam.services.CartService;
import it.akademija.exam.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
public class CartController {

//    @RequestMapping
//    public void getCartProducts(String username)
//        List<CartProduct>
//
//    public void addCartProduct(String username, CartProductCommand p)
//        CartProduct
//
//    public void updateCartProduct(String username, Long productId, CartProductCommand p)
//
//    public void removeFromCart(String username, Long productId)
//        CartProduct


    private CartService cartService;

    private ProductService productService;

//    private Map<String, Set<CartProduct>> productsByTitle;
//
//    public CartController() {
//        this.productsByTitle = new ConcurrentHashMap<>();
//    }


    @Autowired
    public CartController(CartService cartservice, ProductService productService) {
        this.cartService = cartservice;
        this.productService = productService;
    }

    @GetMapping("/shoppingCart")
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("/shoppingCart");
        modelAndView.addObject("products", cartService.getProductsInCart());
        modelAndView.addObject("total", cartService.getTotal().toString());
        return modelAndView;
    }
//arba
//    @GetMapping("/shoppingCart")
//    public List<CartProduct> getCartProducts(@PathVariable String title) {
//        return new ArrayList<>(productsByTitle.getOrDefault(title, new LinkedHashSet<>()));
//    }

    @GetMapping("/shoppingCart/addProduct/{productId}")
    public ModelAndView addProductToCart(@PathVariable("productId") Long productId) {
        productService.findById(productId).ifPresent(cartService::addProduct);
        return shoppingCart();
    }

    @GetMapping("/shoppingCart/removeProduct/{productId}")
    public ModelAndView removeProduct(@PathVariable("productId") Long productId) {
        productService.findById(productId).ifPresent(cartService::removeProduct);
        return shoppingCart();
    }

    /**
     * ARBA
     *
     * @param cartProduct
     * @return
     */
//
//    @PostMapping("/api/users/{title}/cart-products")
//    public List<CartProduct> addCartProduct(@PathVariable String title, @RequestBody CartProduct cartProduct) {
//        Set<CartProduct> existingCartProducts = productsByTitle.getOrDefault(title, new LinkedHashSet<>());
//        existingCartProducts.add(cartProduct);
//        productsByTitle.put(title, existingCartProducts);
//        return getCartProducts(title);
//    }
//
//    @DeleteMapping("/api/users/{title}/cart-products/{productId}")
//    public List<CartProduct> removeFromCart(@PathVariable String title, @PathVariable Long productId) {
//        Set<CartProduct> existingCartProducts = productsByTitle.getOrDefault(title, new LinkedHashSet<>());
//        existingCartProducts = existingCartProducts
//                .stream()
//                .filter(c -> !c.id.equals(productId))
//                .collect(Collectors.toSet());
//        productsByTitle.put(title, existingCartProducts);
//        return getCartProducts(title);
//    }

}
