package com.niki.pers_lib.rest.icon.icon_type;

import com.niki.pers_lib.services.book.BookService;
import com.niki.pers_lib.services.book.book_type.BookSubTypeService;
import com.niki.pers_lib.services.icon.IconService;
import com.niki.pers_lib.services.icon.icon_type.IconSubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("icon/subtype")
public class IconSubTypeREST {
    @Autowired
    private IconSubTypeService iconSubTypeService;

    @Autowired
    private IconService iconService;

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deleteType(
            @RequestParam String ids
    ) {
        String[] idsArray = ids.split("-");

        this.prepareIconsBeforeDelete(idsArray);

        this.iconSubTypeService.delete(idsArray);
    }

    public void prepareIconsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.iconService.changeItemsIfDeleteSubType(id);
        }
    }
}
