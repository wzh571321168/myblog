package com.wangzhi.myblog.serviceImpl;

import com.wangzhi.blog.mapper.CategoryMapper;
import com.wangzhi.blog.mapper.custom.ArticleCustomMapper;
import com.wangzhi.blog.mapper.custom.CategoryCustomMapper;
import com.wangzhi.myblog.service.CategoryService;
import com.wangzhi.pojo.Category;
import com.wangzhi.pojo.custom.CategoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryCustomMapper categoryCustomMapper;
    @Autowired
    private ArticleCustomMapper articleCustomMapper;
    //添加类目
    @Override
    public void insertSubmit(Category category) {
        categoryMapper.insertCategory(category);
    }
    //获取分类列表
    @Override
    public List<CategoryCustom> getCategoryList(Integer status) {
        List<CategoryCustom> categoryCustomList = categoryCustomMapper.getCategoryCustomList();
        for(CategoryCustom categoryCustom:categoryCustomList){
            Integer categoryId=categoryCustom.getCategoryId();
            Integer count = articleCustomMapper.getArticleByCategoryId(status, categoryId);
            categoryCustom.setArticleCount(count);
        }
        return categoryCustomList;
    }

    @Override
    public CategoryCustom getCategoryCustmById(Integer id) {
        return categoryCustomMapper.getCategoryCustmById(id);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryMapper.deleteCategory(id);
    }
}
