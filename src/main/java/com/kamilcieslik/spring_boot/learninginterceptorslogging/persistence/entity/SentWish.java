package com.kamilcieslik.spring_boot.learninginterceptorslogging.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "sent_wish")
public class SentWish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "post_date")
    private Date postDate;

    @Column(name = "sent_by_letter")
    private Boolean sentByLetter;

    @Column(name = "sent_by_email")
    private Boolean sentByEmail;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "person_anniversary_id")
    private PersonAnniversary personAnniversary;
}
