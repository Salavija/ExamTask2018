package it.akademija.exam.controllers;

import it.akademija.exam.model.Product;
import it.akademija.exam.model.ProductRest;
import it.akademija.exam.model.ProductServ;
import it.akademija.exam.model.User;
import it.akademija.exam.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    //metodai:get product, get products,

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<ProductRest> getProducts() {
        List<ProductRest> products = new ArrayList<>();
        List<ProductServ> serviceProducts = productService.getProduct();
        for (ProductServ product: serviceProducts){
            products.add(
                                new ProductRest(
                                product.getTitleS(),
                                product.getDescribtionS(),
                                product.getPriceS(),
                                product.getQuantityS())
            );
        }
        return products;

//        return productService.getProduct().stream().map(
//                (ProductServ) ->
//                        new ProductRest(
//                                ProductServ.getTitleS(),
//                                ProductServ.getDescribtionS(),
//                                ProductServ.getPriceS(),
//                                ProductServ.getQuantityS())
//        ).collect(Collectors.toList());
    }

    @RequestMapping(value = "/addNewproduct", method = RequestMethod.POST)
    public ModelAndView createNewProduct(@Valid Product product, BindingResult bindingResult) {

        if (productService.findByTitle(product.getTitle()).isPresent()) {
            bindingResult
                    .rejectValue("title", "error.product",
                            "There is already a product with the same name");
        }
        if (productService.findById(product.getId()).isPresent()) {
            bindingResult
                    .rejectValue("id", "error.product",
                            "There is already a user registered with the username provided");
        }

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/addNewProduct");
        } else {
            productService.saveProduct(product);

            modelAndView.addObject("successMessage", "Product has been added");
            modelAndView.addObject("product", new Product());
            modelAndView.setViewName("/addNewProduct");
        }
        return modelAndView;
    }



    @RequestMapping(path = "/product", method = RequestMethod.PUT)
    public String addNewProduct(@RequestBody Product product){
        productService.createProduct(new ProductServ(
                product.getTitle(),
                product.getDescribtion(),
                product.getPrice(),
                product.getQuantity()
        ));
        return "New product was added";
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
