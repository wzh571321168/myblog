package com.wangzhi.myblog.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangzhi.blog.mapper.PicCategoryMapper;
import com.wangzhi.blog.mapper.PictureMapper;

import com.wangzhi.blog.mapper.custom.PictureCustomMapper;
import com.wangzhi.myblog.service.PictureService;
import com.wangzhi.pojo.PicCategoy;
import com.wangzhi.pojo.Picture;
import com.wangzhi.pojo.custom.PictureCustom;
import com.wangzhi.pojo.custom.PictureCustomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PicCategoryMapper picCategoryMapper;
    @Autowired
    private PictureMapper pictureMapper;
    @Autowired
    private PictureCustomMapper pictureCustomMapper;
    @Override
    public void insertPicture(Picture picture) {
        pictureMapper.insertPicture(picture);
    }

    @Override
    public List<PictureCustomVo> getPictureCustomList(Integer status, Integer pageNow, Integer pageSize) {
        PageHelper.startPage(pageNow,pageSize);
        List<PictureCustom> pictureCustomList = pictureCustomMapper.getPictureCustomList(status);
        List<PictureCustomVo> pictureCustomVoList=new ArrayList<>();
        PageInfo<PictureCustom> pageInfo = new PageInfo<>(pictureCustomList);
        for(int i=0;i<pictureCustomList.size();i++){
            PicCategoy picCategoy=picCategoryMapper.getPicCategoryById(pictureCustomList.get(i).getPicCategoryId());
            if(picCategoy!=null) {
                pictureCustomList.get(i).setPicCategoryName(picCategoy.getPicCategoryName());
            }
            PictureCustomVo pictureCustomVo=new PictureCustomVo();
            pictureCustomVo.setPageInfo(pageInfo);
            pictureCustomVo.setPictureCustom(pictureCustomList.get(i));
            pictureCustomVoList.add(pictureCustomVo);
        }
        return pictureCustomVoList;
    }

    @Override
    public List<PictureCustom> getPictureCustomListByCategoryId(Integer status,Integer picCategoryId) {
        return pictureCustomMapper.getPictureCustomListByCategoryId(status,picCategoryId);
    }

    @Override
    public List<Picture> getPictureList() {
        return pictureMapper.getNewPictureList();
    }

    @Override
    public void deletePicById(Integer id) {
        pictureMapper.deletePicById(id);
    }
}
