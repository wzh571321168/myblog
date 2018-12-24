package com.wangzhi.blog.mapper;

import com.wangzhi.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    List<Menu> getMenuList(@Param("status") Integer status);
}
