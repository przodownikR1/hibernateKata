package pl.java.scalatech.domain.exercise.query;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.java.scalatech.domain.AbstractEntity;

@Table(name="messageQuery")
@Entity
@NamedQueries({
	  @NamedQuery(name = "Message.list", query = "From Message"),
	  @NamedQuery(name = "Message.byId", query = "Select m from Message m where m.id = :id")
	})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Message extends AbstractEntity{

    private static final long serialVersionUID = 8587461142788551788L;
        private String message;
}