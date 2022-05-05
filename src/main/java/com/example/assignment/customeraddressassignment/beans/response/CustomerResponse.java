package com.example.assignment.customeraddressassignment.beans.response;

import com.example.assignment.customeraddressassignment.repository.Entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    private Long customerId;
    private String customerName;
    private String email;
    private String phoneNumber;
    private Boolean status;
    private List<AddressResponse> addressList;
}
