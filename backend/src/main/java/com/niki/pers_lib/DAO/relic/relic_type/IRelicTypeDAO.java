package com.niki.pers_lib.DAO.relic.relic_type;

import com.niki.pers_lib.entities.relic.relic_type.RelicType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRelicTypeDAO extends JpaRepository<RelicType, Long>{

//    List<Type> findByName(String str);
//    Long deleteTypeByName(String str);

    List<RelicType> findAllByOrderByIdDesc();

    List<RelicType> findByName(String str);

}
