package pl.java.scalatech.exercise.queryTest;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;

@Entity
@Data
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Book5 {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
int id;
String title;
}