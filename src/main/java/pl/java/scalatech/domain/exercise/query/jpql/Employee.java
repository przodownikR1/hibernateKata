package pl.java.scalatech.domain.exercise.query.jpql;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import pl.java.scalatech.domain.AbstractEntity;

@Entity
public class Employee extends AbstractEntity{

    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private int age;
    @ManyToOne
    private Company company;
}
