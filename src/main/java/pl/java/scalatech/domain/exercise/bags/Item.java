package pl.java.scalatech.domain.exercise.bags;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class Item {
    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @Column(name = "FILENAME")
    @org.hibernate.annotations.CollectionId(columns = @Column(name = "IMAGE_ID") ,
    type = @org.hibernate.annotations.Type(type = "long") , generator = Constants.ID_GENERATOR)

    private Collection<String> images = new ArrayList<String>();
}