package com.niki.pers_lib.services.icon;

import com.niki.pers_lib.DAO.icon.IIconDao;
import com.niki.pers_lib.DAO.icon.IIconPictureDao;
import com.niki.pers_lib.DAO.icon.icon_place.IIconPlaceDao;
import com.niki.pers_lib.DAO.icon.icon_place.IIconSubPlaceDao;
import com.niki.pers_lib.DAO.icon.icon_type.IIconSubTypeDAO;
import com.niki.pers_lib.DAO.icon.icon_type.IIconTypeDAO;
import com.niki.pers_lib.entities.icon.Icon;
import com.niki.pers_lib.entities.icon.IconPicture;
import com.niki.pers_lib.entities.icon.icon_place.IconPlace;
import com.niki.pers_lib.entities.icon.icon_place.IconSubPlace;
import com.niki.pers_lib.entities.icon.icon_type.IconSubType;
import com.niki.pers_lib.entities.icon.icon_type.IconType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class IconService {
//    private static final Logger logger = LogManager.getLogger(BookPlaceService.class);

    private String storageRoot = "/app/src/main/resources/static/pictures/icons/";

    @Autowired
    private IIconDao iconDao;

    @Autowired
    private IconFileService iconFileService;

    @Autowired
    private IIconPictureDao iconPictureDao;

    @Autowired
    private IIconTypeDAO iconTypeDAO;


    @Autowired
    private IIconPlaceDao iconPlaceDao;

    @Autowired
    private IIconSubPlaceDao iconSubPlaceDao;

    @Autowired
    private IIconSubTypeDAO iconSubTypeDAO;

    //todo сделать общий интерфейс для Place and SubPlace

    public List<String> create(Icon icon) {

//        logger.info("Добавлена новая книга: " + icon.toString());
        System.out.println(icon);
        iconDao.save(icon);

    //Создаём массив с новыми названиями фото
        List<String> nameList = new ArrayList<String>();
        if(icon.getPictureList().size() > 0) {
            //По ключу достаём новый Id книги
            List<Icon> iconList = iconDao.findByKey(icon.getKey());
            Icon icon1 = iconList.get(0);
            // По Id книги достаём ид фот
            List<IconPicture> iconPictureList = iconPictureDao.findByIconId(icon1.getId());
            // Длч каждой фото по ид заполнякм имя фото, одновременно добавляя в массив, который надо будет вернуть
            for (IconPicture bp : iconPictureList) {
                bp.setName(Long.toString(icon1.getId()) + '-' + Long.toString(bp.getId()));
                nameList.add(bp.getName());
                iconPictureDao.save(bp);
            }
        }
        return nameList;
    }
    public List<String> update(Icon icon) {

//        logger.info("Изменена книга: " + icon.toString());
        System.out.println("V nachale updateIcon");
        System.out.println(icon.getPictureList());
        List<IconPicture> existingPictures = iconPictureDao.findByIconId(icon.getId());
        iconDao.save(icon);

        //Добыть старые имена, после удаления
        //Эти имена надо исключить из массива полученных имён
        //оставшиеся просто вернуть и ничего не делать на фронтенде

        //Создаём массив с новыми названиями фото
        List<String> nameList = new ArrayList<String>();
        if(icon.getPictureList().size() > 0) {
            List<IconPicture> iconPictureList = iconPictureDao.findByIconId(icon.getId());
            // Длч каждой фото по ид заполнякм имя фото, одновременно добавляя в массив, который надо будет вернуть
            for (IconPicture bp : iconPictureList) {
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
                    bp.setName(Long.toString(icon.getId()) + '-' + Long.toString(bp.getId()));
                    nameList.add(bp.getName());
                    iconPictureDao.save(bp);
                }
            }
        }
        return nameList;
    }

    public List<Icon> getAll() {
        return iconDao.findAll();
    }

    public List<Icon> checkKey(String str) {
        List<Icon> iconList = iconDao.findByKey(str);
        return iconList;
    }

    public void deleteItemList(Icon[] icons) {
        for(Icon icon: icons) {
            System.out.println(icon);
            for(IconPicture picture: icon.getPictureList()) {
                File file = new File(storageRoot + picture.getName());
                file.delete();

                iconPictureDao.delete(picture);
            }
            iconDao.delete(icon);
        }
    }
    //pri udalenii tipov i mest
    public void changeItemsIfDeleteSubType(Long id) {
        IconSubType iconSubType = iconSubTypeDAO.getById(id);
       List<Icon> iconList = this.iconDao.findBySubType(iconSubType);
       for(Icon icon : iconList) {
           icon.setSubType(null);
           iconDao.save(icon);
       }
    }
    public void changeItemsIfDeleteType(Long id) {
        IconType iconType= iconTypeDAO.getById(id);
        for(IconSubType subType: iconType.getSubTypeList()){
            changeItemsIfDeleteSubType(subType.getId());
        }
        List<Icon> iconList = this.iconDao.findByType(iconType);
        for(Icon icon : iconList) {
            icon.setType(null);
            iconDao.save(icon);
        }
    }
    public void changeItemsIfDeletePlace(Long id) {
        IconPlace iconPlace= iconPlaceDao.getById(id);
//        System.out.println("IconPlace tut");
//        System.out.println(iconPlace);
        for(IconSubPlace subPlace: iconPlace.getSubPlaceList()){
            changeItemsIfDeleteSubPlace(subPlace.getId());
        }
        List<Icon> iconList = this.iconDao.findByPlace(iconPlace);
//        System.out.println("Spisok knig na udalenie");
//        System.out.println(iconList);
        for(Icon icon : iconList) {
            icon.setPlace(null);
            iconDao.save(icon);
        }
    }
    public void changeItemsIfDeleteSubPlace(Long id) {
        IconSubPlace iconSubPlace = iconSubPlaceDao.getById(id);
        List<Icon> iconList = this.iconDao.findBySubPlace(iconSubPlace);
        for(Icon icon : iconList) {
            icon.setSubPlace(null);
            iconDao.save(icon);
        }
    }

    public void deleteOldPictures(List<Long> idArray) {
        iconFileService.deletePictureFiles(idArray);
        for(Long id: idArray) {
            iconPictureDao.deleteById(id);
        }
    }
}
