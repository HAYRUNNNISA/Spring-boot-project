package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api") // Tüm endpointlerin başına "/api" eklendi
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customers")
    @ResponseBody
    public Customer createCustomer(@RequestBody Customer customer) {
        customerRepository.createCustomer(customer);
        return customer;
    }

    @GetMapping("/customers/{id}")
    @ResponseBody
    public Customer getCustomerById(@PathVariable int id) {
        return customerRepository.getCustomerById(id);
    }

    @PutMapping("/customers/{id}")
    @ResponseBody
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
        updatedCustomer.setId(id);
        customerRepository.updateCustomer(updatedCustomer);
        return updatedCustomer; // Güncellenmiş müşteriyi döndürüyoruz
    }

    @DeleteMapping("/customers/{id}")
    @ResponseBody
    public void deleteCustomer(@PathVariable int id) {
        customerRepository.deleteCustomer(id);
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllProducts();
    }
}
