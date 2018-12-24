package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.util.FastDFSClient;
import com.wangzhi.pojo.custom.LayEditResult;
import com.wangzhi.pojo.custom.UploadFileVo;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PictureUploadController {
    @Value("${IMG_URL}")
    private String imgUrl;
    @RequestMapping(value="/uploadFile",produces= MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    @ResponseBody
    public String uploadPicture(@Param("file")MultipartFile file){
        if(file != null){
            LayEditResult result=new LayEditResult();
            UploadFileVo uploadFileVo=new UploadFileVo() ;
            try {
                FastDFSClient fdfsClient = new FastDFSClient("classpath:client.conf");
                String originalFilename = file.getOriginalFilename();
                String ext = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
                String url = fdfsClient.uploadFile(file.getBytes(),ext);
                url = imgUrl +url;
                result.setCode(0);
                result.setMsg("上传成功！");
                uploadFileVo.setSrc(url);
                uploadFileVo.setTitle(originalFilename);
                result.setData(uploadFileVo);
                String str=new JSONObject(result).toString();
                return str;
            } catch (Exception e) {
                result.setCode(1);
                return new JSONObject(result).toString();
            }
        }
        return null;
    }
}
