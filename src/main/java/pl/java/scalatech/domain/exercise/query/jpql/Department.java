package pl.java.scalatech.domain.exercise.query.jpql;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.java.scalatech.domain.AbstractEntity;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department extends AbstractEntity {


    private String name;



}
