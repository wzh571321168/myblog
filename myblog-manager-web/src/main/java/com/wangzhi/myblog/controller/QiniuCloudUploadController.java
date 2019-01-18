package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.util.QiniuCloudUtil;
import com.wangzhi.pojo.custom.LayEditResult;
import com.wangzhi.pojo.custom.UploadFileVo;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Controller
public class QiniuCloudUploadController {
    @ResponseBody
    @RequestMapping(value="/uploadFile",produces= MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    public String uploadImg(@Param("file")MultipartFile file) {
        LayEditResult result=new LayEditResult();
        UploadFileVo uploadFileVo=new UploadFileVo();
        if (file.isEmpty()) {
            result.setCode(1);
            result.setMsg("文件为空，请重新上传");
            return new JSONObject(result).toString();
        }

        try {
            byte[] bytes = file.getBytes();
            String imageName = UUID.randomUUID().toString();
            QiniuCloudUtil qiniuUtil = new QiniuCloudUtil();
            try {
                //使用base64方式上传到七牛云
                String url = qiniuUtil.put64image(bytes, imageName);
                result.setCode(0);
                result.setMsg("文件上传成功");
                uploadFileVo.setSrc(url);
                uploadFileVo.setTitle(imageName);
                result.setData(uploadFileVo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new JSONObject(result).toString();
        } catch (IOException e) {
            result.setCode(1);
            result.setMsg("文件上传发生异常！");
            return new JSONObject(result).toString();
        }
    }
}
