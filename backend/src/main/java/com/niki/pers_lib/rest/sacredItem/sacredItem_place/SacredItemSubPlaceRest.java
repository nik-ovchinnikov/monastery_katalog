package com.niki.pers_lib.rest.sacredItem.sacredItem_place;

import com.niki.pers_lib.services.churchItem.ChurchItemService;
import com.niki.pers_lib.services.churchItem.churchItem_place.ChurchItemSubPlaceService;
import com.niki.pers_lib.services.sacredItem.SacredItemService;
import com.niki.pers_lib.services.sacredItem.sacredItem_place.SacredItemSubPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sacredItem/subplace")
public class SacredItemSubPlaceRest {
    @Autowired
    private SacredItemSubPlaceService sacredItemSubPlaceService;

    @Autowired
    private SacredItemService sacredItemService;

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deletePlace(
            @RequestParam String ids
    ) {
        String[] idsArray = ids.split("-");
        this.prepareSacredItemsBeforeDelete(idsArray);
        this.sacredItemSubPlaceService.delete(idsArray);
    }

    public void prepareSacredItemsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.sacredItemService.changeItemsIfDeleteSubPlace(id);
        }
    }
}
