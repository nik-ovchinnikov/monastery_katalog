package com.niki.pers_lib.DAO.churchItem.churchItem_place;

import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemSubPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IChurchItemSubPlaceDao extends JpaRepository<ChurchItemSubPlace, Long> {
    List<ChurchItemSubPlace> findAllByPlaceName(String name);

    void deleteChurchItemSubPlaceById(long id);
}
