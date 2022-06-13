package com.niki.pers_lib.DAO.relic.relic_type;

import com.niki.pers_lib.entities.relic.relic_type.RelicSubType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRelicSubTypeDAO extends JpaRepository<RelicSubType, Long> {
    List<RelicSubType> findAllByTypeName(String name);

    void deleteRelicSubTypeById(long id);
}
