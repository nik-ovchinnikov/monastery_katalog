package com.niki.pers_lib.services.relic.relic_type;

import com.niki.pers_lib.DAO.relic.relic_type.IRelicSubTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RelicSubTypeService implements IRelicSubTypeService {
    @Autowired
    private IRelicSubTypeDAO relicSubTypeDAO;


    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            long id = Integer.parseInt(name);
            relicSubTypeDAO.deleteRelicSubTypeById(id);
        }

    }
}
