package pl.java.scalatech.domain.oneToOne.primary;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;
import pl.java.scalatech.domain.oneToOne.Email;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="EMAIL_MESSAGES")
public class EmailMessage extends AbstractEntity{

    private static final long serialVersionUID = 4833517106774781504L;

    @Column(name = "MESSAGE_CONTENT")
    private String content;

    @OneToOne(fetch = FetchType.LAZY,optional = false,cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Email email;

}