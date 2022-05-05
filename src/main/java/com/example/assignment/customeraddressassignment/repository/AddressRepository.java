package com.example.assignment.customeraddressassignment.repository;

import com.example.assignment.customeraddressassignment.repository.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByCustomerId(Long customerId);

    int deleteByCustomerId(Long customerId);
}
