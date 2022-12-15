package com.Sprint2.app.person.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public Address getAddress(Long id){
        return addressRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Address " + id + " does not exist!"));
    }

    public Long addAddress(Address address) {
        List<Address> allAddresses = getAddresses();
        for (Address a : allAddresses) {
            if (a.getStreetAddress().equals(address.getStreetAddress())
                    && a.getCity().equals(address.getCity())
                    && a.getProvince().equals(address.getProvince())
                    && a.getPostalCode().equals(address.getPostalCode())
                    && a.getCountry().equals(address.getCountry())) {
                return a.getId();
            }
        }
        Address newAddress = addressRepository.save(address);
        return newAddress.getId();
    }
}
