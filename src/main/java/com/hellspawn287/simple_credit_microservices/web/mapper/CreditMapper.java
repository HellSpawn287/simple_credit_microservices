package com.hellspawn287.simple_credit_microservices.web.mapper;

import com.hellspawn287.simple_credit_microservices.domain.CreditEntity;
import com.hellspawn287.simple_credit_microservices.web.model.CreditDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class})
public interface CreditMapper {
    CreditMapper INSTANCE = Mappers.getMapper(CreditMapper.class);

    //    @Mapping(target = "creditURL", ignore = true)
    CreditDTO creditToCreditDTO(CreditEntity creditEntity);

    CreditEntity creditDTOToCredit(CreditDTO creditDTO);
}
