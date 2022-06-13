package com.niki.pers_lib.services.relic.relic_type;

import com.niki.pers_lib.DAO.relic.relic_type.IRelicTypeDAO;
import com.niki.pers_lib.entities.relic.relic_type.RelicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RelicTypeService implements IRelicTypeService {
//    private static final Logger logger = LogManager.getLogger(IconTypeService.class);

    @Autowired
    private IRelicTypeDAO relicTypeDAO;
   //todo сделать общий интерфейс для Type and SubType

    @Override
    public RelicType create(RelicType relicType) {
//       logger.info("Добавлен новый тип: " + bookType.toString());
       return relicTypeDAO.save(relicType);
    }

    public List<RelicType> getAll() {
        List<RelicType> lt = relicTypeDAO.findAll();

//        logger.info("Запрос на получение всех типов книг");
       return lt;
    }

    public List<RelicType> checkName(String str) {
        List<RelicType> bookTypeArray = relicTypeDAO.findByName(str);
        return bookTypeArray;
    }

    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            Long id = Long.parseLong(name);
            relicTypeDAO.deleteById(id);
//            logger.info("Удалён тип '" + name + "'");
        }

    }

    public void updateRelicType(RelicType updatedRelicType) {
        this.relicTypeDAO.save(updatedRelicType);
//        logger.info("Изменён тип. Теперь он такой: " + updatedIconType.toString());
    }
}
