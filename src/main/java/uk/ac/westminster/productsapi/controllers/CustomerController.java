package uk.ac.westminster.productsapi.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uk.ac.westminster.productsapi.Address;
import uk.ac.westminster.productsapi.Customer;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final List<Customer> customers = new ArrayList<>();

    @GetMapping()
    public List<Customer> getCustomers(){
        return customers;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){

        for (Customer customer : customers){
            if (customer.getId().equals(id)){
                return customer;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer ID is not found");


    }

    @PostMapping("/register")
    public String addCustomer(@RequestBody Customer customer){

        for (Customer c : customers){
            if (c.getId().equals(customer.getId())){
                return "Error: Customer ID is already registered";
            }
        }

        customers.add(customer);
        return "Customer is Successfully Registered";


    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id){

        for (Customer customer : customers){
            if (customer.getId().equals(id)){
                customers.remove(customer);
                return "Customer details for ID - " + id + " Successfully Deleted";
            }
        }

        return "Customer ID is not registered";



    }


}
