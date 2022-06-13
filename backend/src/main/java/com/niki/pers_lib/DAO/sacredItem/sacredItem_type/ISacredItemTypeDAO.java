package com.niki.pers_lib.DAO.sacredItem.sacredItem_type;

import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISacredItemTypeDAO extends JpaRepository<SacredItemType, Long>{

//    List<Type> findByName(String str);
//    Long deleteTypeByName(String str);

    List<SacredItemType> findAllByOrderByIdDesc();

    List<SacredItemType> findByName(String str);

}
