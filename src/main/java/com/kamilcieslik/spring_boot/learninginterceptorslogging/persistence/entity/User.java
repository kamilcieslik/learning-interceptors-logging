package com.kamilcieslik.spring_boot.learninginterceptorslogging.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private List<WishTemplate> wishTemplates;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PersonAnniversary> personAnniversaries;

    public void addWishTemplate(WishTemplate wishTemplate) {
        if (wishTemplates == null)
            wishTemplates = new ArrayList<>();

        wishTemplates.add(wishTemplate);
        wishTemplate.setUser(this);
    }

    public void addPersonAnniversary(PersonAnniversary personAnniversary) {
        if (personAnniversaries == null)
            personAnniversaries = new ArrayList<>();

        personAnniversaries.add(personAnniversary);
        personAnniversary.setUser(this);
    }
}