package com.kamilcieslik.spring_boot.learninginterceptorslogging.persistence.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "person_anniversary")
public class PersonAnniversary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "anniversary_date")
    private Date anniversaryDate;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private Boolean birthday;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "relation_id")
    private Relation relation;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "personAnniversary", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<SentWish> sentWishes;

    public void addSentWish(SentWish sentWish) {
        if (sentWishes == null)
            sentWishes = new ArrayList<>();

        sentWishes.add(sentWish);
        sentWish.setPersonAnniversary(this);
    }
}