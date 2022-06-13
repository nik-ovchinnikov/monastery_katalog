package com.niki.pers_lib.rest.sacredItem.sacredItem_place;

import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemSubPlace;
import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemPlace;
import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemSubPlace;
import com.niki.pers_lib.services.churchItem.ChurchItemService;
import com.niki.pers_lib.services.churchItem.churchItem_place.ChurchItemPlaceService;
import com.niki.pers_lib.services.sacredItem.SacredItemService;
import com.niki.pers_lib.services.sacredItem.sacredItem_place.SacredItemPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sacredItem/place")
public class SacredItemPlaceRest {

    @Autowired
    private SacredItemPlaceService placeService;

    @Autowired
    private SacredItemService service;

    @PostMapping("/add")
    public void addType(@RequestBody SacredItemPlace place) {
        if(place.getSubPlaceList() != null) {
            for(SacredItemSubPlace subtype: place.getSubPlaceList()) {
                subtype.setPlace(place);
            }
        }
        placeService.create(place);
    }

    @GetMapping("/getAll")
    public List<SacredItemPlace> getAllTypeList() {
        return placeService.getAll();
    }

    @GetMapping("/checkName")
    @ResponseBody
    public List<SacredItemPlace> checkName(@RequestParam String name) {
        return placeService.checkName(name);
    }

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deletePlace(
            @RequestParam String names
    ) {
        String[] idsArray = names.split("-");

        this.prepareSacredItemsBeforeDelete(idsArray);

        this.placeService.delete(idsArray);
    }

    @PutMapping("/update")
    public void updatePlace(@RequestBody SacredItemPlace updatedPlace) {
        if(updatedPlace.getSubPlaceList() != null) {
            for(SacredItemSubPlace st: updatedPlace.getSubPlaceList()) {
                st.setPlace(updatedPlace);
            }
        }
        this.placeService.updatePlace(updatedPlace);
    }

    public void prepareSacredItemsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.service.changeItemsIfDeletePlace(id);

        }

    }
}
