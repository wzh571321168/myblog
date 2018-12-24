<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<script  src="/js/echarts.js" type="text/javascript"></script>
<rapid:override name="header-style">
    <style>
        .layui-input-block {
             margin-left: 0!important;;
        }

        .layui-col-md6 {
            padding: 10px;
        }

        .postbox {
            min-width: 255px;
            border: 1px solid #e5e5e5;
            /* -webkit-box-shadow: 0 1px 1px rgba(0,0,0,.04); */
            box-shadow: 0 1px 1px rgba(0,0,0,.04);
            background: #fff;
        }


        .postbox, .stuffbox {
            margin-bottom: 20px;
            padding: 0;
            line-height: 1;
        }

        .js .postbox .handlediv {
            display: block;
        }
        .wp-core-ui .button-link {
            margin: 0;
            padding: 0;
            /* -webkit-box-shadow: none; */
            box-shadow: none;
            border: 0;
            /* -webkit-border-radius: 0; */
            border-radius: 0;
            background: 0 0;
            outline: 0;
            cursor: pointer;
        }

        .postbox .handlediv {
            display: none;
            float: right;
            width: 36px;
            height: 36px;
            padding: 0;
        }

        .screen-reader-text span {
            position: absolute;
            margin: -1px;
            padding: 0;
            height: 1px;
            width: 1px;
            overflow: hidden;
            clip: rect(0 0 0 0);
            border: 0;
            word-wrap: normal!important;
        }
        .screen-reader-text span {
            position: absolute;
            margin: -1px;
            padding: 0;
            height: 1px;
            width: 1px;
            overflow: hidden;
            clip: rect(0 0 0 0);
            border: 0;
            word-wrap: normal!important;
        }

        .metabox-holder .postbox>h3, .metabox-holder .stuffbox>h3, .metabox-holder h2.hndle, .metabox-holder h3.hndle {
            font-size: 14px;
            padding: 8px 12px;
            margin: 0;
            line-height: 1.4;
        }
        #dashboard_quick_press form {
            margin: 12px;
        }
        form {
            display: block;
            margin-top: 0em;
        }
        .postbox .inside, .stuffbox .inside {
            padding: 0 12px 12px;
            line-height: 1.4em;
            font-size: 13px;
        }
        .postbox, .stuffbox {
            margin-bottom: 20px;
            padding: 0;
            line-height: 1;
        }
        Inherited from div#wpwrap

        a, div {
            outline: 0;
        }
        user agent stylesheet
        div {
            display: block;
        }
        Inherited from div.inside
        .postbox .inside, .stuffbox .inside {
            padding: 0 12px 12px;
            line-height: 1.4em;
            font-size: 13px;
        }

        #dashboard_quick_press .drafts li time {
            color: #72777c;
        }
        #description-wrap label, #title-wrap label {
            cursor: text;
        }


        #dashboard-widgets form .input-text-wrap input, #dashboard-widgets form .textarea-wrap textarea {
            width: 100%;
        }

        #dashboard_quick_press input, #dashboard_quick_press textarea {
            /* -webkit-box-sizing: border-box; */
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            margin: 0;
        }

        a, div {
            outline: 0;
        }

        #description-wrap label, #title-wrap label {
            cursor: text;
        }

        #dashboard-widgets form .input-text-wrap input, #dashboard-widgets form .textarea-wrap textarea {
            width: 100%;
        }


        .meta-box-sortables select {
            max-width: 100%;
        }
        .js #dashboard_quick_press .drafts {
            border-top: 1px solid #eee;
        }
        #dashboard_quick_press .drafts {
            padding: 10px 0 0;
        }
        #dashboard_quick_press .drafts .view-all {
            float: right;
            margin: 0 12px 0 0;
        }
        #dashboard_quick_press .drafts p {
            margin: 0;
            word-wrap: break-word;
        }
        #dashboard_quick_press .drafts h2 {
            line-height: inherit;
        }

        #dashboard-widgets h3, #dashboard-widgets h4, #dashboard_quick_press .drafts h2 {
            margin: 0 12px 8px;
            padding: 0;
            font-size: 14px;
            font-weight: 400;
            color: #23282d;
        }
        #dashboard_quick_press .drafts ul {
            margin: 0 12px;
        }
        ul {
            list-style: none;
        }
        ol, ul {
            padding: 0;
        }
        #dashboard_quick_press .drafts li {
            margin-bottom: 1em;
        }
        dd, li {
            /* margin-bottom: 6px; */
        }

        user agent stylesheet
        li {
            display: list-item;
            text-align: -webkit-match-parent;
        }
        #dashboard_quick_press .draft-title,.dashboard-comment-wrap {
            word-wrap: break-word;
        }
        a, div {
            outline: 0;
        }
        user agent stylesheet
        div {
            display: block;
        }
        #dashboard_quick_press .drafts p {
            /* margin: 0; */
            word-wrap: break-word;
        }
        p {
            font-size: 13px;
            line-height: 1.5;
        }
        h2, h3, p {
            margin: 1em 0;
        }
    </style>
