package pl.java.scalatech.domain.exercise.query.jpql;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.java.scalatech.domain.AbstractEntity;
import pl.java.scalatech.domain.common.Address;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Company extends AbstractEntity{

    private String name;
    private Address address;

    @OneToMany
    private List<Department> depts;

}
