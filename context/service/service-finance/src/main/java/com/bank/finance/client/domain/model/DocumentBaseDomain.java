package com.bank.finance.client.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(builderMethodName = "init")
public class DocumentBaseDomain {
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean status;
}
