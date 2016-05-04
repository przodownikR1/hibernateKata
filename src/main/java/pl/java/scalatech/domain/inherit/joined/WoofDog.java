package pl.java.scalatech.domain.inherit.joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("HUGE_DOG")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WoofDog extends Dog {
    private static final long serialVersionUID = 1719652811915763388L;
private int weight;
}

