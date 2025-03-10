package com.bank.client.infrastructure.input.adapter.web.dto;

import java.time.LocalDateTime;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(builderMethodName = "init")
public class DocumentBaseDTO {

    protected String id;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
    @Builder.Default
    protected boolean status = true;
}