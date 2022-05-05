package com.example.assignment.customeraddressassignment.repository.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "customer_name")
    public String customerName;

    @Column(name = "email")
    public String email;

    @Column(name = "phone")
    public String phoneNumber;

    @Column(name = "status")
    public Boolean status;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Address> addresses;

}
