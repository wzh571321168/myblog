<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="title">
    - 图片分类
</rapid:override>
<rapid:override name="header-style">
    <style>
        /*覆盖 layui*/
        .layui-input-block {
            margin:0px 10px;
        }
        .layui-table {
            margin-top: 0;
        }
        .layui-col-md4 {
            padding:10px;
        }
        .layui-col-md8 {
            padding:10px;
        }
        .layui-btn {
            margin: 2px 0!important;
        }
    </style>
</rapid:override>

<rapid:override name="content">

    <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="/admin">首页</a>
              <a><cite>分类列表</cite></a>
        </span>
    </blockquote>
    <div class="layui-row">
        <div class="layui-col-md4">
            <form class="layui-form"  method="post" id="myForm" action="/admin/picture/addPicCategory">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>添加分类</strong>
                    </div>
                    <div class="layui-input-block">
                        名称 <span style="color: #FF5722; ">*</span>
                        <input type="text" name="picCategoryName" placeholder="请输入图片分类名称" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        分类描述
                        <input type="text" name="picCategoryDescription" placeholder="请输入图片分类描述" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        图标样式
                        <input type="text" name="picCategoryIcon" placeholder="请输入图标样式,如 fa fa-coffee" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-filter="formDemo" type="submit">添加</button>
                    </div>
                </div>
            </form>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>1、分类名必选，建议不要太长</li>
                    <li>2、分类名勿重复</li>
                </ul>
            </blockquote>
        </div>
        <div class="layui-col-md8" style="border: 1px solid #FF5722;">

            <table class="layui-table" >
                <colgroup>
                    <col width="50">
                    <col width="200">
                    <col width="100">
                    <col width="50">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>名称</th>
                    <th>图片数</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${picCategoryCustomList}" var="c">

                    <tr>
                        <td >${c.picCategoryId}</td>
                        <td>
                            <a href="" target="_blank">${c.picCategoryName}</a>
                        </td>
                        <td >
                            <a href="" target="_blank"  lay-data="{sort:true}">${c.picCount}</a>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${c.picCategoryStatus==1}">
                                    显示
                                </c:when>
                                <c:otherwise>
                                    隐藏
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a href="" class="layui-btn layui-btn-mini">编辑</a>
                            <c:if test="${c.picCount==0 or c.picCount==null}">
                                <a href="/admin/picture/delete/${c.picCategoryId}" class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>
                            </c:if>

                        </td>

                    </tr>

                </c:forEach>
                </tbody>
            </table>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>如果该标签包含图片，将不可删除</li>
                </ul>
            </blockquote>
        </div>
    </div>



</rapid:override>
<rapid:override name="footer-script">
    <script>

    </script>
</rapid:override>

<%@ include file="../Public/framework.jsp"%>