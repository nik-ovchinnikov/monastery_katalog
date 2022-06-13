package com.niki.pers_lib.services.churchItem.churchItem_place;

import com.niki.pers_lib.DAO.churchItem.churchItem_place.IChurchItemSubPlaceDao;
import com.niki.pers_lib.DAO.icon.icon_place.IIconSubPlaceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ChurchItemSubPlaceService {
    @Autowired
    private IChurchItemSubPlaceDao churchItemSubPlaceDao;


    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            long id = Integer.parseInt(name);
            churchItemSubPlaceDao.deleteChurchItemSubPlaceById(id);
        }

    }
}
