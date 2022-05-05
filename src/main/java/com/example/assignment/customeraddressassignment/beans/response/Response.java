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
public class Response<T extends Serializable> implements Serializable {

    private Integer status;
    private String message;
    private T data;
}
