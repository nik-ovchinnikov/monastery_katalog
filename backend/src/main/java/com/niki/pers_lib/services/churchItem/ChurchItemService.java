package com.niki.pers_lib.services.churchItem;

import com.niki.pers_lib.DAO.churchItem.IChurchItemDao;
import com.niki.pers_lib.DAO.churchItem.IChurchItemPictureDao;
import com.niki.pers_lib.DAO.churchItem.churchItem_place.IChurchItemPlaceDao;
import com.niki.pers_lib.DAO.churchItem.churchItem_place.IChurchItemSubPlaceDao;
import com.niki.pers_lib.DAO.churchItem.churchItem_type.IChurchItemSubTypeDAO;
import com.niki.pers_lib.DAO.churchItem.churchItem_type.IChurchItemTypeDAO;
import com.niki.pers_lib.entities.churchItem.ChurchItem;
import com.niki.pers_lib.entities.churchItem.ChurchItemPicture;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_place.ChurchItemSubPlace;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemSubType;
import com.niki.pers_lib.entities.churchItem.churchItem_type.ChurchItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChurchItemService {
//    private static final Logger logger = LogManager.getLogger(BookPlaceService.class);

    private String storageRoot = "/app/src/main/resources/static/pictures/churchItems/";

    @Autowired
    private IChurchItemDao churchItemDao;

    @Autowired
    private ChurchItemFileService churchItemFileService;

    @Autowired
    private IChurchItemPictureDao churchItemPictureDao;

    @Autowired
    private IChurchItemTypeDAO churchItemTypeDAO;


    @Autowired
    private IChurchItemPlaceDao churchItemPlaceDao;

    @Autowired
    private IChurchItemSubPlaceDao churchItemSubPlaceDao;

    @Autowired
    private IChurchItemSubTypeDAO churchItemSubTypeDAO;

    //todo сделать общий интерфейс для Place and SubPlace

    public List<String> create(ChurchItem churchItem) {

//        logger.info("Добавлена новая книга: " + churchItem.toString());
        System.out.println(churchItem);
        churchItemDao.save(churchItem);

    //Создаём массив с новыми названиями фото
        List<String> nameList = new ArrayList<String>();
        if(churchItem.getPictureList().size() > 0) {
            //По ключу достаём новый Id книги
            List<ChurchItem> churchItemList = churchItemDao.findByKey(churchItem.getKey());
            ChurchItem churchItem1 = churchItemList.get(0);
            // По Id книги достаём ид фот
            List<ChurchItemPicture> churchItemPictureList = churchItemPictureDao.findByChurchItemId(churchItem1.getId());
            // Длч каждой фото по ид заполнякм имя фото, одновременно добавляя в массив, который надо будет вернуть
            for (ChurchItemPicture bp : churchItemPictureList) {
                bp.setName(Long.toString(churchItem1.getId()) + '-' + Long.toString(bp.getId()));
                nameList.add(bp.getName());
                churchItemPictureDao.save(bp);
            }
        }
        return nameList;
    }
    public List<String> update(ChurchItem churchItem) {

//        logger.info("Изменена книга: " + churchItem.toString());
        System.out.println("V nachale updateChurchItem");
        System.out.println(churchItem.getPictureList());
        List<ChurchItemPicture> existingPictures = churchItemPictureDao.findByChurchItemId(churchItem.getId());
        churchItemDao.save(churchItem);

        //Добыть старые имена, после удаления
        //Эти имена надо исключить из массива полученных имён
        //оставшиеся просто вернуть и ничего не делать на фронтенде

        //Создаём массив с новыми названиями фото
        List<String> nameList = new ArrayList<String>();
        if(churchItem.getPictureList().size() > 0) {
            List<ChurchItemPicture> churchItemPictureList = churchItemPictureDao.findByChurchItemId(churchItem.getId());
            // Длч каждой фото по ид заполнякм имя фото, одновременно добавляя в массив, который надо будет вернуть
            for (ChurchItemPicture bp : churchItemPictureList) {
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
                    bp.setName(Long.toString(churchItem.getId()) + '-' + Long.toString(bp.getId()));
                    nameList.add(bp.getName());
                    churchItemPictureDao.save(bp);
                }
            }
        }
        return nameList;
    }

    public List<ChurchItem> getAll() {
        return churchItemDao.findAll();
    }

    public List<ChurchItem> checkKey(String str) {
        List<ChurchItem> churchItemList = churchItemDao.findByKey(str);
        return churchItemList;
    }

    public void deleteItemList(ChurchItem[] churchItems) {
        for(ChurchItem churchItem: churchItems) {
            System.out.println(churchItem);
            for(ChurchItemPicture picture: churchItem.getPictureList()) {
                File file = new File(storageRoot + picture.getName());
                file.delete();

                churchItemPictureDao.delete(picture);
            }
            churchItemDao.delete(churchItem);
        }
    }
    //pri udalenii tipov i mest
    public void changeItemsIfDeleteSubType(Long id) {
        ChurchItemSubType churchItemSubType = churchItemSubTypeDAO.getById(id);
       List<ChurchItem> churchItemList = this.churchItemDao.findBySubType(churchItemSubType);
       for(ChurchItem churchItem : churchItemList) {
           churchItem.setSubType(null);
           churchItemDao.save(churchItem);
       }
    }
    public void changeItemsIfDeleteType(Long id) {
        ChurchItemType churchItemType= churchItemTypeDAO.getById(id);
        for(ChurchItemSubType subType: churchItemType.getSubTypeList()){
            changeItemsIfDeleteSubType(subType.getId());
        }
        List<ChurchItem> churchItemList = this.churchItemDao.findByType(churchItemType);
        for(ChurchItem churchItem : churchItemList) {
            churchItem.setType(null);
            churchItemDao.save(churchItem);
        }
    }
    public void changeItemsIfDeletePlace(Long id) {
        ChurchItemPlace churchItemPlace= churchItemPlaceDao.getById(id);
//        System.out.println("ChurchItemPlace tut");
//        System.out.println(churchItemPlace);
        for(ChurchItemSubPlace subPlace: churchItemPlace.getSubPlaceList()){
            changeItemsIfDeleteSubPlace(subPlace.getId());
        }
        List<ChurchItem> churchItemList = this.churchItemDao.findByPlace(churchItemPlace);
//        System.out.println("Spisok knig na udalenie");
//        System.out.println(churchItemList);
        for(ChurchItem churchItem : churchItemList) {
            churchItem.setPlace(null);
            churchItemDao.save(churchItem);
        }
    }
    public void changeItemsIfDeleteSubPlace(Long id) {
        ChurchItemSubPlace churchItemSubPlace = churchItemSubPlaceDao.getById(id);
        List<ChurchItem> churchItemList = this.churchItemDao.findBySubPlace(churchItemSubPlace);
        for(ChurchItem churchItem : churchItemList) {
            churchItem.setSubPlace(null);
            churchItemDao.save(churchItem);
        }
    }

    public void deleteOldPictures(List<Long> idArray) {
        churchItemFileService.deletePictureFiles(idArray);
        for(Long id: idArray) {
            churchItemPictureDao.deleteById(id);
        }
    }
}
