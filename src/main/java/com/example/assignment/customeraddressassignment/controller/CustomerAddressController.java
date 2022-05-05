package com.example.assignment.customeraddressassignment.controller;

import com.example.assignment.customeraddressassignment.beans.request.CustomerRequest;
import com.example.assignment.customeraddressassignment.beans.response.ApplicationResponse;
import com.example.assignment.customeraddressassignment.beans.response.Response;
import com.example.assignment.customeraddressassignment.service.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService customerAddressService;

    @PostMapping("/customer")
    public ApplicationResponse saveCustomer(@RequestBody CustomerRequest request) {
        ApplicationResponse response = customerAddressService.saveCustomerDetails(request);
        return response;
    }
}
