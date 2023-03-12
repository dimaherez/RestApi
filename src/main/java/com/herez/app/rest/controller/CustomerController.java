package com.herez.app.rest.controller;

import com.herez.app.rest.models.Customer;
import com.herez.app.rest.models.Loan;
import com.herez.app.rest.repository.BranchRepo;
import com.herez.app.rest.repository.CustomerRepo;
import com.herez.app.rest.repository.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    // Customers
    @GetMapping(value = "")
    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveCustomer(@RequestBody Customer customer) {
        customerRepo.save(customer);
        return "Customer saved...";
    }

    @PutMapping(value = "/update/{id}")
    public String updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerRepo.findById(id).get();

        updatedCustomer.setFirstName(customer.getFirstName());
        updatedCustomer.setLastName(customer.getLastName());
        updatedCustomer.setCity(customer.getCity());
        updatedCustomer.setOccupation(customer.getOccupation());

        customerRepo.save(updatedCustomer);
        return "Customer updated...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable long id) {
        Customer deleteCustomer = customerRepo.findById(id).get();
        customerRepo.delete(deleteCustomer);
        return "Delete customer with the id: " + id;
    }

}
