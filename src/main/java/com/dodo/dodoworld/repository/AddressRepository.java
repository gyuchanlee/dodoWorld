package com.dodo.dodoworld.repository;

import com.dodo.dodoworld.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
