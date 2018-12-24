package com.wangzhi.myblog.serviceImpl;

import com.wangzhi.blog.mapper.NoticeMapper;
import com.wangzhi.myblog.service.NoticeService;
import com.wangzhi.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<Notice> getNoticeList() {
        return noticeMapper.getNoticeList();
    }

    @Override
    public Notice getNoticeById(Integer noticeId) {
        return noticeMapper.getNoticeById(noticeId);
    }

    @Override
    public void updateNotice(Notice notice) {
        noticeMapper.updateNotice(notice);
    }

    @Override
    public void insertNotice(Notice notice) {
        noticeMapper.insertNotice(notice);
    }
}
