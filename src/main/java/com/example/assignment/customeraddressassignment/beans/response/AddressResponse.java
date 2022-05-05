package com.example.assignment.customeraddressassignment.beans.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private String buildingName;
    private String city;
    private String state;
    private String street;
    private String zip;
}
