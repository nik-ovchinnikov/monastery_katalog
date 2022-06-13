package com.niki.pers_lib.rest.sacredItem.sacredItem_type;

import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemSubType;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemSubType;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemType;
import com.niki.pers_lib.services.churchItem.ChurchItemService;
import com.niki.pers_lib.services.churchItem.churchItem_type.ChurchItemTypeService;
import com.niki.pers_lib.services.sacredItem.SacredItemService;
import com.niki.pers_lib.services.sacredItem.sacredItem_type.SacredItemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sacredItem/type")
public class SacredItemTypeREST {

    @Autowired
    private SacredItemTypeService sacredItemTypeService;

    @Autowired
    private SacredItemService sacredItemService;

    @PostMapping("/add")
    public void addType(@RequestBody SacredItemType sacredItemType) {
        if(sacredItemType.getSubTypeList() != null) {
            for(SacredItemSubType subtype: sacredItemType.getSubTypeList()) {
                subtype.setType(sacredItemType);
            }
        }
           sacredItemTypeService.create(sacredItemType);
    }

    @GetMapping("/getAll")
    public List<SacredItemType> getAllTypeList() {
       return sacredItemTypeService.getAll();
    }

    @GetMapping("/checkName")
    @ResponseBody
    public List<SacredItemType> checkName(@RequestParam String name) {
        return sacredItemTypeService.checkName(name);
    }

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deleteType(
            @RequestParam String names
    ) {
        String[] idsArray = names.split("-");
//
        this.prepareSacredItemsBeforeDelete(idsArray);

        this.sacredItemTypeService.delete(idsArray);
    }

    @PutMapping("/updateType")
    public void updateType(@RequestBody SacredItemType updatedSacredItemType) {
        if(updatedSacredItemType.getSubTypeList() != null) {
            for(SacredItemSubType st: updatedSacredItemType.getSubTypeList()) {
                st.setType(updatedSacredItemType);
            }
        }
//        System.out.println(updatedSacredItemType);
        this.sacredItemTypeService.updateSacredItemType(updatedSacredItemType);
    }

    public void prepareSacredItemsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.sacredItemService.changeItemsIfDeleteType(id);
        }
    }
    //todo Разобраться с обработчиком ошибок!!!
//    @ExceptionHandler(Exception.class)
//    public Response handleException(Exception e) {
//        Response error = new Response();
//        return new Response();
//    }
}
