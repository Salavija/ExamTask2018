package it.akademija.exam.services;

import it.akademija.exam.model.Product;
import it.akademija.exam.model.ProductRest;
import it.akademija.exam.model.ProductServ;
import it.akademija.exam.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);

    Page<Product> findAllProductsPageable(Pageable pageable);

    List<ProductServ> getProduct();

    void createProduct(ProductServ productServ);

    public Optional<Product> findByTitle(String title);

    ProductRepository getProductRepository();


    Product saveProduct(Product product);
}
