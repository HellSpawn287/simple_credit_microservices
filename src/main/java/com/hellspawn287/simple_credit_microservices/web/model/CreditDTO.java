package com.hellspawn287.simple_credit_microservices.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditDTO {

    private UUID id;
    private String name;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @JsonProperty("credit_url")
    private String creditURL;
}
