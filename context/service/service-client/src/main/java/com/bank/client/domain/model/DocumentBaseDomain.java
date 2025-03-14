package com.bank.client.domain.model;

import java.time.LocalDateTime;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(builderMethodName = "init")
public class DocumentBaseDomain {
  protected String id;
  protected LocalDateTime createdAt;
  protected LocalDateTime updatedAt;
  @Builder.Default protected boolean status = true;
}
