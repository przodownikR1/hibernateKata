package pl.java.scalatech.domain.inherit.single;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.java.scalatech.domain.AbstractEntity;
import pl.java.scalatech.domain.Person;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "task_type")
@Table(name="tasks")
public abstract class Task extends AbstractEntity{

    private String name;
    private int hoursCost;
    @ManyToOne
    @JoinColumn(name="personId")
    private Person person; 
    
}
