package pl.java.scalatech.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.java.scalatech.domain.AbstractEntity;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product extends AbstractEntity {
    @Column(name="PRODUCT_NAME")
    private String name;

}
