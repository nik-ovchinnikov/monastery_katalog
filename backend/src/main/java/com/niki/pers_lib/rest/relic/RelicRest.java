package com.niki.pers_lib.rest.relic;

import com.niki.pers_lib.entities.relic.Relic;
import com.niki.pers_lib.entities.relic.RelicPicture;
import com.niki.pers_lib.services.relic.RelicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relic")
public class RelicRest {
    @Autowired
    private RelicService relicService;

    @PostMapping("/add")
    public List<String> addRelic(@RequestBody Relic relic) {
        System.out.println(relic);
        prepareRelic(relic);
        return relicService.create(relic);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Relic> detAllRelicList() {
        return relicService.getAll();
    }

    @GetMapping("/checkKey")
    @ResponseBody
    public List<Relic> checkKey(@RequestParam String key) {
        return relicService.checkKey(key);

    }

    @PostMapping("/deleteItems")
    public void deleteItems(@RequestBody Relic[] relics) {
        for(Relic relic: relics) {
            prepareRelic(relic);
        }
        relicService.deleteItemList(relics);
    }

    @PostMapping("/update")
    public List<String> updateRelic(@RequestBody Relic relic) {
        prepareRelic(relic);
        return relicService.update(relic);
    }

    @PostMapping("/deleteOldPictures")
    public void deleteOldPictures(@RequestBody List<Long> idArray) {
        this.relicService.deleteOldPictures(idArray);
    }


    public void prepareRelic(Relic relic) {
        relic.getPlace().setSubPlaceList(null);
        relic.getType().setSubTypeList(null);
        relic.getSubPlace().setPlace(relic.getPlace());
        relic.getSubType().setType(relic.getType());
        //для пустого списка подтипов или точного места
        if(relic.getSubType().getId() == -1){
            relic.setSubType(null);
        }
        if(relic.getSubPlace().getId() == -1){
            relic.setSubPlace(null);
        }
        //создаём связь между книгой и фото
        if(relic.getPictureList() != null) {
            for(RelicPicture relicPicture: relic.getPictureList()) {
                relicPicture.setRelic(relic);
            }
        }

    }
}
