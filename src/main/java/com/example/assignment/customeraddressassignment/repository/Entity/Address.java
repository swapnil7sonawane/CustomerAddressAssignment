package com.example.assignment.customeraddressassignment.repository.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "building_name")
    public String buildingName;

    @Column(name = "city")
    public String city;

    @Column(name = "state")
    public String state;

    @Column(name = "street")
    public String street;

    @Column(name = "zip")
    public String zipCode;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
