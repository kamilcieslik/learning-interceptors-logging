package com.kamilcieslik.spring_boot.learninginterceptorslogging.persistence.dao;

import com.kamilcieslik.spring_boot.learninginterceptorslogging.persistence.entity.SentWish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentWishDAO extends CrudRepository<SentWish, Integer> {
}
