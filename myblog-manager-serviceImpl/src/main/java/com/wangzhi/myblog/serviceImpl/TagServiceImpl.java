package com.wangzhi.myblog.serviceImpl;

import com.wangzhi.blog.mapper.custom.TagCustomMapper;
import com.wangzhi.myblog.service.TagService;
import com.wangzhi.pojo.Tag;
import com.wangzhi.pojo.custom.TagCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagCustomMapper tagCustomMapper;
    @Override
    public List<TagCustom> getTagList(Integer status) {
        return tagCustomMapper.getTagCustomList(status);
    }

    @Override
    public List<TagCustom> getTagCustomList() {
        List<TagCustom> tagCustomList = tagCustomMapper.getTagCustomList(null);
        for(int i=0;i<tagCustomList.size();i++){
            Integer count=tagCustomMapper.getArticleCountById(tagCustomList.get(i).getTagId());
            tagCustomList.get(i).setArticleCount(count);
        }
        return tagCustomList;
    }

    @Override
    public void insertTag(Tag tag) {
        tagCustomMapper.insertTag(tag);

    }
}
