package com.anyang.demo.controller;

import com.anyang.demo.domain.base.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("upload")
public class FileUploadController {

    @RequestMapping("files")
    @ResponseBody
    public Result<?> uploadImg(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();
        while(fileNames.hasNext()) {
            String fileName = fileNames.next();
            List<MultipartFile> files = request.getFiles(fileName);
            if(files != null && files.size() > 0) {
                for(MultipartFile file : files) {
                    System.out.println(file.getOriginalFilename() + ": " + file.getSize());
                }
            }
        }

        Enumeration<String> paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            System.out.println(paramName + ": " + request.getParameter(paramName));
        }

        return Result.wrapSuccess(null);
    }


    /**
     *
     * @param kenan
     * @param myImg
     * @return
     */
    @RequestMapping("imgs")
    @ResponseBody
    public Result<?> uploadImg(@RequestPart("kenan") MultipartFile kenan,   // 使用 @RequestPart 或者 @RequestParam 都是可以的
                               @RequestPart("myImg") MultipartFile myImg) {


        System.out.println(kenan.getName() + ": " + kenan.getSize());
        System.out.println(myImg.getName() + ": " + myImg.getSize());

        return Result.wrapSuccess(null);
    }
}
