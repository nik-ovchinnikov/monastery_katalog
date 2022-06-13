package com.niki.pers_lib.rest.icon.icon_place;

import com.niki.pers_lib.entities.icon.icon_place.IconPlace;
import com.niki.pers_lib.entities.icon.icon_place.IconSubPlace;
import com.niki.pers_lib.services.icon.IconService;
import com.niki.pers_lib.services.icon.icon_place.IconPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/icon/place")
public class IconPlaceRest {

    @Autowired
    private IconPlaceService placeService;

    @Autowired
    private IconService service;

    @PostMapping("/add")
    public void addType(@RequestBody IconPlace place) {
        if(place.getSubPlaceList() != null) {
            for(IconSubPlace subtype: place.getSubPlaceList()) {
                subtype.setPlace(place);
            }
        }
        placeService.create(place);
    }

    @GetMapping("/getAll")
    public List<IconPlace> getAllTypeList() {
        return placeService.getAll();
    }

    @GetMapping("/checkName")
    @ResponseBody
    public List<IconPlace> checkName(@RequestParam String name) {
        return placeService.checkName(name);
    }

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deletePlace(
            @RequestParam String names
    ) {
        String[] idsArray = names.split("-");

        this.prepareIconsBeforeDelete(idsArray);

        this.placeService.delete(idsArray);
    }

    @PutMapping("/update")
    public void updatePlace(@RequestBody IconPlace updatedPlace) {
        if(updatedPlace.getSubPlaceList() != null) {
            for(IconSubPlace st: updatedPlace.getSubPlaceList()) {
                st.setPlace(updatedPlace);
            }
        }
        this.placeService.updatePlace(updatedPlace);
    }

    public void prepareIconsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.service.changeItemsIfDeletePlace(id);

        }

    }
}
