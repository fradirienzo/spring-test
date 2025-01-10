package _rc.assessment.test.service;

import _rc.assessment.test.model.Product;
import _rc.assessment.test.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public double computeTotal(){
        List<Product> products = productRepository.findAll();
        double total = 0;
        for(Product p : products){
            total += p.getQuantity() * p.getPrice();
        }
        return total;
    }
}
