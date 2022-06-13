package com.niki.pers_lib.services.sacredItem.sacredItem_type;

import com.niki.pers_lib.DAO.churchItem.churchItem_type.IChurchItemSubTypeDAO;
import com.niki.pers_lib.DAO.sacredItem.sacredItem_type.ISacredItemSubTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SacredItemSubTypeService implements ISacredItemSubTypeService {
    @Autowired
    private ISacredItemSubTypeDAO sacredItemSubTypeDAO;


    @Transactional
    public void delete(String[] names) {
        for(String name: names) {
            long id = Integer.parseInt(name);
            sacredItemSubTypeDAO.deleteSacredItemSubTypeById(id);
        }

    }
}
