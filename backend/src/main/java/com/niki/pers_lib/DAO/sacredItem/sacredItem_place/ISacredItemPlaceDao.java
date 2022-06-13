package com.niki.pers_lib.DAO.sacredItem.sacredItem_place;

import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISacredItemPlaceDao extends JpaRepository<SacredItemPlace, Long> {
    List<SacredItemPlace> findAllByOrderByIdDesc();


    List<SacredItemPlace> findByName(String str);

}
