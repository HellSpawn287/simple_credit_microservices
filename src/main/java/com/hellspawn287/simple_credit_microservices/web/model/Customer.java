package com.hellspawn287.simple_credit_microservices.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private UUID id;
    private String firstname;
    private String lastname;
    private String peselNumber;

//    @Past
//    private Timestamp dateOfBirth;

    private String customerURL;
}