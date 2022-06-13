package com.niki.pers_lib.services.icon.icon_type;

import com.niki.pers_lib.DAO.icon.icon_type.IIconTypeDAO;
import com.niki.pers_lib.entities.icon.icon_type.IconType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IconTypeService implements IIconTypeService {
//    private static final Logger logger = LogManager.getLogger(IconTypeService.class);

    @Autowired
    private IIconTypeDAO iconTypeDAO;
   //todo сделать общий интерфейс для Type and SubType

    @Override
    public IconType create(IconType bookType) {
//       logger.info("Добавлен новый тип: " + bookType.toString());
       return iconTypeDAO.save(bookType);
    }

    public List<IconType> getAll() {
        List<IconType> lt = iconTypeDAO.findAll();

//        logger.info("Запрос на получение всех типов книг");
       return lt;
    }

    public List<IconType> checkName(String str) {
        List<IconType> bookTypeArray = iconTypeDAO.findByName(str);
        return bookTypeArray;
    }

    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            Long id = Long.parseLong(name);
            iconTypeDAO.deleteById(id);
//            logger.info("Удалён тип '" + name + "'");
        }

    }

    public void updateIconType(IconType updatedIconType) {
        this.iconTypeDAO.save(updatedIconType);
//        logger.info("Изменён тип. Теперь он такой: " + updatedIconType.toString());
    }
}
