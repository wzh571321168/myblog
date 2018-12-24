<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<rapid:override name="title">
    - 添加图片
</rapid:override>

<rapid:override name="content">
    <blockquote class="layui-elem-quote">
    <span class="layui-breadcrumb" lay-separator="/">
    <a href="/admin">首页</a>
    <a><cite>添加图片</cite></a>
    </span>
    </blockquote>


    <!-- 内容主体区域  表单内容 -->
    <form class="layui-form goodsAddForm" action="" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">图片名称</label>
                <div class="layui-input-block">
                    <input type="text" name="title" id="title" required lay-verify="required" placeholder="请输入图片名称" autocomplete="off" class="layui-input">
                </div>
            </div>
            
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">图片描述</label>
                <div class="layui-input-block">
                    <textarea name="smallTit" id="smallTit" placeholder="图片描述：" class="layui-textarea"></textarea>
                </div>
            </div>

        <div class="layui-form-item">
            <label class="layui-form-label">所属分类 <span style="color: #FF5722; ">*</span> </label>
            <div class="layui-input-inline">
                <select name="pictureCategoryId" id="pictureCategoryId" lay-filter="pictureCategoryId" required>
                    <c:forEach items="${picCategoyList}" var="c">
                        <option value="${c.picCategoryId}">${c.picCategoryName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

            <div class="layui-form-item">
                <label class="layui-form-label">图片上传</label>
                <div class="layui-input-block">
                    <button type="button" class="layui-btn" id="test1">
                        <i class="layui-icon">&#xe67c;</i>选择图片（最多选择20张，单张图片最大为10M）
                    </button>
                    <button type="button" class="layui-btn" id="test9">开始上传</button>
                    <button type="button" class="layui-btn" id="cleanImgs" onclick="cleanImgsPreview()"> <i class="fa fa-trash-o fa-lg"></i>清空图片预览</button>
                </div>
                <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
                    预览图：
                    <div class="layui-upload-list" id="demo2"></div>
                </blockquote>
            </div>
            
            <input type="text" id="imgUrls" name="imgUrls" style="display: none;" class="layui-input">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" type="button" style="width: 800px;" id="btnSubmit" onclick="picSave()">添加图片</button>
                </div>
            </div>
    </form>



</rapid:override>
<rapid:override name="footer-script">
    <script>
        /**
         * 图片上传数量及其大小等控制
         * 点击开始上传按钮(test9)，执行上传
         *
         */
        var success=0;
        var fail=0;
        var imgurls="";

        $(function (){
            var imgsName="";
            layui.use(['upload','layer'],function() {
                var upload = layui.upload;
                var layer=layui.layer;

                upload.render({
                    elem: '#test1',
                    url: '/uploadFile',
                    multiple: true,
                    auto:false,
//			上传的单个图片大小
                    size:10240,
//			最多上传的数量
                    number:20,
//			MultipartFile file 对应，layui默认就是file,要改动则相应改动
                    field:'file',
                    bindAction: '#test9',
                    before: function(obj) {
                        //预读本地文件示例，不支持ie8
                        obj.preview(function(index, file, result) {
                            $('#demo2').append('<img src="' + result
                                + '" alt="' + file.name
                                +'"height="92px" width="92px" class="layui-upload-img uploadImgPreView">')
                        });
                    },
                    done: function(res) {
                        //每个图片上传结束的回调，成功的话，就把新图片的名字保存起来，作为数据提交
                        console.log(res.code);
                        if(res.code=="1"){
                            fail++;
                        }else{
                            success++;
                            imgurls=imgurls+""+res.data.src+",";
                            $('#imgUrls').val(imgurls);
                        }
                    },
                    allDone:function(obj){
                        layer.msg("总共要上传图片总数为："+(fail+success)+"\n"
                            +"其中上传成功图片数为："+success+"\n"
                            +"其中上传失败图片数为："+fail
                        )
                    }
                });

            });


        });

        /**
         * 清空预览的图片及其对应的成功失败数
         * 原因：如果已经存在预览的图片的话，再次点击上选择图片时，预览图片会不断累加
         * 表面上做上传成功的个数清0，实际后台已经上传成功保存了的，只是没有使用，以最终商品添加的提交的为准
          */
        function cleanImgsPreview(){

                success=0;
                fail=0;
                $('#demo2').html("");
                $('#imgUrls').val("");
                imgurls="";
        }

        /**
         * 保存图片
         */
        function picSave(){
            var tt=$("#title").val();
            var st=$("#smallTit").val();
            var pci=$("#pictureCategoryId").val();
            var ius=$("#imgUrls").val();

            $.ajax({
                type: "POST",
                url: "/admin/picture/savePic",
                data: {
                    picName:tt,
                    picDescription:st,
                    picUrls:ius,
                    picCategoryId:pci,
                },
                success: function(msg){
                    if(msg=="1"){
                        alert("保存成功");
                    }else{
                        alert("保存失败");
                    }
                }
            });
        }


    </script>
</rapid:override>
<%@ include file="../Public/framework.jsp" %>
