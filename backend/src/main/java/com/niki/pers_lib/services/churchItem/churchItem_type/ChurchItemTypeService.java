package com.niki.pers_lib.services.churchItem.churchItem_type;

import com.niki.pers_lib.DAO.churchItem.churchItem_type.IChurchItemTypeDAO;
import com.niki.pers_lib.DAO.icon.icon_type.IIconTypeDAO;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;
import com.niki.pers_lib.entities.icon.icon_type.IconType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ChurchItemTypeService implements IChurchItemTypeService {
//    private static final Logger logger = LogManager.getLogger(IconTypeService.class);

    @Autowired
    private IChurchItemTypeDAO churchItemTypeDAO;
   //todo сделать общий интерфейс для Type and SubType

    @Override
    public ChurchItemType create(ChurchItemType churchItemType) {
//       logger.info("Добавлен новый тип: " + bookType.toString());
       return churchItemTypeDAO.save(churchItemType);
    }

    public List<ChurchItemType> getAll() {
        List<ChurchItemType> lt = churchItemTypeDAO.findAll();

//        logger.info("Запрос на получение всех типов книг");
       return lt;
    }

    public List<ChurchItemType> checkName(String str) {
        List<ChurchItemType> bookTypeArray = churchItemTypeDAO.findByName(str);
        return bookTypeArray;
    }

    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            Long id = Long.parseLong(name);
            churchItemTypeDAO.deleteById(id);
//            logger.info("Удалён тип '" + name + "'");
        }

    }

    public void updateChurchItemType(ChurchItemType updatedChurchItemType) {
        this.churchItemTypeDAO.save(updatedChurchItemType);
//        logger.info("Изменён тип. Теперь он такой: " + updatedIconType.toString());
    }
}
