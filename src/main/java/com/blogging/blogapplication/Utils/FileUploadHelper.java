package com.blogging.blogapplication.Utils;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "C:\\Users\\Gaurav\\Desktop\\CS WORK\\Spring-Boot Blogging Website Backend\\blog-application\\src\\main\\resources\\static";

    public Boolean uploadFile(MultipartFile file) {
        Boolean uploaded = false;
        try {

            InputStream is = file.getInputStream();
            byte data[] = new byte[is.available()];
            is.read(data);

            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + "\\" + file.getOriginalFilename());
            fos.write(data);
            fos.flush();
            fos.close();
            uploaded = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return uploaded;
    }
}
