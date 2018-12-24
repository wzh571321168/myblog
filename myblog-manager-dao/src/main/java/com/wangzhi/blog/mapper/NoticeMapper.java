package com.wangzhi.blog.mapper;

import com.wangzhi.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {
    List<Notice> getNoticeList();

    Notice getNoticeById(@Param("noticeId") Integer noticeId);

    void updateNotice(Notice notice);

    void insertNotice(Notice notice);
}
