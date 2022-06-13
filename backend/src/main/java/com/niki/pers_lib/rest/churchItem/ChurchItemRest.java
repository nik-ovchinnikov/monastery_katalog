package com.niki.pers_lib.rest.churchItem;

import com.niki.pers_lib.entities.churchItem.ChurchItem;
import com.niki.pers_lib.entities.churchItem.ChurchItemPicture;
import com.niki.pers_lib.entities.icon.Icon;
import com.niki.pers_lib.entities.icon.IconPicture;
import com.niki.pers_lib.services.churchItem.ChurchItemService;
import com.niki.pers_lib.services.icon.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/churchItem")
public class ChurchItemRest {
    @Autowired
    private ChurchItemService churchItemService;

    @PostMapping("/add")
    public List<String> addChurchItem(@RequestBody ChurchItem churchItem) {
        System.out.println(churchItem);
        prepareChurchItem(churchItem);
        return churchItemService.create(churchItem);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<ChurchItem> detAllChurchItemList() {
        return churchItemService.getAll();
    }

    @GetMapping("/checkKey")
    @ResponseBody
    public List<ChurchItem> checkKey(@RequestParam String key) {
        return churchItemService.checkKey(key);

    }

    @PostMapping("/deleteItems")
    public void deleteItems(@RequestBody ChurchItem[] churchItems) {
        for(ChurchItem churchItem: churchItems) {
            prepareChurchItem(churchItem);
        }
        churchItemService.deleteItemList(churchItems);
    }

    @PostMapping("/update")
    public List<String> updateChurchItem(@RequestBody ChurchItem churchItem) {
        prepareChurchItem(churchItem);
        return churchItemService.update(churchItem);
    }

    @PostMapping("/deleteOldPictures")
    public void deleteOldPictures(@RequestBody List<Long> idArray) {
        this.churchItemService.deleteOldPictures(idArray);
    }


    public void prepareChurchItem(ChurchItem churchItem) {
        churchItem.getPlace().setSubPlaceList(null);
        churchItem.getType().setSubTypeList(null);
        churchItem.getSubPlace().setPlace(churchItem.getPlace());
        churchItem.getSubType().setType(churchItem.getType());
        //для пустого списка подтипов или точного места
        if(churchItem.getSubType().getId() == -1){
            churchItem.setSubType(null);
        }
        if(churchItem.getSubPlace().getId() == -1){
            churchItem.setSubPlace(null);
        }
        //создаём связь между книгой и фото
        if(churchItem.getPictureList() != null) {
            for(ChurchItemPicture churchItemPicture: churchItem.getPictureList()) {
                churchItemPicture.setChurchItem(churchItem);
            }
        }

    }
}
