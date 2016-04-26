package pl.java.scalatech.domain.manyToOne;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Offer {
    @ManyToOne
    @JoinColumn(name = "ITEM_ID", nullable = false,

    foreignKey = @ForeignKey(name = "FK_ITEM_ID") )
    private Item item;



}