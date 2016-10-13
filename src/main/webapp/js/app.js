var data_div =   "<div class=\"box\">"
			   + "<img src=\"<%=contextPath %>/images/icon.png\">"
			   + "<span>皇室战争</span>"
			   + "<p><a href=\"javascript:void(0)\">策略</a><a href=\"javascript:void(0)\" class=\"ml-4\">100.6M</a></p>"
			   + "<p>当前版本：<a href=\"javascript:void(0)\">4.5</a></p>"
			   + "<a href=\"javascript:void(0);\" target=\"_blank\" class=\"down\">立即下载</a></div>";

$(function(){
	
	//回到顶部
    $('.goups').click(function(){
        $('body,html').animate({scrollTop:0},1000)
    });
    
    //获取数据
    fetchData();
    
});

function fetchData(){
	var channel = $("#channel").val();
	$("#dataWrapper").html("ss");
	$.ajax({
		type: "GET",
		url : "fetchData",
		data: "channel="+channel,
		dataType: "json",
		success: function(data){
			$("#dataWrapper").html(data_div);
		}
	});
}

function parseJson(json){
	var data = eval("("+json+")");
	
}