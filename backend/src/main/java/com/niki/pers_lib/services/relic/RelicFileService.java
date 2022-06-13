package com.niki.pers_lib.services.relic;

import com.niki.pers_lib.DAO.relic.IRelicPictureDao;
import com.niki.pers_lib.entities.relic.RelicPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RelicFileService {

    @Autowired
    private IRelicPictureDao relicPictureDao;

//    private String storageRoot = "E:\\Workspace\\personal_lib\\backend\\src\\main\\resources\\pictures\\books\\";
    private String storageRoot = "/app/src/main/resources/static/pictures/relics/";
    private String storageRoot2 = "/app/target/classes/static/pictures/relics/";

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
            RelicPicture picture = relicPictureDao.getById(id);
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
