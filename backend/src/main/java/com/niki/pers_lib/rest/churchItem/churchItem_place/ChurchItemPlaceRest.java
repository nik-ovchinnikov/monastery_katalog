package com.niki.pers_lib.rest.churchItem.churchItem_place;

import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemSubPlace;
import com.niki.pers_lib.services.churchItem.ChurchItemService;
import com.niki.pers_lib.services.churchItem.churchItem_place.ChurchItemPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/churchItem/place")
public class ChurchItemPlaceRest {

    @Autowired
    private ChurchItemPlaceService placeService;

    @Autowired
    private ChurchItemService service;

    @PostMapping("/add")
    public void addType(@RequestBody ChurchItemPlace place) {
        if(place.getSubPlaceList() != null) {
            for(ChurchItemSubPlace subtype: place.getSubPlaceList()) {
                subtype.setPlace(place);
            }
        }
        placeService.create(place);
    }

    @GetMapping("/getAll")
    public List<ChurchItemPlace> getAllTypeList() {
        return placeService.getAll();
    }

    @GetMapping("/checkName")
    @ResponseBody
    public List<ChurchItemPlace> checkName(@RequestParam String name) {
        return placeService.checkName(name);
    }

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deletePlace(
            @RequestParam String names
    ) {
        String[] idsArray = names.split("-");

        this.prepareChurchItemsBeforeDelete(idsArray);

        this.placeService.delete(idsArray);
    }

    @PutMapping("/update")
    public void updatePlace(@RequestBody ChurchItemPlace updatedPlace) {
        if(updatedPlace.getSubPlaceList() != null) {
            for(ChurchItemSubPlace st: updatedPlace.getSubPlaceList()) {
                st.setPlace(updatedPlace);
            }
        }
        this.placeService.updatePlace(updatedPlace);
    }

    public void prepareChurchItemsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.service.changeItemsIfDeletePlace(id);

        }

    }
}
