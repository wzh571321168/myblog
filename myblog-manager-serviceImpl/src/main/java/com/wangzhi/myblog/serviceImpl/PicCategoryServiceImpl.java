package com.wangzhi.myblog.serviceImpl;

import com.wangzhi.blog.mapper.PicCategoryMapper;
import com.wangzhi.blog.mapper.custom.PicCategoryCustomMapper;
import com.wangzhi.myblog.service.PicCategoryService;
import com.wangzhi.pojo.PicCategoy;
import com.wangzhi.pojo.custom.PicCategoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PicCategoryServiceImpl implements PicCategoryService {
    @Autowired
    private PicCategoryCustomMapper picCategoryCustomMapper;
    @Autowired
    private PicCategoryMapper picCategoryMapper;
    @Override
    public List<PicCategoy> getPicCategoryList() {
        return picCategoryMapper.getPicCategoryList();
    }

    @Override
    public PicCategoy getPicCategoryById(Integer picCategoryId) {
        return picCategoryMapper.getPicCategoryById(picCategoryId);
    }

    @Override
    public void addPicCategory(PicCategoy picCategoy) {
        picCategoryMapper.addPicCategory(picCategoy);
    }

    @Override
    public List<PicCategoryCustom> getPicCategoryCustomList() {
        return picCategoryCustomMapper.getPicCategoryCustomList();
    }

    @Override
    public void deleteCategoryById(Integer id) {
        picCategoryMapper.deleteCategoryById(id);
    }
}
