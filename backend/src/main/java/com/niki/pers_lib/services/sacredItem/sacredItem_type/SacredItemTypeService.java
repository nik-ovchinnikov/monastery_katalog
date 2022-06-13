package com.niki.pers_lib.services.sacredItem.sacredItem_type;

import com.niki.pers_lib.DAO.churchItem.churchItem_type.IChurchItemTypeDAO;
import com.niki.pers_lib.DAO.sacredItem.sacredItem_type.ISacredItemTypeDAO;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SacredItemTypeService implements ISacredItemTypeService {
//    private static final Logger logger = LogManager.getLogger(IconTypeService.class);

    @Autowired
    private ISacredItemTypeDAO sacredItemTypeDAO;
   //todo сделать общий интерфейс для Type and SubType

    @Override
    public SacredItemType create(SacredItemType sacredItemType) {
//       logger.info("Добавлен новый тип: " + bookType.toString());
       return sacredItemTypeDAO.save(sacredItemType);
    }

    public List<SacredItemType> getAll() {
        List<SacredItemType> lt = sacredItemTypeDAO.findAll();

//        logger.info("Запрос на получение всех типов книг");
       return lt;
    }

    public List<SacredItemType> checkName(String str) {
        List<SacredItemType> bookTypeArray = sacredItemTypeDAO.findByName(str);
        return bookTypeArray;
    }

    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            Long id = Long.parseLong(name);
            sacredItemTypeDAO.deleteById(id);
//            logger.info("Удалён тип '" + name + "'");
        }

    }

    public void updateSacredItemType(SacredItemType updatedSacredItemType) {
        this.sacredItemTypeDAO.save(updatedSacredItemType);
//        logger.info("Изменён тип. Теперь он такой: " + updatedIconType.toString());
    }
}
