package pl.java.scalatech.domain.exerciseOne;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department extends AbstractEntity{
    private static final long serialVersionUID = -1655836579064977206L;


    @OneToMany(mappedBy="department")
    private List<Employee> employees;


    private String deptName;


}