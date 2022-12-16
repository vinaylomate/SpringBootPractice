package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        //given
        Customer vinay = new Customer(1L, "Vinay","hello","vinay@gmail.com");
        Customer nikhil = new Customer(2L, "nikhil","hello","nikhil@gmail.com");

        customerRepository.saveAll(Arrays.asList(vinay, nikhil));
        //when
        List<Customer> customers = underTest.getCustomers();
        //then
        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        //given
        Customer vinay = new Customer(1L, "Vinay","hello","vinay@gmail.com");
        customerRepository.save(vinay);
        //when
        Customer actual = underTest.getCustomer(1L);
        //then
        assertEquals(1L, actual.getId());
        assertEquals("Vinay", actual.getName());
        assertEquals("hello", actual.getPassword());
        assertEquals("vinay@gmail.com", actual.getEmail());
    }
}