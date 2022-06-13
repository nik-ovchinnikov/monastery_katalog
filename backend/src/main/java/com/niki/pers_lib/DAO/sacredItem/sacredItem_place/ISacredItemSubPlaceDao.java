package com.niki.pers_lib.DAO.sacredItem.sacredItem_place;

import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemSubPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISacredItemSubPlaceDao extends JpaRepository<SacredItemSubPlace, Long> {
    List<SacredItemSubPlace> findAllByPlaceName(String name);

    void deleteSacredItemSubPlaceById(long id);
}
