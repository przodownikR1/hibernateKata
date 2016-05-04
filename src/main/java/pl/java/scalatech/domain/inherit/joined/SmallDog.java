package pl.java.scalatech.domain.inherit.joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("SMALL_DOG")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class SmallDog extends Dog {

    private static final long serialVersionUID = -3425863781904145186L;
    private String nick;
}