package com.wangzhi.pojo.custom;

public class LayEditResult<T> {
      /*"code": 0 //0表示成功，其它失败
              ,"msg": "" //提示信息 //一般上传失败后返回
              ,"data": {
                "src": "图片路径"
                ,"title": "图片名称" //可选*/
      private Integer code;
      private String msg;
      private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
