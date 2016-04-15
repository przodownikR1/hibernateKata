package pl.java.scalatech.domain.inherit.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("java")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JavaTask extends Task{

    private String refactoringName;
    
}
