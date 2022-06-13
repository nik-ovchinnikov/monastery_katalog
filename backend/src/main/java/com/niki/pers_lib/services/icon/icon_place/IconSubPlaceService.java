package com.niki.pers_lib.services.icon.icon_place;

import com.niki.pers_lib.DAO.icon.icon_place.IIconSubPlaceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IconSubPlaceService {
    @Autowired
    private IIconSubPlaceDao iconSubPlaceDao;


    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            long id = Integer.parseInt(name);
            iconSubPlaceDao.deleteIconSubPlaceById(id);
        }

    }
}
