package pl.java.scalatech.domain.inherit.per_class;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="stock")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StockProduct extends Product implements Serializable{
private static final long serialVersionUID = 1620238240796817290L;
private String currency;

}