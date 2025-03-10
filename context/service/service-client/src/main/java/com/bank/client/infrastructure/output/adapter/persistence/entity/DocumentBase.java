package com.bank.client.infrastructure.output.adapter.persistence.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
public class DocumentBase {

  @Id
  protected String id;

  @CreatedDate
  protected LocalDateTime createdAt;

  @LastModifiedDate
  protected LocalDateTime updatedAt;

  protected boolean status = true;

  @Override
  @Generated
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof DocumentBase that)) {
      return false;
    }

    return Objects.equals(id, that.id);
  }

  @Override
  @Generated
  public int hashCode() {
    return Objects.hash(id);
  }
}
