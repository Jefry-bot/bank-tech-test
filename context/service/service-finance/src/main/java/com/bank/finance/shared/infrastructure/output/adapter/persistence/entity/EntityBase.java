package com.bank.finance.shared.infrastructure.output.adapter.persistence.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@MappedSuperclass
public class EntityBase {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = IDENTITY)
  protected Long id;

  @CreationTimestamp
  @Column(name = "CREATED_AT", updatable = false)
  protected LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "UPDATED_AT")
  protected LocalDateTime updatedAt;

  @ColumnDefault("true")
  @Column(name = "STATUS")
  protected boolean status = true;

  @Override
  @Generated
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof EntityBase that)) {
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
