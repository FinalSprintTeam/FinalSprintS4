package com.Sprint2.app.person.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired AddressRepository addressRepository;

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public Address getAddress(Long id){
        return addressRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Address " + id + " does not exist!"));
    }

    public void addAddress(Address address) {
        addressRepository.save(address);
    }
}
