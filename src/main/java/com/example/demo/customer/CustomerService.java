package com.example.demo.customer;


import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    List<Customer> getCustomers() {
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> {
                        NotFoundException notFoundException =
                                new NotFoundException("Customer with id "+ id +" Doesn't Exist");
                        log.error("error int getting customer {}", id, notFoundException);
                        return notFoundException;
                });
    }

}
