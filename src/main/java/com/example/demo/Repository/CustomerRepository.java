package com.example.demo.Repository;




import com.example.demo.Model.Customer;
import com.example.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createCustomer(Customer product) {
        String sql = "INSERT INTO Products (id, name, supplier, price) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getId(), product.getName(), product.getAddress(), product.getTelephone());
    }

    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM Products WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String telephone = resultSet.getString("telephone");

            return new Customer (id, name, address, telephone);
        });
    }

    public void updateCustomer(Customer customer) {
        String sql = "UPDATE Products SET name=?, supplier=?, price=? WHERE id=?";
        jdbcTemplate.update(sql, customer.getName(), customer.getAddress(), customer.getTelephone(), customer.getId());
    }

    public void deleteCustomer(int id) {
        String sql = "DELETE FROM Products WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public List<Customer> getAllProducts() {
        String sql = "SELECT * FROM Products";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int Id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String address= resultSet.getString("address");
            String telephone = resultSet.getString("telephone");
            return new Customer(Id, name, address, telephone);
        });
    }
}

