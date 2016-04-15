package pl.java.scalatech.domain.inherit.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Builder;
import lombok.Data;

@Entity
@DiscriminatorValue("groovy")
@Data
@Builder
public class GroovyTask extends Task{

}
