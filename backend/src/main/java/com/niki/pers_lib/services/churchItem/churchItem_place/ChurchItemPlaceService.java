package com.niki.pers_lib.services.churchItem.churchItem_place;

import com.niki.pers_lib.DAO.churchItem.churchItem_place.IChurchItemPlaceDao;
import com.niki.pers_lib.DAO.icon.icon_place.IIconPlaceDao;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemPlace;
import com.niki.pers_lib.entities.icon.icon_place.IconPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ChurchItemPlaceService {
//    private static final Logger logger = LogManager.getLogger(IconPlaceService.class);

    @Autowired
    private IChurchItemPlaceDao churchItemPlaceDao;
    //todo сделать общий интерфейс для Place and SubPlace

    public ChurchItemPlace create(ChurchItemPlace churchItemPlace) {
//        logger.info("Добавлено новое место расположения: " + iconPlace.toString());
        return churchItemPlaceDao.save(churchItemPlace);
    }

    public List<ChurchItemPlace> getAll() {
        List<ChurchItemPlace> lt = churchItemPlaceDao.findAll();
//        logger.info("Запрос на получение всех мест расположения книг");
        return lt;
    }

    public List<ChurchItemPlace> checkName(String str) {
        List<ChurchItemPlace> churchItemPlaceArray = churchItemPlaceDao.findByName(str);
        return churchItemPlaceArray;
    }

    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            Long id = Long.parseLong(name);
            churchItemPlaceDao.deleteById(id);
//            logger.info("Удалёно место расположения '" + name + "'");
        }

    }

    public void updatePlace(ChurchItemPlace updatedChurchItemPlace) {
        this.churchItemPlaceDao.save(updatedChurchItemPlace);
//        logger.info("Изменёно место расположения. Теперь оно выглядит так: " + updatedIconPlace.toString());
    }
}
