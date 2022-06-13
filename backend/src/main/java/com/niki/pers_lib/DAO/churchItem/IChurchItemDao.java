package com.niki.pers_lib.DAO.churchItem;

import com.niki.pers_lib.entities.churchItem.ChurchItem;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemSubPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemSubType;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IChurchItemDao extends JpaRepository<ChurchItem, Long> {
    List<ChurchItem> findByKey(String key);

    List<ChurchItem> findBySubType(ChurchItemSubType iconSubType);
//    List<ChurchItem> findByTypeId(Long id);
    List<ChurchItem> findByType(ChurchItemType type);
    List<ChurchItem> findByPlace(ChurchItemPlace iconPlace);
    List<ChurchItem> findBySubPlace(ChurchItemSubPlace iconSubPlace);
}
