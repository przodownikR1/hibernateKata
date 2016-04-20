package pl.java.scalatech.domain.selfReference;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.assertj.core.util.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity
@Table(name="EMPLOYEE_SELF")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends AbstractEntity{
    private static final long serialVersionUID = -5611293337609654205L;

    @Column(name="FIRSTNAME")
    private String firstname;

    @Column(name="LASTNAME")
    private String lastname;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="manager_id")
    private Employee manager;

    @OneToMany(mappedBy="manager",cascade={CascadeType.ALL})
    private Set<Employee> subordinates = Sets.newHashSet();

    public Employee(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }


}