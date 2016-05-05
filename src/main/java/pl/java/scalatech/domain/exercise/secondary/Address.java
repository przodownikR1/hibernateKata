package pl.java.scalatech.domain.exercise.secondary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.java.scalatech.domain.AbstractEntity;

@Entity
@Table(name = "TAddress")
@SecondaryTables( { @SecondaryTable(name = "TCity"),
@SecondaryTable(name = "TCountry") })
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Address extends AbstractEntity{
    private static final long serialVersionUID = -4597587808654336133L;

private String street;

@Column(table = "t_city")
private String city;

@Column(table = "t_city")
private String state;

@Column(table = "t_city")
private String zipcode;

@Column(table = "t_country")
private String country;
}