package com.niki.pers_lib.DAO.relic;

import com.niki.pers_lib.entities.relic.Relic;
import com.niki.pers_lib.entities.relic.relic_place.RelicPlace;
import com.niki.pers_lib.entities.relic.relic_place.RelicSubPlace;
import com.niki.pers_lib.entities.relic.relic_type.RelicSubType;
import com.niki.pers_lib.entities.relic.relic_type.RelicType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRelicDao extends JpaRepository<Relic, Long> {
    List<Relic> findByKey(String key);

    List<Relic> findBySubType(RelicSubType iconSubType);
//    List<Relic> findByTypeId(Long id);
    List<Relic> findByType(RelicType type);
    List<Relic> findByPlace(RelicPlace iconPlace);
    List<Relic> findBySubPlace(RelicSubPlace iconSubPlace);
}
