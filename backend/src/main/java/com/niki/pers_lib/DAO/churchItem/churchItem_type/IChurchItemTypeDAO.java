package com.niki.pers_lib.DAO.churchItem.churchItem_type;

import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IChurchItemTypeDAO extends JpaRepository<ChurchItemType, Long>{

//    List<Type> findByName(String str);
//    Long deleteTypeByName(String str);

    List<ChurchItemType> findAllByOrderByIdDesc();

    List<ChurchItemType> findByName(String str);

}
