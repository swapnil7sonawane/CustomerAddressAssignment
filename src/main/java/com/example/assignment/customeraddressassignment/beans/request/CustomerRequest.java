package com.example.assignment.customeraddressassignment.beans.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class CustomerRequest implements Serializable {


    @NotBlank(message = "Please enter name")
    private String customerName;

    @NotBlank(message = "Please Enter a email")
    private String email;

    @NotBlank(message = "Please enter mobile number")
    private String phoneNumber;

    @NotBlank(message = "Please enter the status")
    private Boolean status;

    private List<AddressRequest> addressRequests;
}
