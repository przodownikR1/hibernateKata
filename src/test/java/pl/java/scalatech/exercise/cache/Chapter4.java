package pl.java.scalatech.exercise.cache;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Chapter4 {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
int id;
String name;
public Chapter4(String name) {
setName(name);
}
}