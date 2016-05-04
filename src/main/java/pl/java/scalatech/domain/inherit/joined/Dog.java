package pl.java.scalatech.domain.inherit.joined;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity
@Table(name = "DOG")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@DiscriminatorColumn(name = "DOG_CLASS_NAME")
@AllArgsConstructor
@NoArgsConstructor

public abstract class Dog extends AbstractEntity{

    private static final long serialVersionUID = 2961151169855136579L;
private String name;

}

