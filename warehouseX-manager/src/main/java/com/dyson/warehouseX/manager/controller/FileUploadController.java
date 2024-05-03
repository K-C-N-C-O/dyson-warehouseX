package com.dyson.warehouseX.manager.controller;


import com.dyson.model.vo.common.Result;
import com.dyson.model.vo.common.ResultCodeEnum;
import com.dyson.warehouseX.manager.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/admin/system")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping(value = "/fileUpload")
    public Result<String> fileUploadService(@RequestParam(value = "file") MultipartFile file) {
        String url = fileUploadService.upload(file) ;
        return Result.build(url , ResultCodeEnum.SUCCESS) ;
    }


}
