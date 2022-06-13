package com.niki.pers_lib.services.icon.icon_type;

import com.niki.pers_lib.DAO.icon.icon_type.IIconSubTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IconSubTypeService implements IIconSubTypeService {
    @Autowired
    private IIconSubTypeDAO iconSubTypeDAO;


    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            long id = Integer.parseInt(name);
            iconSubTypeDAO.deleteIconSubTypeById(id);
        }

    }
}
