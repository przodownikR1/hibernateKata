package pl.java.scalatech.domain.exerciseOne;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

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
public class Project extends AbstractEntity{

    private static final long serialVersionUID = -3500962571056477186L;

    @ManyToMany
    private Set<Employee> employees;

    private String projectName;



}