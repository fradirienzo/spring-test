package _rc.assessment.test.controller;

import _rc.assessment.test.model.Product;
import _rc.assessment.test.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        return listProducts(model);
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/list";
    }

    @GetMapping("/products/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/add";
    }

    @PostMapping("/products")
    public String saveProduct(@ModelAttribute Product product, Model model) {
        productService.saveProduct(product);
        return listProducts(model);
    }

    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        productService.getProductById(id).ifPresent(product -> model.addAttribute("product", product));
        return "products/edit";
    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product, Model model) {
        product.setId(id);
        productService.saveProduct(product);
        return listProducts(model);
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        productService.deleteProduct(id);
        return listProducts(model);
    }

    @GetMapping("/products/viewStats")
    public String viewStats(Model model) {
        model.addAttribute("total", productService.computeTotal());
        return "products/stats";
    }
}
