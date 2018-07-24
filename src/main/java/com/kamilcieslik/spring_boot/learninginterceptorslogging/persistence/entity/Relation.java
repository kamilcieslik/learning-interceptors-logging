package com.kamilcieslik.spring_boot.learninginterceptorslogging.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "relation")
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "relation_name")
    private String ralationName;

    @OneToMany(mappedBy = "relation", cascade = CascadeType.ALL)
    private List<PersonAnniversary> personAnniversaries;

    public void addPersonAnniverasry(PersonAnniversary personAnniversary) {
        if (personAnniversaries == null)
            personAnniversaries = new ArrayList<>();

        personAnniversaries.add(personAnniversary);
        personAnniversary.setRelation(this);
    }
}
