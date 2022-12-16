package com.example.demo.customer;

import java.util.*;

public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomer() {
        return Arrays.asList(
                new Customer(1L,"Vinay Lomate", "123","email@gmail.com"),
                new Customer(2L,"Nikhil Lomate", "567", "email2@gmail.com")
        );
    }
}
