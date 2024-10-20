package com.springboot.security.withjpa.repository;

import com.springboot.security.withjpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author prabhakar, @Date 07-10-2024
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
