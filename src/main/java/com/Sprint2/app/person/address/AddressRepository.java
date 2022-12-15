package com.Sprint2.app.person.address;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findAddressByCity(String city);
    Address findAddressByPostalCode(String postalCode);
    Address findAddressByStreetAddress(String streetAddress);
    Address findAddressByProvince(String province);
    Address findAddressByCountry(String country);

    boolean existsByStreetAddress(String streetAddress);
    boolean existsByCity(String city);
    boolean existsByProvince(String province);
    boolean existsByPostalCode(String postalCode);
    boolean existsByCountry(String country);
}
