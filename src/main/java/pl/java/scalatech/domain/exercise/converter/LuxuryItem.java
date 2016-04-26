package pl.java.scalatech.domain.exercise.converter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LuxuryItem extends AbstractEntity{

    private static final long serialVersionUID = 7564859156681516002L;
@Convert(converter = MonetaryAmountConverter.class,disableConversion = false)
@Column(name = "PRICE", length = 63)
private MonetaryAmount buyNowPrice;
// ...
}