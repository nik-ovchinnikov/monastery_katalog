package com.niki.pers_lib.rest.relic.relic_place;

import com.niki.pers_lib.services.relic.RelicService;
import com.niki.pers_lib.services.relic.relic_place.RelicSubPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relic/subplace")
public class RelicSubPlaceRest {
    @Autowired
    private RelicSubPlaceService relicSubPlaceService;

    @Autowired
    private RelicService relicService;

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deletePlace(
            @RequestParam String ids
    ) {
        String[] idsArray = ids.split("-");
        this.prepareRelicsBeforeDelete(idsArray);
        this.relicSubPlaceService.delete(idsArray);
    }

    public void prepareRelicsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.relicService.changeItemsIfDeleteSubPlace(id);
        }
    }
}
