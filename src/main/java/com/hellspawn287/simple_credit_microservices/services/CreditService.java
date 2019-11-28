package com.hellspawn287.simple_credit_microservices.services;

import com.hellspawn287.simple_credit_microservices.web.model.CreditDTO;

import java.util.UUID;

public interface CreditService {

    CreditDTO getCreditById(UUID id);

//    List<CreditDTO> getAllCredits();

    CreditDTO createNewCredit(CreditDTO customerDTO);

    CreditDTO saveCreditByDTO(UUID id, CreditDTO customerDTO);

//    CreditDTO patchCredit(UUID id, CreditDTO customerDTO);

//    void deleteCreditById(UUID id);
}
