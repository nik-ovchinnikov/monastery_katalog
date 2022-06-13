package com.niki.pers_lib.services.churchItem.churchItem_type;

import com.niki.pers_lib.DAO.churchItem.churchItem_type.IChurchItemSubTypeDAO;
import com.niki.pers_lib.DAO.icon.icon_type.IIconSubTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ChurchItemSubTypeService implements IChurchItemSubTypeService {
    @Autowired
    private IChurchItemSubTypeDAO churchItemSubTypeDAO;


    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            long id = Integer.parseInt(name);
            churchItemSubTypeDAO.deleteChurchItemSubTypeById(id);
        }

    }
}
