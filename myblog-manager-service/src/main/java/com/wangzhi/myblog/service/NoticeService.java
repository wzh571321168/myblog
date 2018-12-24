package com.wangzhi.myblog.service;

import com.wangzhi.pojo.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> getNoticeList();

    Notice getNoticeById(Integer noticeId);

    void updateNotice(Notice notice);

    void insertNotice(Notice notice);
}
