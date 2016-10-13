<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String channel = request.getParameter("channel");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <title>小米游戏渠道推广</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta content="telephone=no" name="format-detection">
    <link rel="stylesheet" href=" <%=contextPath %>/css/style.css">
    <script type="text/javascript" src=" <%=contextPath %>/js/youziku.api.min.js"></script>
</head>

<body class="yy">
    <div class="banner">
        <div class="b-main">
            <img src=" <%=contextPath %>/images/logo.png" alt="">
            <div class="title">
                <img src=" <%=contextPath %>/images/ni.png">
            </div>
            <div class="b-search">
                <div class="search">
                    <button type="button" class="btn-search"><img src=" <%=contextPath %>/images/search.png" alt=""></button>
                    <input type="text" placeholder="皇室战争" class="b-text yy">
                </div>
            </div>
            <p>共<a href="javascript:void(0);">123456</a>款游戏</p>
        </div>
    </div>
    <!-- 渠道标示 -->
    <%
    	if(channel == null){
    %>
	    <input type="hidden" id="channel" value="">
    <%		
    	}else{
    %>
    	<input type="hidden" id="channel" value="<%= channel%>">
    <%
    	}
    %>
    
    <div class="game">
    <div id="dataWrapper" class="game-box clearfix">
        <div class="box">
            <img src="<%=contextPath %>/images/icon.png" alt="">
            <span>皇室战争</span>
            <p><a href="javascript:void(0)">策略</a><a href="javascript:void(0)" class="ml-4">100.6M</a></p>
            <p>当前版本：<a href="javascript:void(0)">4.5</a></p>
            <a href="javascript:void(0);" target="_blank" class="down">立即下载</a>
        </div>
        
        <!-- 分页 -->
        <div class="page clearfix">
            <div class="page-main">
                <a href="javascript:void(0)">首&nbsp;&nbsp;&nbsp;页</a>
                <a href="javascript:void(0)" class="cur">上一页</a>
                <a href="javascript:void(0)">01</a>
                ......
                <a href="javascript:void(0)">83</a>
                <a href="javascript:void(0)">下一页</a>
                <a href="javascript:void(0)">尾&nbsp;&nbsp;&nbsp;页</a>
            </div>
        </div>
    </div>
    <div class="goup">
        <img src="<%=contextPath %>/images/go.png" class="goups">
    </div>
</div>
<script type="text/javascript" src=" <%=contextPath %>/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src=" <%=contextPath %>/js/app.js"></script>
<script type="text/javascript">
    $youziku.load(".yy", "da29cead5006453db7fc1338a653c3db", "YouYuan");
    $youziku.draw();
</script>
</body>
</html>