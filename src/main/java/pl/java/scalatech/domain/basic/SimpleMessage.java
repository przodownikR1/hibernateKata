package pl.java.scalatech.domain.basic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="SimpleMessages")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleMessage implements Serializable{

    private static final long serialVersionUID = 4843608554111160849L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    @Setter

    private Long id;

    @Column(name="MESSAGE_TEXT")
    @Getter
    @Setter
    private String text;

}
