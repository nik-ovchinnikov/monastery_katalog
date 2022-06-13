package com.niki.pers_lib.DAO.sacredItem;

import com.niki.pers_lib.entities.churchItem.ChurchItem;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemSubPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemSubType;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;
import com.niki.pers_lib.entities.sacredItem.SacredItem;
import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemPlace;
import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemSubPlace;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemSubType;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISacredItemDao extends JpaRepository<SacredItem, Long> {
    List<SacredItem> findByKey(String key);

    List<SacredItem> findBySubType(SacredItemSubType iconSubType);
//    List<SacredItem> findByTypeId(Long id);
    List<SacredItem> findByType(SacredItemType type);
    List<SacredItem> findByPlace(SacredItemPlace iconPlace);
    List<SacredItem> findBySubPlace(SacredItemSubPlace iconSubPlace);
}
