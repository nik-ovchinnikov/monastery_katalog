package com.niki.pers_lib.DAO.icon.icon_type;

import com.niki.pers_lib.entities.icon.icon_type.IconType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IIconTypeDAO extends JpaRepository<IconType, Long>{

//    List<Type> findByName(String str);
//    Long deleteTypeByName(String str);

    List<IconType> findAllByOrderByIdDesc();

    List<IconType> findByName(String str);

}
