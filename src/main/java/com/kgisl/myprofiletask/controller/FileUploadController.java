package com.kgisl.myprofiletask.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * A very simple and proof-of-concept only for uploading multiple files in
 * spring/spring boot
 * 
 * @author Kaleb Woldearegay 
 *
 */
@RestController
@RequestMapping(path = "/api/files")
@CrossOrigin(origins = { "*" })
public class FileUploadController {

    /**
     * The path to where the file will be uploaded
     */
    private static String PATH_TO_UPLOAD = "D:\\Learning\\";

    /**
     * Check the file name on the form or curl has to be "file" that is what the
     * method is looking for.
     * 
     * @param files
     * @return
     */
    @PostMapping("/upload")
    public String uploadFilez(@RequestParam("file") MultipartFile[] files) {
        if (files.length == 0) {
            return "Looks like there are no files uploaded";
        }

        try {
            for (MultipartFile file : files) {
                File myfile = new File("D:\\Learning\\" + file.getOriginalFilename());
                file.transferTo(myfile);
                //byte[] bytes = file.getBytes();
                //Path path = Paths.get("D:\\Learning\\" + file.getOriginalFilename());
                //System.out.println(path);
                //Files.write(path, bytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Uploaded fine";
    }

}