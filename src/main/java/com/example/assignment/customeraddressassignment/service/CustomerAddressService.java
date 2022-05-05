package com.example.assignment.customeraddressassignment.service;

import com.example.assignment.customeraddressassignment.beans.request.AddressRequest;
import com.example.assignment.customeraddressassignment.beans.request.CustomerRequest;
import com.example.assignment.customeraddressassignment.beans.response.ApplicationResponse;
import com.example.assignment.customeraddressassignment.repository.AddressRepository;
import com.example.assignment.customeraddressassignment.repository.CustomerRepository;
import com.example.assignment.customeraddressassignment.repository.Entity.Address;
import com.example.assignment.customeraddressassignment.repository.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerAddressService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    public ApplicationResponse saveCustomerDetails(CustomerRequest request) {

        Customer customer = constructCustomer(request);
        customerRepository.save(customer);

        addressRepository.saveAll(constructAddress(request, customer));

        ApplicationResponse response = new ApplicationResponse();
        response.setCustomerId(customer.getId());
        return response;
    }

    private List<Address> constructAddress(CustomerRequest request, Customer customeer) {
        List<AddressRequest> addressRequests = request.getAddressRequests();
        List<Address> addressList = new ArrayList<>();
        for (AddressRequest addressRequest : addressRequests) {
            Address address = new Address();
            address.setCustomer(customeer);
            address.setCity(addressRequest.getCity());
            address.setBuildingName(addressRequest.getBuildingName());
            address.setStreet(addressRequest.getStreet());
            address.setZipCode(addressRequest.getZip());
            address.setState(addressRequest.getState());
            addressList.add(address);
        }
        return addressList;
    }


    private Customer constructCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setCustomerName(customerRequest.getCustomerName());
        customer.setEmail(customerRequest.getEmail());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setStatus(customerRequest.getStatus());
        return customer;
    }
}
