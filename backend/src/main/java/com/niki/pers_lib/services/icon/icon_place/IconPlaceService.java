package com.niki.pers_lib.services.icon.icon_place;

import com.niki.pers_lib.DAO.icon.icon_place.IIconPlaceDao;
import com.niki.pers_lib.entities.icon.icon_place.IconPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IconPlaceService {
//    private static final Logger logger = LogManager.getLogger(IconPlaceService.class);

    @Autowired
    private IIconPlaceDao iconPlaceDao;
    //todo сделать общий интерфейс для Place and SubPlace

    public IconPlace create(IconPlace iconPlace) {
//        logger.info("Добавлено новое место расположения: " + iconPlace.toString());
        return iconPlaceDao.save(iconPlace);
    }

    public List<IconPlace> getAll() {
        List<IconPlace> lt = iconPlaceDao.findAll();
//        logger.info("Запрос на получение всех мест расположения книг");
        return lt;
    }

    public List<IconPlace> checkName(String str) {
        List<IconPlace> iconPlaceArray = iconPlaceDao.findByName(str);
        return iconPlaceArray;
    }

    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            Long id = Long.parseLong(name);
            iconPlaceDao.deleteById(id);
//            logger.info("Удалёно место расположения '" + name + "'");
        }

    }

    public void updatePlace(IconPlace updatedIconPlace) {
        this.iconPlaceDao.save(updatedIconPlace);
//        logger.info("Изменёно место расположения. Теперь оно выглядит так: " + updatedIconPlace.toString());
    }
}
