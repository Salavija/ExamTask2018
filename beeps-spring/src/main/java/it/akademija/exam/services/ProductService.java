package it.akademija.exam.services;

import it.akademija.exam.model.Product;
import it.akademija.exam.model.ProductRest;
import it.akademija.exam.model.ProductServ;
import it.akademija.exam.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> findAllProductsPageable(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<ProductServ> getProduct() {
        return productRepository.findAll().stream().map((product) ->
                new ProductServ(
                        product.getTitle(),
                        product.getDescribtion(),
                        product.getPrice(),
                        product.getQuantity()
                )).collect(Collectors.toList());
    }

    @Transactional
    public void createProduct(ProductServ product) {
        Product newProduct = new Product();
        newProduct.setTitle(product.getTitleS());
        newProduct.setDescribtion(product.getDescribtionS());
        newProduct.setPrice(product.getPriceS());
        newProduct.setQuantity(product.getQuantityS());
        productRepository.save(newProduct);

    }

    public Optional<Product> findByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public Product saveProduct(Product product) {
        return null;
    }
}
