package _rc.assessment.test.utils;

import _rc.assessment.test.model.Product;
import _rc.assessment.test.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TableFiller implements ApplicationRunner {

    private final ProductRepository productRepository;

    @Autowired
    public TableFiller(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{
        //log.info("Starting logic");
        if(productRepository.findAll().isEmpty()){
            //log.info("Creating products");
            Product p1 = new Product(null, "prodotto1", "primo prodotto", 2.2, 7);
            Product p2 = new Product(null, "prodotto2", "secondo prodotto", 10, 2);
            Product p3 = new Product(null, "prodotto3", "terzo prodotto", 5, 9);
            productRepository.save(p1);
            productRepository.save(p2);
            productRepository.save(p3);
            //log.info("Products created");
        } else {
            //log.info("No need to create products");
            return;
        }
    }
}
