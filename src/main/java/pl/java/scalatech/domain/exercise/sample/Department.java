package pl.java.scalatech.domain.exercise.sample;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity
@Table(name = "DEPARTMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department extends AbstractEntity{

    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy="dept")
    private Set<Employee> employees = new HashSet<>();
}