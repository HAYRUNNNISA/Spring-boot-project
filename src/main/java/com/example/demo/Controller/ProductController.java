package com.example.demo.Controller;




import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/create")
    public String createProduct(@RequestBody Product product) {
        try {
            productRepository.createProduct(product);
            return "Product created successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to create product";
        }
    }



    @PutMapping("/update")
    public String updateProduct(@RequestBody Product product) {
        try {
            productRepository.updateProduct(product);
            return "Product updated successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to update product";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        try {
            productRepository.deleteProduct(id);
            return "Product deleted successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to delete product";
        }
    }

}


