package com.niki.pers_lib.rest.churchItem.churchItem_type;

import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemSubType;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;
import com.niki.pers_lib.entities.icon.icon_type.IconSubType;
import com.niki.pers_lib.entities.icon.icon_type.IconType;
import com.niki.pers_lib.services.churchItem.ChurchItemService;
import com.niki.pers_lib.services.churchItem.churchItem_type.ChurchItemTypeService;
import com.niki.pers_lib.services.icon.IconService;
import com.niki.pers_lib.services.icon.icon_type.IconTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("churchItem/type")
public class ChurchItemTypeREST {

    @Autowired
    private ChurchItemTypeService churchItemTypeService;

    @Autowired
    private ChurchItemService churchItemService;

    @PostMapping("/add")
    public void addType(@RequestBody ChurchItemType churchItemType) {
        if(churchItemType.getSubTypeList() != null) {
            for(ChurchItemSubType subtype: churchItemType.getSubTypeList()) {
                subtype.setType(churchItemType);
            }
        }
           churchItemTypeService.create(churchItemType);
    }

    @GetMapping("/getAll")
    public List<ChurchItemType> getAllTypeList() {
       return churchItemTypeService.getAll();
    }

    @GetMapping("/checkName")
    @ResponseBody
    public List<ChurchItemType> checkName(@RequestParam String name) {
        return churchItemTypeService.checkName(name);
    }

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deleteType(
            @RequestParam String names
    ) {
        String[] idsArray = names.split("-");
//
        this.prepareChurchItemsBeforeDelete(idsArray);

        this.churchItemTypeService.delete(idsArray);
    }

    @PutMapping("/updateType")
    public void updateType(@RequestBody ChurchItemType updatedChurchItemType) {
        if(updatedChurchItemType.getSubTypeList() != null) {
            for(ChurchItemSubType st: updatedChurchItemType.getSubTypeList()) {
                st.setType(updatedChurchItemType);
            }
        }
//        System.out.println(updatedChurchItemType);
        this.churchItemTypeService.updateChurchItemType(updatedChurchItemType);
    }

    public void prepareChurchItemsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.churchItemService.changeItemsIfDeleteType(id);
        }
    }
    //todo Разобраться с обработчиком ошибок!!!
//    @ExceptionHandler(Exception.class)
//    public Response handleException(Exception e) {
//        Response error = new Response();
//        return new Response();
//    }
}
