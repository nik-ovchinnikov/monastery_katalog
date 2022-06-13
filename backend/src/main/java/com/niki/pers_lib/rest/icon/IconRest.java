package com.niki.pers_lib.rest.icon;

import com.niki.pers_lib.entities.icon.Icon;
import com.niki.pers_lib.entities.icon.IconPicture;
import com.niki.pers_lib.services.icon.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/icon")
public class IconRest {
    @Autowired
    private IconService iconService;

    @PostMapping("/add")
    public List<String> addIcon(@RequestBody Icon icon) {
        System.out.println(icon);
        prepareIcon(icon);
        return iconService.create(icon);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Icon> detAllIconList() {
        return iconService.getAll();
    }

    @GetMapping("/checkKey")
    @ResponseBody
    public List<Icon> checkKey(@RequestParam String key) {
        return iconService.checkKey(key);

    }

    @PostMapping("/deleteItems")
    public void deleteItems(@RequestBody Icon[] icons) {
        for(Icon icon: icons) {
            prepareIcon(icon);
        }
        iconService.deleteItemList(icons);
    }

    @PostMapping("/update")
    public List<String> updateIcon(@RequestBody Icon icon) {
        prepareIcon(icon);
        return iconService.update(icon);
    }

    @PostMapping("/deleteOldPictures")
    public void deleteOldPictures(@RequestBody List<Long> idArray) {
        this.iconService.deleteOldPictures(idArray);
    }


    public void prepareIcon(Icon icon) {
        icon.getPlace().setSubPlaceList(null);
        icon.getType().setSubTypeList(null);
        icon.getSubPlace().setPlace(icon.getPlace());
        icon.getSubType().setType(icon.getType());
        //для пустого списка подтипов или точного места
        if(icon.getSubType().getId() == -1){
            icon.setSubType(null);
        }
        if(icon.getSubPlace().getId() == -1){
            icon.setSubPlace(null);
        }
        //создаём связь между книгой и фото
        if(icon.getPictureList() != null) {
            for(IconPicture iconPicture: icon.getPictureList()) {
                iconPicture.setIcon(icon);
            }
        }

    }
}
