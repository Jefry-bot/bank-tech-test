package com.bank.client.infrastructure.output.adapter.persistence.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "CLIENT")
public class ClientDocument extends PersonDocument {
  private String password;

  @Override
  @Generated
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  @Generated
  public int hashCode() {
    return super.hashCode();
  }
}
