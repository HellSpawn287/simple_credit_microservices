package com.hellspawn287.simple_credit_microservices.web.controller;

import com.hellspawn287.simple_credit_microservices.web.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(CreditController.BASE_URL)
public class CustomerResource {
    private final String creditsURL = "http://localhost:8082"
            + CreditController.BASE_URL;
    private final String customersURL = "http://localhost:8081/rest/customers";
    private RestTemplate restTemplate;

    @Autowired
    public CustomerResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping({"/{customerId}"})
    public String getCustomerByID(@PathVariable final String customerID) {
        ResponseEntity<String> customerResponce = restTemplate
                .exchange(creditsURL + "/" + customerID, HttpMethod.GET, null,
                        new ParameterizedTypeReference<String>() {
                        });
        return customerResponce.getBody();
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        ResponseEntity<List<Customer>> customersListResponce = restTemplate
                .exchange(creditsURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Customer>>() {
                        });
        return customersListResponce.getBody();
    }
}
