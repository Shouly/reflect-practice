<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String channel = request.getParameter("channelId");
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
                    <button type="button" class="btn-search"><img src=" <%=contextPath %>/images/search.png" alt="" onclick="searchData();"></button>
                    <input id="searchInput" type="text" placeholder="皇室战争" class="b-text yy" onkeydown="javascript:if(event.keyCode==13) searchData();">
                </div>
            </div>
            <p>共<a id="count" href="javascript:void(0);"></a>款游戏</p>
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