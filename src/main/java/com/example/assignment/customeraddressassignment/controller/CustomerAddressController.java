package com.example.assignment.customeraddressassignment.controller;

import com.example.assignment.customeraddressassignment.beans.request.CustomerRequest;
import com.example.assignment.customeraddressassignment.beans.response.ApplicationResponse;
import com.example.assignment.customeraddressassignment.beans.response.CustomerAddressResponse;
import com.example.assignment.customeraddressassignment.beans.response.CustomerResponse;
import com.example.assignment.customeraddressassignment.service.CustomerAddressService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/customer/{customerId}")
    public CustomerResponse getCustomerById(
            @ApiParam(
                    value = "Customer id path variable",
                    required = true)
            @PathVariable Long customerId) {
        return customerAddressService.getCustomerById(customerId);
    }

    @DeleteMapping("/customer/{customerId}")
    public void deleteByCustomerId(
            @ApiParam(
                    value = "Customer Id path variable",
                    required = true)
            @PathVariable Long customerId) {
        customerAddressService.deleteCustomerById(customerId);
    }

    @PutMapping("/customer/{customerId}")
    public ApplicationResponse updateByCustomerId(@ApiParam(
            value = "Customer Id path variable",
            required = true) @PathVariable Long customerId, @RequestBody CustomerRequest request) {
        ApplicationResponse response = customerAddressService.updateCustomerById(customerId, request);
        return response;
    }

    @GetMapping("/customers")
    public CustomerAddressResponse findAllCustomer() {
        CustomerAddressResponse response = customerAddressService.findAllCustomer();
        return response;
    }

}
