package pl.java.scalatech.domain.collection;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.generator.TableGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerCollect extends TableGenerator{
    @Column(name="Customer_Name")
    private String name;

    @ElementCollection(targetClass=AddressCollect.class,fetch=FetchType.EAGER)
    @JoinTable (name = "Address", joinColumns = @JoinColumn(name="Customer_ID"))
    private Set<AddressCollect> contacts;

}
