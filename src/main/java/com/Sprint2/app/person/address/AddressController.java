package com.Sprint2.app.person.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {
    @Autowired AddressService addressService;

    @GetMapping(path = "api/address/all")
    public List<Address> getAddresses(){
        return addressService.getAddresses();
    }

    @GetMapping(path = "api/address/{id}")
    public Address getAddress(@PathVariable("id") Long id){
        return addressService.getAddress(id);
    }

    @PostMapping(path = "api/address/new")
    public void newAddress(@RequestBody Address address){
        addressService.addAddress(address);
    }
}
