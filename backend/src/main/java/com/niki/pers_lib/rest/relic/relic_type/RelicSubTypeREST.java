package com.niki.pers_lib.rest.relic.relic_type;

import com.niki.pers_lib.services.relic.RelicService;
import com.niki.pers_lib.services.relic.relic_type.RelicSubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("relic/subtype")
public class RelicSubTypeREST {
    @Autowired
    private RelicSubTypeService relicSubTypeService;

    @Autowired
    private RelicService relicService;

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deleteType(
            @RequestParam String ids
    ) {
        String[] idsArray = ids.split("-");

        this.prepareRelicsBeforeDelete(idsArray);

        this.relicSubTypeService.delete(idsArray);
    }

    public void prepareRelicsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.relicService.changeItemsIfDeleteSubType(id);
        }
    }
}
