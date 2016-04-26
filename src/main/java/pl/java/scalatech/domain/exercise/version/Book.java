package pl.java.scalatech.domain.exercise.version;

import javax.persistence.Entity;
import javax.persistence.Version;

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
public class Book extends AbstractEntity {

    private static final long serialVersionUID = 8278795721222257616L;
    @Version
    private long version;

    private String name;
}