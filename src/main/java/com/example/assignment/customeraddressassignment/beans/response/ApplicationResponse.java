package com.example.assignment.customeraddressassignment.beans.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationResponse implements Serializable {

    private Long customerId;
}
