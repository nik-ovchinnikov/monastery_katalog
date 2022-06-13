package com.niki.pers_lib.rest.sacredItem;

import com.niki.pers_lib.entities.churchItem.ChurchItem;
import com.niki.pers_lib.entities.churchItem.ChurchItemPicture;
import com.niki.pers_lib.entities.sacredItem.SacredItem;
import com.niki.pers_lib.entities.sacredItem.SacredItemPicture;
import com.niki.pers_lib.services.churchItem.ChurchItemService;
import com.niki.pers_lib.services.sacredItem.SacredItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sacredItem")
public class SacredItemRest {
    @Autowired
    private SacredItemService sacredItemService;

    @PostMapping("/add")
    public List<String> addSacredItem(@RequestBody SacredItem sacredItem) {
        System.out.println(sacredItem);
        prepareSacredItem(sacredItem);
        return sacredItemService.create(sacredItem);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<SacredItem> detAllSacredItemList() {
        return sacredItemService.getAll();
    }

    @GetMapping("/checkKey")
    @ResponseBody
    public List<SacredItem> checkKey(@RequestParam String key) {
        return sacredItemService.checkKey(key);

    }

    @PostMapping("/deleteItems")
    public void deleteItems(@RequestBody SacredItem[] sacredItems) {
        for(SacredItem sacredItem: sacredItems) {
            prepareSacredItem(sacredItem);
        }
        sacredItemService.deleteItemList(sacredItems);
    }

    @PostMapping("/update")
    public List<String> updateSacredItem(@RequestBody SacredItem sacredItem) {
        prepareSacredItem(sacredItem);
        return sacredItemService.update(sacredItem);
    }

    @PostMapping("/deleteOldPictures")
    public void deleteOldPictures(@RequestBody List<Long> idArray) {
        this.sacredItemService.deleteOldPictures(idArray);
    }


    public void prepareSacredItem(SacredItem sacredItem) {
        sacredItem.getPlace().setSubPlaceList(null);
        sacredItem.getType().setSubTypeList(null);
        sacredItem.getSubPlace().setPlace(sacredItem.getPlace());
        sacredItem.getSubType().setType(sacredItem.getType());
        //для пустого списка подтипов или точного места
        if(sacredItem.getSubType().getId() == -1){
            sacredItem.setSubType(null);
        }
        if(sacredItem.getSubPlace().getId() == -1){
            sacredItem.setSubPlace(null);
        }
        //создаём связь между книгой и фото
        if(sacredItem.getPictureList() != null) {
            for(SacredItemPicture sacredItemPicture: sacredItem.getPictureList()) {

                sacredItemPicture.setSacredItem(sacredItem);
            }
        }

    }
}
