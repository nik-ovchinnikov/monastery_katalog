package com.niki.pers_lib.rest.icon.icon_type;

import com.niki.pers_lib.entities.icon.icon_type.IconSubType;
import com.niki.pers_lib.entities.icon.icon_type.IconType;
import com.niki.pers_lib.services.icon.IconService;
import com.niki.pers_lib.services.icon.icon_type.IconTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("icon/type")
public class IconTypeREST {

    @Autowired
    private IconTypeService iconTypeService;

    @Autowired
    private IconService iconService;

    @PostMapping("/add")
    public void addType(@RequestBody IconType iconType) {
        if(iconType.getSubTypeList() != null) {
            for(IconSubType subtype: iconType.getSubTypeList()) {
                subtype.setType(iconType);
            }
        }
           iconTypeService.create(iconType);
    }

    @GetMapping("/getAll")
    public List<IconType> getAllTypeList() {
       return iconTypeService.getAll();
    }

    @GetMapping("/checkName")
    @ResponseBody
    public List<IconType> checkName(@RequestParam String name) {
        return iconTypeService.checkName(name);
    }

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deleteType(
            @RequestParam String names
    ) {
        String[] idsArray = names.split("-");
//
        this.prepareIconsBeforeDelete(idsArray);

        this.iconTypeService.delete(idsArray);
    }

    @PutMapping("/updateType")
    public void updateType(@RequestBody IconType updatedIconType) {
        if(updatedIconType.getSubTypeList() != null) {
            for(IconSubType st: updatedIconType.getSubTypeList()) {
                st.setType(updatedIconType);
            }
        }
//        System.out.println(updatedIconType);
        this.iconTypeService.updateIconType(updatedIconType);
    }

    public void prepareIconsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.iconService.changeItemsIfDeleteType(id);
        }
    }
    //todo Разобраться с обработчиком ошибок!!!
//    @ExceptionHandler(Exception.class)
//    public Response handleException(Exception e) {
//        Response error = new Response();
//        return new Response();
//    }
}
