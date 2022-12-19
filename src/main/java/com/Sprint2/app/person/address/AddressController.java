package com.Sprint2.app.person.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://semester4-sprint2-website.s3-website-us-east-1.amazonaws.com/", "http://localhost:3000/"})
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

    @PostMapping(path = {"api/address/new", "api/address/edit"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> newAddress(@RequestBody Address address){
        Map<String, Long> body = new HashMap<>();
        body.put("id", addressService.addAddress(address));
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
