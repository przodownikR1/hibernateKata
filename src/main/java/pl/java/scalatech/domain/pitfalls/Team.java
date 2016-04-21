package pl.java.scalatech.domain.pitfalls;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.assertj.core.util.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.java.scalatech.domain.AbstractEntity;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Team extends AbstractEntity{


    private String name;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Player> players = Lists.newArrayList();
}
