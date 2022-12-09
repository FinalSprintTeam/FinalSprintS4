package com.Sprint2.app.person.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository<Address> extends JpaRepository<Address, Long> {

}
