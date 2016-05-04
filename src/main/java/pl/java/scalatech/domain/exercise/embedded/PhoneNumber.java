package pl.java.scalatech.domain.exercise.embedded;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {
    String areaCode;
    String localNumber;

}
