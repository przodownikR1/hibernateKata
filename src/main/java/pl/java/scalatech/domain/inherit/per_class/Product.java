package pl.java.scalatech.domain.inherit.per_class;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Product {
private static final long serialVersionUID = -802306391915956578L;
@Id
private String code;
private String name;
}