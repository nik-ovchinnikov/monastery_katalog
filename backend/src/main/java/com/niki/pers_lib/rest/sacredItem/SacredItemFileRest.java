package com.niki.pers_lib.rest.sacredItem;

import com.niki.pers_lib.services.churchItem.ChurchItemFileService;
import com.niki.pers_lib.services.sacredItem.SacredItemFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/sacredItem-files")
public class SacredItemFileRest {


    @Autowired
    SacredItemFileService service;

    @PostMapping("/addFile")
    public void uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) throws IOException {
        service.fileUpload(file, fileName);
    }

}
