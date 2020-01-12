package io.fmreis.ajaxfileuploadexample.service;

import io.fmreis.ajaxfileuploadexample.model.JsonResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public class FileProcessor {

    public static JsonResponse processFile(MultipartFile file) {
        JsonResponse jsonResponse;
        System.out.println(file.getOriginalFilename() + " " + file.getSize());
        String result = "Failed";
        try {
            String fileContents = new String(file.getBytes());
            result = fileContents.substring(0, 10).equals("AAAAAAAAAA") ? "Success" : "Failed";

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JsonResponse(file.getOriginalFilename(), result);
    }
}
