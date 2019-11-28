package com.hellspawn287.simple_credit_microservices.repositories;

import com.hellspawn287.simple_credit_microservices.domain.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreditRepository extends JpaRepository<CreditEntity, UUID> {

    @Override
    default CreditEntity getOne(UUID uuid) {
        return null;
    }
}
