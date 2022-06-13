package com.niki.pers_lib.DAO.churchItem.churchItem_type;

import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemSubType;
import com.niki.pers_lib.entities.icon.icon_type.IconSubType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IChurchItemSubTypeDAO extends JpaRepository<ChurchItemSubType, Long> {
    List<ChurchItemSubType> findAllByTypeName(String name);

    void deleteChurchItemSubTypeById(long id);
}
