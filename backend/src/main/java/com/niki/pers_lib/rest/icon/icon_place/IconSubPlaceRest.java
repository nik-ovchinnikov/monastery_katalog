package com.niki.pers_lib.rest.icon.icon_place;

import com.niki.pers_lib.services.book.BookService;
import com.niki.pers_lib.services.book.book_place.BookSubPlaceService;
import com.niki.pers_lib.services.icon.IconService;
import com.niki.pers_lib.services.icon.icon_place.IconSubPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/icon/subplace")
public class IconSubPlaceRest {
    @Autowired
    private IconSubPlaceService bookSubPlaceService;

    @Autowired
    private IconService bookService;

    @DeleteMapping("/deleteList")
    @ResponseBody
    public void deletePlace(
            @RequestParam String ids
    ) {
        String[] idsArray = ids.split("-");
        this.prepareIconsBeforeDelete(idsArray);
        this.bookSubPlaceService.delete(idsArray);
    }

    public void prepareIconsBeforeDelete(String[] idsArray) {
        for(String stringId : idsArray) {
            Long id = Long.parseLong(stringId);
            this.bookService.changeItemsIfDeleteSubPlace(id);
        }
    }
}
