package com.niki.pers_lib.DAO.icon;

import com.niki.pers_lib.entities.icon.Icon;
import com.niki.pers_lib.entities.icon.icon_place.IconPlace;
import com.niki.pers_lib.entities.icon.icon_place.IconSubPlace;
import com.niki.pers_lib.entities.icon.icon_type.IconSubType;
import com.niki.pers_lib.entities.icon.icon_type.IconType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IIconDao extends JpaRepository<Icon, Long> {
    List<Icon> findByKey(String key);

    List<Icon> findBySubType(IconSubType iconSubType);
//    List<Icon> findByTypeId(Long id);
    List<Icon> findByType(IconType type);
    List<Icon> findByPlace(IconPlace iconPlace);
    List<Icon> findBySubPlace(IconSubPlace iconSubPlace);
}
