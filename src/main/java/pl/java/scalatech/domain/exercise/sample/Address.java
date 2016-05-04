package pl.java.scalatech.domain.exercise.sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity
@Table(name = "ADDRESS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address extends AbstractEntity{

    private static final long serialVersionUID = 5748538040151447433L;
    @Column(name = "STREET")
    private String street;
    @Column(name = "CITY")
    private String city;

}