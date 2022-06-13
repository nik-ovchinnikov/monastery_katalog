package com.niki.pers_lib.rest.relic.relic_place;

import com.niki.pers_lib.entities.relic.relic_place.RelicPlace;
import com.niki.pers_lib.entities.relic.relic_place.RelicSubPlace;
import com.niki.pers_lib.services.relic.RelicService;
import com.niki.pers_lib.services.relic.relic_place.RelicPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relic/place")
public class RelicPlaceRest {

    @Autowired
    private RelicPlaceService relicPlaceService;

    @Autowired
    private RelicService relicService;

    @PostMapping("/add")
    public void addType(@RequestBody RelicPlace place) {
        if(place.getSubPlaceList() != null) {
            for(RelicSubPlace subtype: place.getSubPlaceList()) {
                subtype.setPlace(place);
            }
        }
        relicPlaceService.create(place);
    }

    @GetMapping("/getAll")
    public List<RelicPlace> getAllTypeList() {
        return relicPlaceService.getAll();
    }

    @GetMapping("/checkName")
    @ResponseBody
    public List<RelicPlace> checkName(@RequestParam String name) {
        return relicPlaceService.checkName(name);
    }

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deletePlace(
            @RequestParam String names
    ) {
        String[] idsArray = names.split("-");

        this.prepareRelicsBeforeDelete(idsArray);

        this.relicPlaceService.delete(idsArray);
    }

    @PutMapping("/update")
    public void updatePlace(@RequestBody RelicPlace updatedPlace) {
        if(updatedPlace.getSubPlaceList() != null) {
            for(RelicSubPlace st: updatedPlace.getSubPlaceList()) {
                st.setPlace(updatedPlace);
            }
        }
        this.relicPlaceService.updatePlace(updatedPlace);
    }

    public void prepareRelicsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.relicService.changeItemsIfDeletePlace(id);

        }

    }
}
