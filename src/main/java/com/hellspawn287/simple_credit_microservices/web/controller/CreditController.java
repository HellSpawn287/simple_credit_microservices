package com.hellspawn287.simple_credit_microservices.web.controller;

import com.hellspawn287.simple_credit_microservices.services.CreditService;
import com.hellspawn287.simple_credit_microservices.web.model.CreditDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(CreditController.BASE_URL)
@AllArgsConstructor
public class CreditController {

    public static final String BASE_URL = "/rest/credits";
    private final CreditService creditService;

    //    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public CreditListDTO getAll() {
//        return getAllCredits();
//    }
//
//    private CreditListDTO getAllCredits() {
//        return new CreditListDTO(
//                creditService.getAllCredits());
//    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CreditDTO getByID(@PathVariable final UUID id) {
        return getCreditByID(id);
    }

    private CreditDTO getCreditByID(@PathVariable UUID id) {
        return creditService.getCreditById(id);
    }

    @GetMapping()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreditDTO createNew(@RequestBody final CreditDTO creditDTO) {
        return createNewCredit(creditDTO);
    }

    private CreditDTO createNewCredit(@RequestBody CreditDTO creditDTO) {
        return creditService.createNewCredit(creditDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CreditDTO update(@PathVariable final UUID id, @RequestBody final CreditDTO creditDTO) {
        return updateCredit(id, creditDTO);
    }

    private CreditDTO updateCredit(@PathVariable UUID id, @RequestBody CreditDTO creditDTO) {
        return creditService.saveCreditByDTO(id, creditDTO);
    }

//    @PatchMapping({"/{id}"})
//    @ResponseStatus(HttpStatus.OK)
//    public CreditDTO patch(@PathVariable final UUID id, @RequestBody final CreditDTO creditDTO) {
//        return patchCredit(id, creditDTO);
//    }
//
//    private CreditDTO patchCredit(@PathVariable UUID id, @RequestBody CreditDTO creditDTO) {
//        return creditService.patchCredit(id, creditDTO);
//    }

//    @DeleteMapping({"/{id}"})
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteById(@PathVariable final UUID id) {
//        deleteCreditById(id);
//    }
//
//    private void deleteCreditById(@PathVariable UUID id) {
//        creditService.deleteCreditById(id);
//    }
}
