package pl.java.scalatech.domain.exercise;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ItemType extends AbstractEntity {

    private static final long serialVersionUID = 1473736886820237653L;
    @org.hibernate.annotations.Type(type = "yes_no")
    protected boolean verified = false;
}