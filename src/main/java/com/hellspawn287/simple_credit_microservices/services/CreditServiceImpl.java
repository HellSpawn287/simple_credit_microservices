package com.hellspawn287.simple_credit_microservices.services;

import com.hellspawn287.simple_credit_microservices.domain.CreditEntity;
import com.hellspawn287.simple_credit_microservices.repositories.CreditRepository;
import com.hellspawn287.simple_credit_microservices.web.controller.CreditController;
import com.hellspawn287.simple_credit_microservices.web.mapper.CreditMapper;
import com.hellspawn287.simple_credit_microservices.web.model.CreditDTO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class CreditServiceImpl implements CreditService {

    private CreditMapper creditMapper;
    private CreditRepository creditRepository;

    @Autowired
    public void setCreditMapper(CreditMapper creditMapper) {
        this.creditMapper = creditMapper;
    }

    @Autowired
    public void setCreditRepository(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

//    @Override
//    public List<CreditDTO> getAllCredits() {
//        return creditRepository.findAll()
//                .stream()
//                .map(credit -> {
//                    CreditDTO creditDTO = creditMapper.creditToCreditDTO(credit);
//                    creditDTO.setCreditURL(getCreditUrl(credit.getId()));
//                    return creditDTO;
//                })
//                .collect(Collectors.toList());
//    }

    @Override
    public CreditDTO getCreditById(UUID creditID) {
        return creditRepository.findById(creditID)
                .map(creditMapper::creditToCreditDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public CreditDTO createNewCredit(CreditDTO creditDTO) {
        return saveAndReturnDTO(creditMapper.creditDTOToCredit(creditDTO));
    }

    private CreditDTO saveAndReturnDTO(CreditEntity creditEntity) {
        CreditEntity savedCreditEntity = creditRepository.save(creditEntity);
        CreditDTO returnDTO = creditMapper.creditToCreditDTO(savedCreditEntity);
        returnDTO.setCreditURL(getCreditUrl(savedCreditEntity.getId()));

        return returnDTO;
    }

    @Override
    public CreditDTO saveCreditByDTO(UUID id, CreditDTO creditDTO) {
        CreditEntity creditEntity = creditMapper.creditDTOToCredit(creditDTO);
        creditEntity.setId(id);

        return saveAndReturnDTO(creditEntity);
    }

//    @Override
//    public CreditDTO patchCredit(UUID id, CreditDTO creditDTO) {
//        return creditRepository.findById(id).map(creditEntity -> {
//
//            if (creditDTO.getName() != null) {
//                creditEntity.setName(creditDTO.getName());
//            }
//            if (creditDTO.getCreatedDate() != null) {
//                creditEntity.setCreatedDate(creditDTO.getCreatedDate());
//            }
//            CreditDTO returnDTO = creditMapper.creditToCreditDTO(creditRepository.save(creditEntity));
//            returnDTO.setCreditURL(getCreditUrl(id));
//
//            return returnDTO;
//
//        }).orElseThrow(ResourceNotFoundException::new);
//    }

//    @Override
//    public void deleteCreditById(UUID id) {
//        creditRepository.deleteById(id);
//    }

    private String getCreditUrl(UUID id) {
        return CreditController.BASE_URL + "/" + id;
    }

}
