package pl.java.scalatech.domain.exercise.embedded;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class Employee {
    @Embedded
    @ElementCollection(fetch = FetchType.LAZY)
    private Map<String,PhoneNumber> phones = new HashMap<>();
}
