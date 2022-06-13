package com.niki.pers_lib.services.sacredItem;

import com.niki.pers_lib.DAO.churchItem.IChurchItemDao;
import com.niki.pers_lib.DAO.churchItem.IChurchItemPictureDao;
import com.niki.pers_lib.DAO.churchItem.churchItem_place.IChurchItemPlaceDao;
import com.niki.pers_lib.DAO.churchItem.churchItem_place.IChurchItemSubPlaceDao;
import com.niki.pers_lib.DAO.churchItem.churchItem_type.IChurchItemSubTypeDAO;
import com.niki.pers_lib.DAO.churchItem.churchItem_type.IChurchItemTypeDAO;
import com.niki.pers_lib.DAO.sacredItem.ISacredItemDao;
import com.niki.pers_lib.DAO.sacredItem.ISacredItemPictureDao;
import com.niki.pers_lib.DAO.sacredItem.sacredItem_place.ISacredItemPlaceDao;
import com.niki.pers_lib.DAO.sacredItem.sacredItem_place.ISacredItemSubPlaceDao;
import com.niki.pers_lib.DAO.sacredItem.sacredItem_type.ISacredItemSubTypeDAO;
import com.niki.pers_lib.DAO.sacredItem.sacredItem_type.ISacredItemTypeDAO;
import com.niki.pers_lib.entities.sacredItem.SacredItem;
import com.niki.pers_lib.entities.sacredItem.SacredItemPicture;
import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemPlace;
import com.niki.pers_lib.entities.sacredItem.sacredItem_place.SacredItemSubPlace;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemSubType;
import com.niki.pers_lib.entities.sacredItem.sacredItem_type.SacredItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class SacredItemService {
//    private static final Logger logger = LogManager.getLogger(BookPlaceService.class);

    private String storageRoot = "/app/src/main/resources/static/pictures/sacredItems/";

    @Autowired
    private ISacredItemDao sacredItemDao;

    @Autowired
    private SacredItemFileService sacredItemFileService;

    @Autowired
    private ISacredItemPictureDao sacredItemPictureDao;

    @Autowired
    private ISacredItemTypeDAO sacredItemTypeDAO;


    @Autowired
    private ISacredItemPlaceDao sacredItemPlaceDao;

    @Autowired
    private ISacredItemSubPlaceDao sacredItemSubPlaceDao;

    @Autowired
    private ISacredItemSubTypeDAO sacredItemSubTypeDAO;

    //todo сделать общий интерфейс для Place and SubPlace

    public List<String> create(SacredItem sacredItem) {

//        logger.info("Добавлена новая книга: " + sacredItem.toString());
        System.out.println(sacredItem);
        sacredItemDao.save(sacredItem);

    //Создаём массив с новыми названиями фото
        List<String> nameList = new ArrayList<String>();
        if(sacredItem.getPictureList().size() > 0) {
            //По ключу достаём новый Id книги
            List<SacredItem> sacredItemList = sacredItemDao.findByKey(sacredItem.getKey());
            SacredItem sacredItem1 = sacredItemList.get(0);
            // По Id книги достаём ид фот
            List<SacredItemPicture> sacredItemPictureList = sacredItemPictureDao.findBySacredItemId(sacredItem1.getId());
            // Длч каждой фото по ид заполнякм имя фото, одновременно добавляя в массив, который надо будет вернуть
            for (SacredItemPicture bp : sacredItemPictureList) {
                bp.setName(Long.toString(sacredItem1.getId()) + '-' + Long.toString(bp.getId()));
                nameList.add(bp.getName());
                sacredItemPictureDao.save(bp);
            }
        }
        return nameList;
    }
    public List<String> update(SacredItem sacredItem) {

//        logger.info("Изменена книга: " + sacredItem.toString());
        System.out.println("V nachale updateSacredItem");
        System.out.println(sacredItem.getPictureList());
        List<SacredItemPicture> existingPictures = sacredItemPictureDao.findBySacredItemId(sacredItem.getId());
        sacredItemDao.save(sacredItem);

        //Добыть старые имена, после удаления
        //Эти имена надо исключить из массива полученных имён
        //оставшиеся просто вернуть и ничего не делать на фронтенде

        //Создаём массив с новыми названиями фото
        List<String> nameList = new ArrayList<String>();
        if(sacredItem.getPictureList().size() > 0) {
            List<SacredItemPicture> sacredItemPictureList = sacredItemPictureDao.findBySacredItemId(sacredItem.getId());
            // Длч каждой фото по ид заполнякм имя фото, одновременно добавляя в массив, который надо будет вернуть
            for (SacredItemPicture bp : sacredItemPictureList) {
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
                    bp.setName(Long.toString(sacredItem.getId()) + '-' + Long.toString(bp.getId()));
                    nameList.add(bp.getName());
                    sacredItemPictureDao.save(bp);
                }
            }
        }
        return nameList;
    }

    public List<SacredItem> getAll() {
        return sacredItemDao.findAll();
    }

    public List<SacredItem> checkKey(String str) {
        List<SacredItem> sacredItemList = sacredItemDao.findByKey(str);
        return sacredItemList;
    }

    public void deleteItemList(SacredItem[] sacredItems) {
        for(SacredItem sacredItem: sacredItems) {
            System.out.println(sacredItem);
            for(SacredItemPicture picture: sacredItem.getPictureList()) {
                File file = new File(storageRoot + picture.getName());
                file.delete();

                sacredItemPictureDao.delete(picture);
            }
            sacredItemDao.delete(sacredItem);
        }
    }
    //pri udalenii tipov i mest
    public void changeItemsIfDeleteSubType(Long id) {
        SacredItemSubType sacredItemSubType = sacredItemSubTypeDAO.getById(id);
       List<SacredItem> sacredItemList = this.sacredItemDao.findBySubType(sacredItemSubType);
       for(SacredItem sacredItem : sacredItemList) {
           sacredItem.setSubType(null);
           sacredItemDao.save(sacredItem);
       }
    }
    public void changeItemsIfDeleteType(Long id) {
        SacredItemType sacredItemType= sacredItemTypeDAO.getById(id);
        for(SacredItemSubType subType: sacredItemType.getSubTypeList()){
            changeItemsIfDeleteSubType(subType.getId());
        }
        List<SacredItem> sacredItemList = this.sacredItemDao.findByType(sacredItemType);
        for(SacredItem sacredItem : sacredItemList) {
            sacredItem.setType(null);
            sacredItemDao.save(sacredItem);
        }
    }
    public void changeItemsIfDeletePlace(Long id) {
        SacredItemPlace sacredItemPlace= sacredItemPlaceDao.getById(id);
//        System.out.println("SacredItemPlace tut");
//        System.out.println(sacredItemPlace);
        for(SacredItemSubPlace subPlace: sacredItemPlace.getSubPlaceList()){
            changeItemsIfDeleteSubPlace(subPlace.getId());
        }
        List<SacredItem> sacredItemList = this.sacredItemDao.findByPlace(sacredItemPlace);
//        System.out.println("Spisok knig na udalenie");
//        System.out.println(sacredItemList);
        for(SacredItem sacredItem : sacredItemList) {
            sacredItem.setPlace(null);
            sacredItemDao.save(sacredItem);
        }
    }
    public void changeItemsIfDeleteSubPlace(Long id) {
        SacredItemSubPlace sacredItemSubPlace = sacredItemSubPlaceDao.getById(id);
        List<SacredItem> sacredItemList = this.sacredItemDao.findBySubPlace(sacredItemSubPlace);
        for(SacredItem sacredItem : sacredItemList) {
            sacredItem.setSubPlace(null);
            sacredItemDao.save(sacredItem);
        }
    }

    public void deleteOldPictures(List<Long> idArray) {
        sacredItemFileService.deletePictureFiles(idArray);
        for(Long id: idArray) {
            sacredItemPictureDao.deleteById(id);
        }
    }
}
