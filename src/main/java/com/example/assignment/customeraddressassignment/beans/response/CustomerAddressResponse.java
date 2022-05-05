package com.example.assignment.customeraddressassignment.beans.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddressResponse {

    private List<CustomerResponse> customerList;
}
