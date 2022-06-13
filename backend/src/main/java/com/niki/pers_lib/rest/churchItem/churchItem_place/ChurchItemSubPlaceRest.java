package com.niki.pers_lib.rest.churchItem.churchItem_place;

import com.niki.pers_lib.services.churchItem.ChurchItemService;
import com.niki.pers_lib.services.churchItem.churchItem_place.ChurchItemSubPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/churchItem/subplace")
public class ChurchItemSubPlaceRest {
    @Autowired
    private ChurchItemSubPlaceService churchItemSubPlaceService;

    @Autowired
    private ChurchItemService churchItemService;

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deletePlace(
            @RequestParam String ids
    ) {
        String[] idsArray = ids.split("-");
        this.prepareChurchItemsBeforeDelete(idsArray);
        this.churchItemSubPlaceService.delete(idsArray);
    }

    public void prepareChurchItemsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.churchItemService.changeItemsIfDeleteSubPlace(id);
        }
    }
}
