package com.example.assignment.customeraddressassignment.beans.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class CustomerRequest implements Serializable {


    private String customerName;
    private String email;
    private String phoneNumber;
    private Boolean status;
    private List<AddressRequest> addressRequests;
}
