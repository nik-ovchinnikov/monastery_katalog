package com.niki.pers_lib.DAO.relic.relic_place;

import com.niki.pers_lib.entities.relic.relic_place.RelicPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRelicPlaceDao extends JpaRepository<RelicPlace, Long> {
    List<RelicPlace> findAllByOrderByIdDesc();


    List<RelicPlace> findByName(String str);

}
