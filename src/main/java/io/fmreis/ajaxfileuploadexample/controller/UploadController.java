package io.fmreis.ajaxfileuploadexample.controller;


import io.fmreis.ajaxfileuploadexample.model.JsonResponse;
import io.fmreis.ajaxfileuploadexample.service.FileProcessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class UploadController {

    @PostMapping("/upload")
    public List<JsonResponse> upload(@RequestParam("our-file")  MultipartFile[] file){

        List<JsonResponse> jsonResponses = new ArrayList<>();

        for(int i = 0; i<file.length; i++){
            System.out.println(file[i].getOriginalFilename() + " " + file[i].getSize());
            jsonResponses.add(FileProcessor.processFile(file[i]));

        }

        return jsonResponses;
    }
}
