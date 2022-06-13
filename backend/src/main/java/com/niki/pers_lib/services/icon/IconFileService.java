package com.niki.pers_lib.services.icon;

import com.niki.pers_lib.DAO.icon.IIconPictureDao;
import com.niki.pers_lib.DAO.icon.IconPictureDao;
import com.niki.pers_lib.entities.icon.IconPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IconFileService {

    @Autowired
    private IIconPictureDao iconPictureDao;

//    private String storageRoot = "E:\\Workspace\\personal_lib\\backend\\src\\main\\resources\\pictures\\books\\";
    private String storageRoot = "/app/src/main/resources/static/pictures/icons/";
    private String storageRoot2 = "/app/target/classes/static/pictures/icons/";

    public void fileUpload(MultipartFile file, String fileName) throws IOException {

        List<String> storageRootList = new ArrayList<>();
        storageRootList.add(storageRoot);
        storageRootList.add(storageRoot2);
        this.creatingStorageDirsIfNotExists(storageRootList);
        file.transferTo(new File(storageRoot + fileName));
        file.transferTo(new File(storageRoot2 + fileName));
    }

    public void deletePictureFiles(List<Long> idsArray) {
        System.out.println("ID spisok");
        System.out.println(idsArray);
        for(Long id : idsArray) {
            IconPicture picture = iconPictureDao.getById(id);
            File file = new File(storageRoot + picture.getName());
            file.delete();
            File file2 = new File(storageRoot2 + picture.getName());
            file2.delete();
        }
    }

    public void creatingStorageDirsIfNotExists(List<String> dirNameArray) {
        for(String storageRoot: dirNameArray) {
            File theDir = new File(storageRoot);
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
        }

    }
}
