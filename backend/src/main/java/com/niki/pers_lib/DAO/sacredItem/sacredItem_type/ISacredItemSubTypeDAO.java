package com.niki.pers_lib.DAO.sacredItem.sacredItem_type;

import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemSubType;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemSubType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISacredItemSubTypeDAO extends JpaRepository<SacredItemSubType, Long> {
    List<SacredItemSubType> findAllByTypeName(String name);

    void deleteSacredItemSubTypeById(long id);
}
