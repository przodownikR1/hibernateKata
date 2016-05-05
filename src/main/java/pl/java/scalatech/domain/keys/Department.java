package pl.java.scalatech.domain.keys;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Department {

    @Id

    private Long id;

    @NotNull
    protected String name;

    public Department(String name) {
        this.name = name;
    }

}
