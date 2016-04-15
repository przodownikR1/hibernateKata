package pl.java.scalatech.domain.collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Table (name="AddressCollect")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressCollect {

@Column
private String address1;

@Column
private String city;

@Column
private String state;

@Column
private String zip;
}