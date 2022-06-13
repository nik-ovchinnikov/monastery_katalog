package com.niki.pers_lib.rest.relic.relic_type;

import com.niki.pers_lib.entities.relic.relic_type.RelicSubType;
import com.niki.pers_lib.entities.relic.relic_type.RelicType;
import com.niki.pers_lib.services.relic.RelicService;
import com.niki.pers_lib.services.relic.relic_type.RelicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("relic/type")
public class RelicTypeREST {

    @Autowired
    private RelicTypeService relicTypeService;

    @Autowired
    private RelicService relicService;

    @PostMapping("/add")
    public void addType(@RequestBody RelicType relicType) {
        if(relicType.getSubTypeList() != null) {
            for(RelicSubType subtype: relicType.getSubTypeList()) {
                subtype.setType(relicType);
            }
        }
           relicTypeService.create(relicType);
    }

    @GetMapping("/getAll")
    public List<RelicType> getAllTypeList() {
       return relicTypeService.getAll();
    }

    @GetMapping("/checkName")
    @ResponseBody
    public List<RelicType> checkName(@RequestParam String name) {
        return relicTypeService.checkName(name);
    }

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deleteType(
            @RequestParam String names
    ) {
        String[] idsArray = names.split("-");
//
        this.prepareRelicsBeforeDelete(idsArray);

        this.relicTypeService.delete(idsArray);
    }

    @PutMapping("/updateType")
    public void updateType(@RequestBody RelicType updatedRelicType) {
        if(updatedRelicType.getSubTypeList() != null) {
            for(RelicSubType st: updatedRelicType.getSubTypeList()) {
                st.setType(updatedRelicType);
            }
        }
//        System.out.println(updatedIconType);
        this.relicTypeService.updateRelicType(updatedRelicType);
    }

    public void prepareRelicsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.relicService.changeItemsIfDeleteType(id);
        }
    }
    //todo Разобраться с обработчиком ошибок!!!
//    @ExceptionHandler(Exception.class)
//    public Response handleException(Exception e) {
//        Response error = new Response();
//        return new Response();
//    }
}
