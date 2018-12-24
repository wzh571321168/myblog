package com.wangzhi.pojo.custom;

public class LayerUIPhotosResult<T> {
    /*{
        "title": "", //相册标题
        "id": 123, //相册id
        "start": 0, //初始显示的图片序号，默认0
        "data": [   //相册包含的图片，数组格式
                {
                    "alt": "图片名",
                    "pid": 666, //图片id
                    "src": "", //原图地址
                    "thumb": "" //缩略图地址
                }
            ]
    }*/
    private String title;
    private Integer id;
    private Integer start;
    private T[] data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }
}
