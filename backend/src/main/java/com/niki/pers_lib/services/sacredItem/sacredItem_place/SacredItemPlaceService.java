package com.niki.pers_lib.services.sacredItem.sacredItem_place;

import com.niki.pers_lib.DAO.churchItem.churchItem_place.IChurchItemPlaceDao;
import com.niki.pers_lib.DAO.sacredItem.sacredItem_place.ISacredItemPlaceDao;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemPlace;
import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SacredItemPlaceService {
//    private static final Logger logger = LogManager.getLogger(IconPlaceService.class);

    @Autowired
    private ISacredItemPlaceDao sacredItemPlaceDao;
    //todo сделать общий интерфейс для Place and SubPlace

    public SacredItemPlace create(SacredItemPlace sacredItemPlace) {
//        logger.info("Добавлено новое место расположения: " + iconPlace.toString());
        return sacredItemPlaceDao.save(sacredItemPlace);
    }

    public List<SacredItemPlace> getAll() {
        List<SacredItemPlace> lt = sacredItemPlaceDao.findAll();
//        logger.info("Запрос на получение всех мест расположения книг");
        return lt;
    }

    public List<SacredItemPlace> checkName(String str) {
        List<SacredItemPlace> sacredItemPlaceArray = sacredItemPlaceDao.findByName(str);
        return sacredItemPlaceArray;
    }

    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            Long id = Long.parseLong(name);
            sacredItemPlaceDao.deleteById(id);
//            logger.info("Удалёно место расположения '" + name + "'");
        }

    }

    public void updatePlace(SacredItemPlace updatedSacredItemPlace) {
        this.sacredItemPlaceDao.save(updatedSacredItemPlace);
//        logger.info("Изменёно место расположения. Теперь оно выглядит так: " + updatedIconPlace.toString());
    }
}
