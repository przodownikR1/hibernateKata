package pl.java.scalatech.domain.exerciseOne;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;
import pl.java.scalatech.domain.common.Address;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee extends AbstractEntity{

    private static final long serialVersionUID = 3016929937179274283L;

    @NaturalId
    private String userid;

    @Column( name="passwd" )
    @ColumnTransformer( read="decrypt(passwd)", write="encrypt(?)" )
    private String password;

    private int accessLevel;

    @ManyToOne( fetch=FetchType.LAZY )
    @JoinColumn
    private Department department;

    @ManyToMany(mappedBy="employees")
    @JoinColumn
    private Set<Project> projects;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    @org.hibernate.annotations.Generated(
    org.hibernate.annotations.GenerationTime.ALWAYS
    )
    //Hibernate refreshes the entity instance after every SQL UPDATE or INSERT .
    protected Date lastModified;


    @Column(insertable = false)
    @org.hibernate.annotations.ColumnDefault("1.00")
    @org.hibernate.annotations.Generated(
    org.hibernate.annotations.GenerationTime.INSERT
    )
    protected BigDecimal salary;
    //refreshing only occurs after an SQL INSERT , to retrieve the default value provided by the database.

    //...
    @Embedded
    @AttributeOverrides({
    @AttributeOverride(name = "street",
    column = @Column(name = "HOME_STREET")),
    @AttributeOverride(name = "zipcode",
    column = @Column(name = "HOME_ZIPCODE", length = 5)),
    @AttributeOverride(name = "city",
    column = @Column(name = "HOME_CITY"))
    })
    private Address address;



}