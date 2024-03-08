package com.example.demo.Repository;

import com.example.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createProduct(Product product) {
        String sql = "INSERT INTO Products (id, name, supplier, price) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getId(), product.getName(), product.getSupplier(), product.getPrice());
    }

    public Product getProductById(int id) {
        String sql = "SELECT * FROM Products WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            String name = resultSet.getString("name");
            String supplier = resultSet.getString("supplier");
            int price = resultSet.getInt("price");
            return new Product(id, name, supplier, price);
        });
    }

    public void updateProduct(Product product) {
        String sql = "UPDATE Products SET name=?, supplier=?, price=? WHERE id=?";
        jdbcTemplate.update(sql, product.getName(), product.getSupplier(), product.getPrice(), product.getId());
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM Products WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM Products";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int productId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String supplier = resultSet.getString("supplier");
            int price = resultSet.getInt("price");
            return new Product(productId, name, supplier, price);
        });
    }
}
