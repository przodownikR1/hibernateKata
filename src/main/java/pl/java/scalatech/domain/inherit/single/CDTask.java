package pl.java.scalatech.domain.inherit.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.inherit.single.JavaTask.JavaTaskBuilder;

@Entity
@DiscriminatorValue("cd")
@Data
@Builder
public class CDTask extends Task{

}
