package com.kamilcieslik.spring_boot.learninginterceptorslogging.persistence.dao;

import com.kamilcieslik.spring_boot.learninginterceptorslogging.persistence.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishTemplateDAO extends CrudRepository<Address, Integer> {
}
