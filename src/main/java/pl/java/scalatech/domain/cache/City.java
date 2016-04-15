package pl.java.scalatech.domain.cache;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Cacheable
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City extends AbstractEntity {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private String country;
}