package pl.java.scalatech.domain.cache;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Cacheable
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel extends AbstractEntity {

    @ManyToOne(optional = false)
	@NaturalId
	private City city;

	@Column(nullable = false)
	@NaturalId
	private String name;
}