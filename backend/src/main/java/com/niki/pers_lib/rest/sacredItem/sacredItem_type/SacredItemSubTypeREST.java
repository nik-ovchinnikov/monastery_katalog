package com.niki.pers_lib.rest.sacredItem.sacredItem_type;

import com.niki.pers_lib.services.churchItem.ChurchItemService;
import com.niki.pers_lib.services.churchItem.churchItem_type.ChurchItemSubTypeService;
import com.niki.pers_lib.services.sacredItem.SacredItemService;
import com.niki.pers_lib.services.sacredItem.sacredItem_type.SacredItemSubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sacredItem/subtype")
public class SacredItemSubTypeREST {
    @Autowired
    private SacredItemSubTypeService sacredItemSubTypeService;

    @Autowired
    private SacredItemService sacredItemService;

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deleteType(
            @RequestParam String ids
    ) {
        String[] idsArray = ids.split("-");

        this.prepareSacredItemsBeforeDelete(idsArray);

        this.sacredItemSubTypeService.delete(idsArray);
    }

    public void prepareSacredItemsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.sacredItemService.changeItemsIfDeleteSubType(id);
        }
    }
}
