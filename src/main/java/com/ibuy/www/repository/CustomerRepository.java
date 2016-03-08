package com.ibuy.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibuy.www.domain.ICustomer;

public interface CustomerRepository extends JpaRepository<ICustomer, String> {

}
