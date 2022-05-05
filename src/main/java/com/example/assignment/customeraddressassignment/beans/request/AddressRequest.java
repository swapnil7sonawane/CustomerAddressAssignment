package com.example.assignment.customeraddressassignment.beans.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Data
public class AddressRequest implements Serializable {

    private String buildingName;
    private String city;
    private String state;
    private String street;
    private String zip;
}
