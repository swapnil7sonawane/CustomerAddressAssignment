package com.example.assignment.customeraddressassignment.repository;

import com.example.assignment.customeraddressassignment.repository.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
