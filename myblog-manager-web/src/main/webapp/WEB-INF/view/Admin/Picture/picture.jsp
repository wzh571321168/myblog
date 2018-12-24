<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<rapid:override name="title">
    - 图片列表
</rapid:override>
<rapid:override name="header-style">
    <style>
        /*覆盖 layui*/
        .layui-input {
            display: inline-block;
            width: 33.333% !important;
        }

        .layui-input-block {
            margin: 0px 10px;
        }


    </style>
</rapid:override>
<rapid:override name="content">
    <blockquote class="layui-elem-quote">
    <span class="layui-breadcrumb" lay-separator="/">
    <a href="/admin">首页</a>
    <a><cite>图片列表</cite></a>
    </span>
    </blockquote>

    <div class="layui-tab layui-tab-card">

        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <form id="articleForm" method="post">
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <input type="text" name="query" placeholder="请输入关键词" autocomplete="off" class="layui-input">
                            <button class="layui-btn" lay-filter="formDemo" id="search" onclick="queryArticle()">搜索</button>
                            <button class="layui-btn" lay-filter="formDemo" style="float: right;"
                                    onclick="confirmDeleteArticleBatch()">批量删除
                            </button>
                        </div>
                    </div>
                    <input type="hidden" name="currentUrl" id="currentUrl" value="">
                    <table class="layui-table">
                        <colgroup>
                            <col width="50">
                            <col width="50">
                            <col width="100">
                            <col width="150">
                            <col width="300">
                            <col width="150">
                            <col width="350">
                            <col width="100">
                        </colgroup>

                        <thead>
                        <tr>
                            <th><input type="checkbox" id="allSelect" onclick="javascript:DoCheck()"></th>
                            <th>id</th>
                            <th>标题</th>
                            <th>所属分类</th>
                            <th>描述</th>
                            <td>上传时间</td>
                            <th>图片</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pictureCustomVoList}" var="a">
                            <c:if test="${a.pictureCustom.picStatus==1}">
                                <tr style="vertical-align:middle; text-align:center;">
                                    <td><input type="checkbox" name="ids" value="${a.pictureCustom.picId}"></td>
                                    <td>${a.pictureCustom.picId}</td>
                                    <td>${a.pictureCustom.picName}</td>
                                    <td>
                                        <a class="openimg" href='javascript:;' onclick='showImages("${a.pictureCustom.picCategoryId}")' lay-event="img">${a.pictureCustom.picCategoryName}</a>
                                    </td>

                                    <td>${a.pictureCustom.picDescription}</td>
                                    <td>
                                        <fmt:formatDate value="${a.pictureCustom.picUploadTime}"
                                                        pattern="YY年MM月dd日"/>
                                    </td>
                                    <td><img src="${a.pictureCustom.picUrl}"></td>
                                    <td>

                                        <a href="javascript:void(0)"
                                           onclick="deletePicture(${a.pictureCustom.picId})"
                                           class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>

                        </tbody>

                    </table>
                    <div class="layui-card-footer" style="text-align: center">
                        <div id="pagination"></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</rapid:override>
<rapid:override name="footer-script">
    <script>
        function showImages(picCategoryId){
            $.ajax({
                cache:false,
                type:'POST',
                dataType:"json",
                url:'/admin/picture/showPic',
                data:{"picCategoryId":picCategoryId},
                error: function () {
                    alert('请求失败');
                },
                success:function(res){
                    layer.photos({
                        photos: res
                        ,anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
                    });
                }
            });
        }





        $(function () {


            var laypage = layui.laypage
            //完整功能
            laypage.render({
                elem: 'pagination'
                , count: ${pictureCustomVoList.get(0).pageInfo.total} //数据总数，从服务端得到
                , limit: ${pictureCustomVoList.get(0).pageInfo.pageSize}
                , curr: ${pictureCustomVoList.get(0).pageInfo.pageNum}
                , layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
                , jump: function (obj, first) {
                    //obj包含了当前分页的所有参数，比如：
                    console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                    console.log(obj.limit); //得到每页显示的条数

                    //首次不执行
                    if (!first) {
                        //do something
                        var title = $('#search').val()
                        var href = '/admin/picture/page?title=' + title;
                        href += '&pageNum=' + obj.curr;
                        href += '&pageSize=' + obj.limit;
                        location.href = href;
                    }

                }
            });
        })

        //删除文章
        function deletePicture(id) {
            if(confirmDelete()==true){
                $.ajax({
                    async: false,
                    type: "POST",
                    url:'/admin/picture/delete/'+id,
                    contentType : "application/x-www-form-urlencoded; charset=utf-8",
                    dataType: "text",
                    complete:function () {
                        window.location.reload();
                    }
                })
            }
        }

    </script>
</rapid:override>
<%@ include file="../Public/framework.jsp" %>