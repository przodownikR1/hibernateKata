package pl.java.scalatech.domain.pitfalls;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.java.scalatech.domain.AbstractEntity;
@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player extends AbstractEntity{

    private String name;
}
