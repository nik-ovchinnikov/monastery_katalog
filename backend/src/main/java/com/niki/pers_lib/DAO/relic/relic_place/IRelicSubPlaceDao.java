package com.niki.pers_lib.DAO.relic.relic_place;

import com.niki.pers_lib.entities.relic.relic_place.RelicSubPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRelicSubPlaceDao extends JpaRepository<RelicSubPlace, Long> {
    List<RelicSubPlace> findAllByPlaceName(String name);

    void deleteRelicSubPlaceById(long id);
}
