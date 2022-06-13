package com.niki.pers_lib.DAO.icon.icon_place;

import com.niki.pers_lib.entities.icon.icon_place.IconSubPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IIconSubPlaceDao extends JpaRepository<IconSubPlace, Long> {
    List<IconSubPlace> findAllByPlaceName(String name);

    void deleteIconSubPlaceById(long id);
}
