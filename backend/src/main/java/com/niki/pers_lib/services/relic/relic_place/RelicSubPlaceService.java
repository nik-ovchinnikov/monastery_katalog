package com.niki.pers_lib.services.relic.relic_place;

import com.niki.pers_lib.DAO.relic.relic_place.IRelicSubPlaceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RelicSubPlaceService {
    @Autowired
    private IRelicSubPlaceDao relicSubPlaceDao;


    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            long id = Integer.parseInt(name);
            relicSubPlaceDao.deleteRelicSubPlaceById(id);
        }

    }
}
