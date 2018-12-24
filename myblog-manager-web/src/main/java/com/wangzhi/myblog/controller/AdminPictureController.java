package com.wangzhi.myblog.controller;

import com.wangzhi.myblog.service.PicCategoryService;
import com.wangzhi.myblog.service.PictureService;
import com.wangzhi.pojo.PicCategoy;
import com.wangzhi.pojo.Picture;
import com.wangzhi.pojo.custom.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/picture")
public class AdminPictureController {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private PicCategoryService picCategoryService;
    @RequestMapping("/insert")
    public ModelAndView insertPicturePage(){
        ModelAndView mv=new ModelAndView();
        List<PicCategoy> picCategoyList= picCategoryService.getPicCategoryList();
        mv.addObject("picCategoyList",picCategoyList);
        mv.setViewName("/Admin/Picture/insert");
        return mv;
    }
    @RequestMapping("/savePic")
    @ResponseBody
    public String savePicture(HttpServletRequest request){
        Picture picture=new Picture();
        picture.setPicName(request.getParameter("picName"));
        picture.setPicDescription(request.getParameter("picDescription"));
        picture.setPicCategoryId(Integer.valueOf(request.getParameter("picCategoryId")));
        picture.setPicStatus(1);
        picture.setPicUploadTime(new Date());
        String imgUrls=request.getParameter("picUrls");
        String[] urls = imgUrls.split(",");
        try{
            for(int i=0;i<urls.length;i++){
                picture.setPicUrl(urls[i]);
                pictureService.insertPicture(picture);
            }
            String msg="1";
            return msg;
        }catch (Exception e){
            String msg="0";
            return msg;
        }
    }
    @RequestMapping("")
    public ModelAndView indexPicture(){
        ModelAndView mv=new ModelAndView();
        Integer    pageSize=10;
        List<PictureCustomVo> pictureCustomVoList = pictureService.getPictureCustomList(1, 1, pageSize);
        mv.addObject("pictureCustomVoList",pictureCustomVoList);
        mv.setViewName("/Admin/Picture/picture");
        return mv;
    }
    @RequestMapping("/page")
    public ModelAndView picturePage(@RequestParam(required = false)String title,@RequestParam(required = false)Integer pageNum,@RequestParam(required = false)Integer pageSize){
        ModelAndView mv=new ModelAndView();
        if(pageNum==null){
            pageNum=1;
        }
        if (pageSize==null){
            pageSize=10;
        }
        List<PictureCustomVo> pictureCustomVoList = pictureService.getPictureCustomList(1, pageNum, pageSize);
        mv.addObject("pictureCustomVoList",pictureCustomVoList);
        mv.setViewName("/Admin/Picture/picture");
        return mv;
    }

    @RequestMapping("/showPic")
    @ResponseBody
    public LayerUIPhotosResult showImages(Integer picCategoryId){
        LayerUIPhotosResult<PictureData> layerUIPhotosResult=new LayerUIPhotosResult<>();
        PicCategoy picCategoy=picCategoryService.getPicCategoryById(picCategoryId);
        layerUIPhotosResult.setId(picCategoryId);
        layerUIPhotosResult.setStart(0);
        layerUIPhotosResult.setTitle(picCategoy.getPicCategoryName());
        List<PictureCustom> pictureCustomList=pictureService.getPictureCustomListByCategoryId(1,picCategoryId);
        PictureData[] pictureData=new PictureData[pictureCustomList.size()];
        for(int i=0;i<pictureCustomList.size();i++){
            PictureData pictureData1=new PictureData();
            pictureData1.setAlt(pictureCustomList.get(i).getPicName());
            pictureData1.setPid(pictureCustomList.get(i).getPicId());
            pictureData1.setSrc(pictureCustomList.get(i).getPicUrl());
            pictureData1.setThumb(pictureCustomList.get(i).getPicUrl());
            pictureData[i]=pictureData1;
        }
        layerUIPhotosResult.setData(pictureData);
        return layerUIPhotosResult;
    }
    @RequestMapping("picCategory")
    public ModelAndView picCategory(){
        ModelAndView mv=new ModelAndView();
        List<PicCategoryCustom> picCategoryCustomList=picCategoryService.getPicCategoryCustomList();
        mv.addObject("picCategoryCustomList",picCategoryCustomList);
        mv.setViewName("/Admin/Picture/picCategory");
        return mv;
    }
    @RequestMapping(value = "addPicCategory",method = RequestMethod.POST)
    public String addPicCategory(PicCategoy picCategoy){
        picCategoy.setPicCategoryStatus(1);
        picCategoryService.addPicCategory(picCategoy);
        return "redirect:/admin/picture/picCategory";
    }
    @RequestMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id")Integer id){
        picCategoryService.deleteCategoryById(id);
        return "redirect:/admin/picture/picCategory";
    }
}
