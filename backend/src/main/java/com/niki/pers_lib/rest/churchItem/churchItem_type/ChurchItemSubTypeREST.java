package com.niki.pers_lib.rest.churchItem.churchItem_type;

import com.niki.pers_lib.services.churchItem.ChurchItemService;
import com.niki.pers_lib.services.churchItem.churchItem_type.ChurchItemSubTypeService;
import com.niki.pers_lib.services.icon.IconService;
import com.niki.pers_lib.services.icon.icon_type.IconSubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("churchItem/subtype")
public class ChurchItemSubTypeREST {
    @Autowired
    private ChurchItemSubTypeService churchItemSubTypeService;

    @Autowired
    private ChurchItemService churchItemService;

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deleteType(
            @RequestParam String ids
    ) {
        String[] idsArray = ids.split("-");

        this.prepareChurchItemsBeforeDelete(idsArray);

        this.churchItemSubTypeService.delete(idsArray);
    }

    public void prepareChurchItemsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.churchItemService.changeItemsIfDeleteSubType(id);
        }
    }
}
