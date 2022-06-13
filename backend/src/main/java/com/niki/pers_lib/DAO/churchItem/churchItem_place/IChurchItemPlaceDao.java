package com.niki.pers_lib.DAO.churchItem.churchItem_place;

import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IChurchItemPlaceDao extends JpaRepository<ChurchItemPlace, Long> {
    List<ChurchItemPlace> findAllByOrderByIdDesc();


    List<ChurchItemPlace> findByName(String str);

}
