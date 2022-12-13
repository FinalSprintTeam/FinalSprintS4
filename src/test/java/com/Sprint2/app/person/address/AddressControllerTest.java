package com.Sprint2.app.person.address;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//@SpringBootTest
//@AutoConfigureMockMvc
public class AddressControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    AddressService addressService;

    @Autowired
    private ObjectMapper objectMapper;

    // given
    Address address = new Address(1L, "51A Amherst Heights",
            "St. John's", "A1E 3J3", "NL", "Canada", new HashSet<>());

    Address address_2 = new Address(1L, "52A Amherst Heights",
            "St. John's", "A1E 3J3", "NL", "Canada", new HashSet<>());

    Address address_3 = new Address(1L, "53A Amherst Heights",
            "St. John's", "A1E 3J3", "NL", "Canada", new HashSet<>());

//    @Test
    public void getAllRecords_success() throws Exception {
        List<Address> addresses = new ArrayList<>(Arrays.asList(address, address_2, address_3));

        Mockito.when(addressService.getAddresses()).thenReturn(addresses);

        mockMvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8081/api/address/all")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].province", is("NL")));
    }
}
