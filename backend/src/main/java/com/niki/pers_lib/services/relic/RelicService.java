package com.niki.pers_lib.services.relic;

import com.niki.pers_lib.DAO.relic.IRelicDao;
import com.niki.pers_lib.DAO.relic.IRelicPictureDao;
import com.niki.pers_lib.DAO.relic.relic_place.IRelicPlaceDao;
import com.niki.pers_lib.DAO.relic.relic_place.IRelicSubPlaceDao;
import com.niki.pers_lib.DAO.relic.relic_type.IRelicSubTypeDAO;
import com.niki.pers_lib.DAO.relic.relic_type.IRelicTypeDAO;
import com.niki.pers_lib.entities.relic.Relic;
import com.niki.pers_lib.entities.relic.RelicPicture;
import com.niki.pers_lib.entities.relic.relic_place.RelicPlace;
import com.niki.pers_lib.entities.relic.relic_place.RelicSubPlace;
import com.niki.pers_lib.entities.relic.relic_type.RelicSubType;
import com.niki.pers_lib.entities.relic.relic_type.RelicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class RelicService {
//    private static final Logger logger = LogManager.getLogger(BookPlaceService.class);

    private String storageRoot = "/app/src/main/resources/static/pictures/relics/";

    @Autowired
    private IRelicDao relicDao;

    @Autowired
    private RelicFileService relicFileService;

    @Autowired
    private IRelicPictureDao relicPictureDao;

    @Autowired
    private IRelicTypeDAO relicTypeDAO;


    @Autowired
    private IRelicPlaceDao relicPlaceDao;

    @Autowired
    private IRelicSubPlaceDao relicSubPlaceDao;

    @Autowired
    private IRelicSubTypeDAO relicSubTypeDAO;

    //todo сделать общий интерфейс для Place and SubPlace

    public List<String> create(Relic relic) {

//        logger.info("Добавлена новая книга: " + relic.toString());
        System.out.println(relic);
        relicDao.save(relic);

    //Создаём массив с новыми названиями фото
        List<String> nameList = new ArrayList<String>();
        if(relic.getPictureList().size() > 0) {
            //По ключу достаём новый Id книги
            List<Relic> relicList = relicDao.findByKey(relic.getKey());
            Relic relic1 = relicList.get(0);
            // По Id книги достаём ид фот
            List<RelicPicture> relicPictureList = relicPictureDao.findByRelicId(relic1.getId());
            // Длч каждой фото по ид заполнякм имя фото, одновременно добавляя в массив, который надо будет вернуть
            for (RelicPicture bp : relicPictureList) {
                bp.setName(Long.toString(relic1.getId()) + '-' + Long.toString(bp.getId()));
                nameList.add(bp.getName());
                relicPictureDao.save(bp);
            }
        }
        return nameList;
    }
    public List<String> update(Relic relic) {

//        logger.info("Изменена книга: " + icon.toString());
        System.out.println("V nachale updateRelic");
        System.out.println(relic.getPictureList());
        List<RelicPicture> existingPictures = relicPictureDao.findByRelicId(relic.getId());
        relicDao.save(relic);

        //Добыть старые имена, после удаления
        //Эти имена надо исключить из массива полученных имён
        //оставшиеся просто вернуть и ничего не делать на фронтенде

        //Создаём массив с новыми названиями фото
        List<String> nameList = new ArrayList<String>();
        if(relic.getPictureList().size() > 0) {
            List<RelicPicture> relicPictureList = relicPictureDao.findByRelicId(relic.getId());
            // Длч каждой фото по ид заполнякм имя фото, одновременно добавляя в массив, который надо будет вернуть
            for (RelicPicture bp : relicPictureList) {
                //Добыть старые имена, после удаления
                //Эти имена надо исключить из массива полученных имён
//                boolean isNameNew = false;
//                for(BookPicture existingPicture: existingPictures) {
//                    if(existingPicture.getName() == bp.getName()){
//                        isNameNew = false;
//                    }else {
//                        isNameNew = true;
//                    }
//                }

                if(bp.getName() == "") {
                    bp.setName(Long.toString(relic.getId()) + '-' + Long.toString(bp.getId()));
                    nameList.add(bp.getName());
                    relicPictureDao.save(bp);
                }
            }
        }
        return nameList;
    }

    public List<Relic> getAll() {
        return relicDao.findAll();
    }

    public List<Relic> checkKey(String str) {
        List<Relic> relicList = relicDao.findByKey(str);
        return relicList;
    }

    public void deleteItemList(Relic[] relics) {
        for(Relic relic: relics) {
            System.out.println(relic);
            for(RelicPicture picture: relic.getPictureList()) {
                File file = new File(storageRoot + picture.getName());
                file.delete();

                relicPictureDao.delete(picture);
            }
            relicDao.delete(relic);
        }
    }
    //pri udalenii tipov i mest
    public void changeItemsIfDeleteSubType(Long id) {
        RelicSubType relicSubType = relicSubTypeDAO.getById(id);
       List<Relic> relicList = this.relicDao.findBySubType(relicSubType);
       for(Relic relic : relicList) {
           relic.setSubType(null);
           relicDao.save(relic);
       }
    }
    public void changeItemsIfDeleteType(Long id) {
        RelicType relicType= relicTypeDAO.getById(id);
        for(RelicSubType subType: relicType.getSubTypeList()){
            changeItemsIfDeleteSubType(subType.getId());
        }
        List<Relic> relicList = this.relicDao.findByType(relicType);
        for(Relic relic : relicList) {
            relic.setType(null);
            relicDao.save(relic);
        }
    }
    public void changeItemsIfDeletePlace(Long id) {
        RelicPlace relicPlace= relicPlaceDao.getById(id);
//        System.out.println("IconPlace tut");
//        System.out.println(iconPlace);
        for(RelicSubPlace subPlace: relicPlace.getSubPlaceList()){
            changeItemsIfDeleteSubPlace(subPlace.getId());
        }
        List<Relic> relicList = this.relicDao.findByPlace(relicPlace);
//        System.out.println("Spisok knig na udalenie");
//        System.out.println(relicList);
        for(Relic relic : relicList) {
            relic.setPlace(null);
            relicDao.save(relic);
        }
    }
    public void changeItemsIfDeleteSubPlace(Long id) {
        RelicSubPlace relicSubPlace = relicSubPlaceDao.getById(id);
        List<Relic> relicList = this.relicDao.findBySubPlace(relicSubPlace);
        for(Relic relic : relicList) {
            relic.setSubPlace(null);
            relicDao.save(relic);
        }
    }

    public void deleteOldPictures(List<Long> idArray) {
        relicFileService.deletePictureFiles(idArray);
        for(Long id: idArray) {
            relicPictureDao.deleteById(id);
        }
    }
}