</rapid:override>

<rapid:override name="content">


    <div class="layui-row">

        <div class="layui-col-md6">
            <div id="dashboard_activity" class="postbox ">
                <div class="inside">
                    <div id="activity-widget">
                        <div id="published-posts" class="activity-block"><h3>最近发布</h3> <br>
                            <ul>
                                <c:forEach items="${articleCustomList}" begin="0" end="4" step="1" var="a">
                                    <li><span><fmt:formatDate value="${a.articleCustom.articlePostTime}"
                                                              pattern="HH:mm MM月dd日"/> </span>
                                        <a href="/article/${a.articleCustom.articleId}"
                                           target="_blank">${a.articleCustom.articleTitle}</a>
                                    </li>
                                </c:forEach>

                            </ul>
                        </div>
                        <br>
                        <div id="latest-comments" class="activity-block"><h3>近期评论</h3>
                            <ul id="the-comment-list" data-wp-lists="list:comment">
                                <c:forEach items="${commentListVoList}" begin="0" end="4" step="1" var="c">
                                    <li class="comment   thread-even comment-item approved">

                                        <img alt="" src="${c.commentCustom.commentAuthorAvatar}"
                                             class="avatar avatar-50 photo" height="50" width="50">
                                        <div class="dashboard-comment-wrap has-row-actions">
                                            <p class="comment-meta">
                                                由<cite class="comment-author">
                                                <a target="_blank" href="${c.commentCustom.commentAuthorUrl}"
                                                   rel="external nofollow"
                                                   class="url">${c.commentCustom.commentAuthorName}</a>
                                            </cite>发表在《<a
                                                    href="/article/${c.commentCustom.commentArticleId}">${c.articleCustom.articleTitle}</a>》
                                                <c:if test="${c.commentCustom.commentStatus==0}">
                                                    <span class="approve">[待审]</span>
                                                </c:if>
                                            </p>

                                            <blockquote><p>${c.commentCustom.commentContent}</p></blockquote>
                                            <p class="row-actions">
                                            <span class="">
                                            <c:choose>
                                                <c:when test="${c.commentCustom.commentStatus==1}">
                                                    <a href="javascript:void(0)" style="color: #FF5722;"
                                                       onclick="hideComment(${c.commentCustom.commentId})">屏蔽</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="" style="color: #009688;"
                                                       onclick="approveComment(${c.commentCustom.commentId})">批准</a>
                                                </c:otherwise>
                                            </c:choose>
                                            </span> |
                                                <span class="">
                                            <a data-comment-id="1268"
                                               href="/admin/comment/reply/${c.commentCustom.commentId}">
                                                回复
                                            </a>
                                            </span>
                                                <span class=""> |
                                                <a href="/admin/comment/edit/${c.commentCustom.commentId}">编辑</a>
                                            </span>
                                                <span class=""> |
                                                <a href="javascript:void(0)"
                                                   onclick="deleteComment(${c.commentCustom.commentId})">删除</a>
                                            </span>
                                            </p>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                            <ul class="subsubsub">
                                <li class="all"><a
                                        href="">全部<span
                                        class="count">（<span class="all-count">${allCommentCount}</span>）</span></a> |
                                </li>
                                <li class="moderated"><a
                                        href="">待审<span
                                        class="count">（<span class="pending-count">${hiddenCommentCount}</span>）</span></a>
                                    |
                                </li>
                                <li class="approved"><a
                                        href="">已批准<span
                                        class="count">（<span
                                        class="approved-count">${approvedCommentCount}</span>）</span></a> |
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-col-md6">
            <div class="layui-container" style="width: 600px;height:400px;">
                <div id="main" style="height: 100%"></div>

                <div id="container" style="height: 100%"></div>
            </div>

           <%-- (function () {
            var arr = [];
            $.ajax({
            type: "post",
            async: false, //同步执行
            url: "/admin/tag/getAllTagecharts",
            data: {},
            dataType: "json", //返回数据形式为json
            success: function (json) {
            if (json) {
            for (var i = 0; i < json.length; i++) {
            arr.push(json[i].tagName);
            }
            }

            },
            error: function (errorMsg) {
            alert("不好意思,图表请求数据失败啦!");
            myChart.hideLoading();
            }
            })--%>
        </div>
    </div>

</rapid:override>
<rapid:override name="footer-script">
    <script>
        $(function() {
            // 初始化
            //var myChart = echarts.init(document.getElementById('main'));
            var myChart = echarts.init($('#main')[0]); // 注意：这里init方法的参数的javascript对象，使用jQuery获取标签时，要将jQuery对象转成JavaScript对象；

            // 配置图标参数
            var options = {
                title: {
                    text: '标签对应文章数量',
                    show: true, // 是否显示标题
                    subtext: '',
                    textStyle: {
                        fontSize: 18 // 标题文字大小
                    }
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                legend: {
                    data: ['文章数量']
                },
                // X轴
                xAxis: {
                    data: [] // 异步请求时,这里要置空
                },
                // Y轴
                yAxis: {},
                series: [{
                    name: '文章数量',
                    type: 'bar', // 设置图表类型为柱状图
                    data: [] // 设置纵坐标的刻度(异步请求时,这里要置空)
                }]
            };

            var dom = document.getElementById("container");
            var pieChart = echarts.init(dom);
            var app = {};
            pieOption = null;
            app.title = '环形图';

            pieOption = {
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    x: 'left',
                    data:[]
                },
                series: [
                    {
                        name:'访问来源',
                        type:'pie',
                        radius: ['50%', '70%'],
                        avoidLabelOverlap: false,
                        label: {
                            normal: {
                                show: false,
                                position: 'center'
                            },
                            emphasis: {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'bold'
                                }
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            }
                        },
                        data:[
                        ]
                    }
                ]
            };
            ;




            // 给图标设置配置的参数
            myChart.setOption(options);
            myChart.showLoading(); // 显示加载动画
// 异步请求加载数据
            $.ajax({
                url: '/admin/tag/getAllTagecharts',
                type: 'post',
                dataType: 'json',
                success: function(data) {
                    var names = [];
                    var nums = [];
                    var json=[];
                    $.each(data, function(index, obj) {
                        if(obj.articleCount!=0){
                            names.push(obj.tagName);
                            nums.push(obj.articleCount);
                            var tagname=obj.tagName;
                            var articleCount=obj.articleCount;
                            var arr={name:obj.tagName,value:obj.articleCount};
                            json.push(arr);
                        }

                    })

                    myChart.hideLoading(); // 隐藏加载动画
                    myChart.setOption({
                        legend: {
                            data: ['文章数量']
                        },
                        xAxis: {
                            data: names
                        },
                        series: [{
                            name: '文章数量',
                            type: 'bar', // 设置图表类型为柱状图
                            data: nums // 设置纵坐标的刻度
                        }]
                    });
                    pieChart.hideLoading(); // 隐藏加载动画
                    pieChart.setOption({
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br/>{b}: {c} ({d}%)"
                        },
                        legend: {
                            orient: 'vertical',
                            x: 'left',
                            data:names,
                        },
                        series: [
                            {
                                name:'文章数量',
                                type:'pie',
                                radius: ['50%', '70%'],
                                avoidLabelOverlap: false,
                                label: {
                                    normal: {
                                        show: false,
                                        position: 'center'
                                    },
                                    emphasis: {
                                        show: true,
                                        textStyle: {
                                            fontSize: '30',
                                            fontWeight: 'bold'
                                        }
                                    }
                                },
                                labelLine: {
                                    normal: {
                                        show: false
                                    }
                                },
                                data:json
                            }
                        ]
                    });
                }
            });
        });






    </script>
</rapid:override>
<%@ include file="Public/framework.jsp" %>
