package pl.java.scalatech.domain.exercise.query.jpql;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Company extends AbstractEntity{

    private static final long serialVersionUID = 6179224510037798601L;
    private String name;
    private Address address;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="deptID")
    private List<Department> depts;

}
