<%@ page import="java.security.MessageDigest" %>
<%@ page import="java.security.NoSuchAlgorithmException" %>
<%@ page import="com.wangzhi.myblog.util.Functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="title">
    - 评论列表
</rapid:override>
<rapid:override name="header-style">
    <style>
        /*覆盖 layui*/
        .layui-table {
            margin-top: 0;
        }

    </style>
</rapid:override>

<rapid:override name="content">
    <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="/admin">首页</a>
              <a><cite>评论列表</cite></a>
        </span>
    </blockquote>
    <div class="layui-tab layui-tab-card">
        <ul class="layui-tab-title">
            <li class="layui-this">全部评论(${commentListVoList.size()})</li>
            <li>待审评论(${hiddenCommentListVoList.size()})</li>
        </ul>
        <div class="layui-tab-content" >
            <div class="layui-tab-item layui-show" style="margin-bottom: -10px">
                <table class="layui-table" lay-even lay-skin="nob">
                    <colgroup>
                        <col width="100">
                        <col width="300">
                        <col width=200">
                        <col width="150">
                        <col width="50">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>作者</th>
                        <th>评论内容</th>
                        <th>回复至</th>
                        <th>提交于</th>
                        <th>ID</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${commentListVoList}" var="c">
                        <tr>
                            <td>
                                <img src="${c.commentCustom.commentAuthorAvatar}" alt="" width="64px">
                                <strong>${c.commentCustom.commentAuthorName}</strong>
                                <c:if test="${c.commentCustom.commentStatus==0}">
                                    <span class="approve">[待审]</span>
                                </c:if>
                                <br>
                                    ${c.commentCustom.commentAuthorUrl} <br>
                                    ${c.commentCustom.commentAuthorEmail} <br>
                                    ${c.commentCustom.commentIp}
                            </td>
                            <td class="dashboard-comment-wrap">
                                <c:if test="${c.commentCustom.commentPid!=0}">
                                    <span class="at">@ </span><a href="${c.commentCustom.commentAuthorUrl}">${c.commentCustom.commentPname}</a>
                                </c:if>
                                    ${c.commentCustom.commentContent}
                                <div class="row-actions">
                                     <span class="">
                                           <c:choose>
                                               <c:when test="${c.commentCustom.commentStatus==0}">
                                                   <a href="javascript:void(0)" style="color:#5FB878;!important;" onclick="approveComment(${c.commentCustom.commentId})">批准</a>
                                               </c:when>
                                               <c:otherwise>
                                                   <a href="javascript:void(0)" style="color:#FF5722;!important;" onclick="hideComment(${c.commentCustom.commentId})">屏蔽</a>
                                               </c:otherwise>
                                           </c:choose>
                                     </span> |
                                     <span class="">
                                        <a href="/admin/comment/reply/${c.commentCustom.commentId}">
                                            回复
                                        </a>
                                     </span>
                                     <span class=""> |
                                        <a href="/admin/comment/edit/${c.commentCustom.commentId}">编辑</a>
                                     </span>
                                     <span class=""> |
                                        <a href="javascript:void(0)" onclick="deleteComment(${c.commentCustom.commentId})">删除</a>
                                     </span>
                                </div>
                            </td>
                            <td>
                                <a href="/article/${c.articleCustom.articleId}"
                                   target="_blank">${c.articleCustom.articleTitle}</a>
                            </td>
                            <td>
                                <fmt:formatDate value="${c.commentCustom.commentCreateTime}" pattern="yyyy年MM月dd日 HH:dd:ss"/>
                            </td>
                            <td>
                                    ${c.commentCustom.commentId}
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>

                </table>

                <div id="nav" style="">

                </div>
            </div>
            <div class="layui-tab-item">
                <table class="layui-table" lay-even lay-skin="nob">
                    <colgroup>
                        <col width="100">
                        <col width="300">
                        <col width=200">
                        <col width="150">
                        <col width="50">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>作者</th>
                        <th>评论内容</th>
                        <th>回复至</th>
                        <th>提交于</th>
                        <th>ID</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${hiddenCommentListVoList}" var="c">
                        <tr>
                            <td>
                                <img src="${c.commentCustom.commentAuthorAvatar}" alt="" width="64px">
                                <strong>${c.commentCustom.commentAuthorName}</strong> <br>
                                    ${c.commentCustom.commentAuthorUrl} <br>
                                    ${c.commentCustom.commentAuthorEmail} <br>
                                    ${c.commentCustom.commentIp}
                            </td>
                            <td class="dashboard-comment-wrap">
                                <c:if test="${c.commentCustom.commentPid!=0}">
                                     <a href="${c.commentCustom.commentAuthorUrl}">@ ${c.commentCustom.commentPname}</a></span>
                                </c:if>
                                    ${c.commentCustom.commentContent}
                                <div class="row-actions">
                                    <span class="">
                                        <c:choose>
                                            <c:when test="${c.commentCustom.commentStatus==0}">
                                                <a href="javascript:void(0)" style="color:#5FB878;!important;" onclick="approveComment(${c.commentCustom.commentId})">批准</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="javascript:void(0)" style="color:#FF5722;!important;" onclick="hideComment(${c.commentCustom.commentId})">屏蔽</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </span>
                                    <span class=""> |
                                        <a href="/admin/comment/reply/${c.commentCustom.commentId}">回复</a>
                                    </span>
                                    <span class=""> |
                                         <a href="/admin/comment/edit/${c.commentCustom.commentId}">编辑</a>
                                    </span>
                                    <span class=""> |
                                        <a href="javascript:void(0)" onclick="deleteComment(${c.commentCustom.commentId})">删除</a>
                                    </span>
                                </div>
                            </td>
                            <td>
                                <a href="/article/${c.articleCustom.articleId}"
                                   target="_blank">${c.articleCustom.articleTitle}</a>
                            </td>
                            <td>
                                <fmt:formatDate value="${c.commentCustom.commentCreateTime}" pattern="yyyy年MM月dd日 HH:dd:ss"/>
                            </td>
                            <td>
                                    ${c.commentCustom.commentId}
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


</rapid:override>
<rapid:override name="footer-script">
    <script>

    </script>
</rapid:override>

<%@ include file="../Public/framework.jsp" %>
