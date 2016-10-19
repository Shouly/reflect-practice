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
	$("#dataWrapper").html("Loading...");
	$.ajax({
		type: "GET",
		url : "fetchData.html",
		data: "channel="+channel,
		dataType: "json",
		success: function(data){
			var objArray = data.obj;
			var div = "";
			if(objArray.length > 0){
				for(var i=0;i<objArray.length;i++){
					var obj = objArray[i];
					//拼接div
					var data_div = "<div class=\"box\">";
					data_div += "<img src=\""+obj.icon+"\">";
					data_div += "<span>"+obj.displayName+"</span>";
					data_div += "<p><a href=\"javascript:void(0)\">"+obj.className+"</a>" +
							"<a href=\"javascript:void(0)\" class=\"ml-4\">"+obj.apkSize+"M</a></p>";
					data_div += "<p>当前版本：<a href=\"javascript:void(0)\">"+obj.versionName+"</a></p>";
					data_div += "<a href=\""+obj.gameApk+"\" target=\"_blank\" class=\"down\">立即下载</a></div>";
					
					div += data_div;
				}
			}else{
				
			}
			$("#dataWrapper").html(div);
		}
	});
}

