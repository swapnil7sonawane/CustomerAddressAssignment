package com.example.assignment.customeraddressassignment.service;

import com.example.assignment.customeraddressassignment.beans.request.AddressRequest;
import com.example.assignment.customeraddressassignment.beans.request.CustomerRequest;
import com.example.assignment.customeraddressassignment.beans.response.AddressResponse;
import com.example.assignment.customeraddressassignment.beans.response.ApplicationResponse;
import com.example.assignment.customeraddressassignment.beans.response.CustomerAddressResponse;
import com.example.assignment.customeraddressassignment.beans.response.CustomerResponse;
import com.example.assignment.customeraddressassignment.repository.AddressRepository;
import com.example.assignment.customeraddressassignment.repository.CustomerRepository;
import com.example.assignment.customeraddressassignment.repository.Entity.Address;
import com.example.assignment.customeraddressassignment.repository.Entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerAddressService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    public ApplicationResponse saveCustomerDetails(CustomerRequest request) {

        Customer customer = constructCustomer(request);
        customerRepository.save(customer);

        List<Customer> customers = customerRepository.findAll();
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

    public CustomerResponse getCustomerById(Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Not Found");
        }
        Customer customer = customerOptional.get();
        CustomerResponse customerResponse = new CustomerResponse();
        List<Address> addressList = addressRepository.findByCustomerId(customerId);
        List<AddressResponse> addressResponses = new ArrayList<>();
        for (Address address : addressList) {
            addressResponses.addAll(constructAddressResponse(address));
        }
        customerResponse.setAddressList(addressResponses);
        customerResponse.setCustomerId(customer.getId());
        customerResponse.setCustomerName(customer.getCustomerName());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setPhoneNumber(customer.getPhoneNumber());
        customerResponse.setStatus(customer.getStatus());
        return customerResponse;
    }

    private List<AddressResponse> constructAddressResponse(Address address) {
        AddressResponse response = new AddressResponse();
        response.setBuildingName(address.getBuildingName());
        response.setCity(address.getCity());
        response.setState(address.getState());
        response.setZip(address.getZipCode());
        response.setStreet(address.getStreet());

        List<AddressResponse> addressResponses = new ArrayList<>();
        addressResponses.add(response);
        return addressResponses;
    }

    @Transactional
    public void deleteCustomerById(Long customerId) {
        int deletedRecord = addressRepository.deleteByCustomerId(customerId);
        customerRepository.deleteById(customerId);
    }

    public ApplicationResponse updateCustomerById(Long customerId, CustomerRequest request) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Customer customer = customerOptional.get();
        customer.setCustomerName(request.getCustomerName());
        customer.setEmail(request.getEmail());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setStatus(request.getStatus());
        customerRepository.save(customer);
        ApplicationResponse response = new ApplicationResponse();
        response.setCustomerId(customer.getId());
        return response;
    }

    public CustomerAddressResponse findAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> customerResponseList = new ArrayList<>();
        for (Customer customer : customers) {
            List<AddressResponse> addressList = new ArrayList<>();
            customer.getAddresses().stream().filter(address -> addressList.addAll(constructAddressResponse(address))).collect(Collectors.toList());
            customerResponseList.add(constructCustomerResponse(customer, addressList));
        }
        CustomerAddressResponse response = new CustomerAddressResponse();
        response.setCustomerList(customerResponseList);
        return response;
    }

    private CustomerResponse constructCustomerResponse(Customer customer, List<AddressResponse> addressResponse) {
        CustomerResponse response = new CustomerResponse();
        response.setCustomerName(customer.getCustomerName());
        response.setCustomerId(customer.getId());
        response.setEmail(customer.getEmail());
        response.setPhoneNumber(customer.getPhoneNumber());
        response.setStatus(customer.getStatus());
        response.setAddressList(addressResponse);
        return response;
    }
}
