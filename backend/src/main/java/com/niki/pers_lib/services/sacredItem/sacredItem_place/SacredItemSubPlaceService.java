package com.niki.pers_lib.services.sacredItem.sacredItem_place;

import com.niki.pers_lib.DAO.churchItem.churchItem_place.IChurchItemSubPlaceDao;
import com.niki.pers_lib.DAO.sacredItem.sacredItem_place.ISacredItemSubPlaceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SacredItemSubPlaceService {
    @Autowired
    private ISacredItemSubPlaceDao sacredItemSubPlaceDao;


    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            long id = Integer.parseInt(name);
            sacredItemSubPlaceDao.deleteSacredItemSubPlaceById(id);
        }

    }
}
