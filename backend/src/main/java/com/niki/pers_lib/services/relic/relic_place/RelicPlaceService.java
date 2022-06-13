package com.niki.pers_lib.services.relic.relic_place;

import com.niki.pers_lib.DAO.relic.relic_place.IRelicPlaceDao;
import com.niki.pers_lib.entities.relic.relic_place.RelicPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RelicPlaceService {
//    private static final Logger logger = LogManager.getLogger(IconPlaceService.class);

    @Autowired
    private IRelicPlaceDao relicPlaceDao;
    //todo сделать общий интерфейс для Place and SubPlace

    public RelicPlace create(RelicPlace relicPlace) {
//        logger.info("Добавлено новое место расположения: " + relicPlace.toString());
        return relicPlaceDao.save(relicPlace);
    }

    public List<RelicPlace> getAll() {
        List<RelicPlace> lt = relicPlaceDao.findAll();
//        logger.info("Запрос на получение всех мест расположения книг");
        return lt;
    }

    public List<RelicPlace> checkName(String str) {
        List<RelicPlace> relicPlaceArray = relicPlaceDao.findByName(str);
        return relicPlaceArray;
    }

    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            Long id = Long.parseLong(name);
            relicPlaceDao.deleteById(id);
//            logger.info("Удалёно место расположения '" + name + "'");
        }

    }

    public void updatePlace(RelicPlace updatedRelicPlace) {
        this.relicPlaceDao.save(updatedRelicPlace);
//        logger.info("Изменёно место расположения. Теперь оно выглядит так: " + updatedIconPlace.toString());
    }
}
