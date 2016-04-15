package pl.java.scalatech.domain.inherit.per_class;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.javamoney.moneta.Money;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.converter.MoneyConverter;

@Entity
@Table(name="details")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DetailProduct extends Product{
    
    @Convert(converter = MoneyConverter.class)
    private Money price;
}
