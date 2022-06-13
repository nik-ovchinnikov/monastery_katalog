package com.niki.pers_lib.DAO.icon.icon_type;

import com.niki.pers_lib.entities.icon.icon_type.IconSubType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IIconSubTypeDAO extends JpaRepository<IconSubType, Long> {
    List<IconSubType> findAllByTypeName(String name);

    void deleteIconSubTypeById(long id);
}
