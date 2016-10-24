/**
 * @author liangbing
 */
//分页对象
var page = {
	currentPageNo:1,//当前页码
	pageSize:0,//每页的大小
	pageNoCount:0,//总页码数
	totalCount:0//数据总数
};

//http请求 param
var postParam = {
	channelId:$("#channel").val(),
	pageNo:page.currentPageNo,
	searchContent:""
};

var queryUrl = "fetchData.html";

$(function(){
	//回到顶部
    $('.goups').click(function(){
        $('body,html').animate({scrollTop:0},1000);
    });
    //获取数据
    fetchData(queryUrl,postParam);
});
//固定页码
function toPage(currentPageNo){
	postParam.pageNo = currentPageNo;
	fetchData(queryUrl,postParam);
}

//下一页
function nextPage(){
	postParam.pageNo = page.currentPageNo + 1;
	fetchData(queryUrl,postParam);
}
//上一页
function prePage(){
	postParam.pageNo = page.currentPageNo - 1;
	fetchData(queryUrl,postParam);
}

/**
 * 分页变化监听
 */
function pageDivListener(){
	
	var prePageA = $("#prePageA");
	var nextPageA = $("#nextPageA");
	
	var pageNoLastA = $("#pageNoLastA");
	
	var ellipsis_first = $("#firstSpan");	
	var ellipsis_last = $("#lastSpan");
	
	var currentPageNo = page.currentPageNo;
	
	var currentPageA;
	var currentPageNoStr = formatNum(currentPageNo,page.pageNoCount);
	
	var aArray = $("#aDiv").children("a");
	for(var i=0;i<aArray.length;i++){
		if($(aArray[i]).html() == currentPageNoStr){
			currentPageA = $(aArray[i]); 
			$(aArray[i]).attr("class","cur");
			break;
		}
	}
	
	if(currentPageNo == 1){
		prePageA.css("display","none");
	}
	if(currentPageNo < 5){
		ellipsis_first.css("display","none");
	}
	if(currentPageNo > page.pageNoCount - 4){
		ellipsis_last.css("display","none");
	}
	if(currentPageNo == page.pageNoCount){
		nextPageA.css("display","none");
	}
	
}

//根据总页数，取当前页码相邻的4个页码
function getSub4Num(num,max){
	var mid = parseInt(max/2) + 1;
	var resultArray = new Array(4);
	if(num > 4 && num < mid){
		resultArray[0] = num -2;
		resultArray[1] = num -1;
		resultArray[2] = num;
		resultArray[3] = num +1;
	}
	if(num >= mid && num <= max - 4){
		resultArray[0] = num -1;
		resultArray[1] = num;
		resultArray[2] = num +1;
		resultArray[3] = num +2;
	}
	return resultArray;
}

/**
 * 格式化输出数字
 * eg:1,100 ---> 001,100
 * @param num
 * @param max
 * @returns {String}
 */
function formatNum(num,max){
	var max_length = (max + "").length;
	var num_length = (num + "").length;
	for(var i=0;i<(max_length - num_length);i++){
		num = "0"+ num;
	}
	return num;
}

/**
 * 拼接分页html
 * @returns {String}
 */
function assmbedPagingDiv(){
	var pageDiv ="";
	var headDiv = "<div class=\"page clearfix\">"
				+ "<div id=\"aDiv\" class=\"page-main\">"
				+ "<a href=\"javascript:toPage(1);\">首&nbsp;&nbsp;&nbsp;页</a>";
	var prePageA = "<a href=\"javascript:prePage()\" class=\"cur\">上一页</a>";
	var nextPageA = "<a href=\"javascript:nextPage()\">下一页</a>";
	var tailDiv = "<a href=\"javascript:toPage("+page.pageNoCount+")\">尾&nbsp;&nbsp;&nbsp;页</a>"
    			+ "</div>"
    			+ "</div>";
	
	var prePageA = "<a id=\"prePageA\" href=\"javascript:prePage()\">上一页</a>";
	var nextPageA = "<a id=\"nextPageA\" href=\"javascript:nextPage()\">下一页</a>";
	//页码一页
	if(page.pageNoCount == 1){
		var pageNoA = "<a href=\"javascript:toPage(1)\" class=\"cur\">"+01+"</a>";
		pageDiv = headDiv + pageNoA + tailDiv;
	}
	//页码在1到6页
	if(page.pageNoCount > 1 && page.pageNoCount <= 6){
		var pageNoA = "";
		for(var i=1;i<=page.pageNoCount;i++){
			pageNoA += "<a href=\"javascript:toPage("+i+")\">"+formatNum(i, page.pageNoCount)+"</a>";
		}
		pageDiv = headDiv + prePageA + pageNoA + nextPageA + tailDiv;
	}
	//页码为6页以上
	if(page.pageNoCount > 6){
		var pageA = "";
		
		var ellipsis_first = "<span id=\"firstSpan\">......</span>";
		var ellipsis_last = "<span id=\"lastSpan\">......</span>";
		
		var pageNoA_first = "<a id=\"firstPageNoA\" href=\"javascript:toPage(1)\">"+formatNum(1, page.pageNoCount)+"</a>";
		pageA += pageNoA_first;
		pageA += ellipsis_first;
		
		var numArray;
		if(page.currentPageNo <= 4){
			numArray = [2,3,4,5];
		}
		if(page.currentPageNo > page.pageNoCount -4){
			numArray = [page.pageNoCount-4,page.pageNoCount-3,page.pageNoCount-2,page.pageNoCount -1];
		}
		if(page.currentPageNo > 4 && page.currentPageNo <= page.pageNoCount -4){
			numArray = getSub4Num(page.currentPageNo,page.pageNoCount);
		}
		
		for(var i=0;i<numArray.length;i++){
			pageA += "<a href=\"javascript:toPage("+numArray[i]+")\">"+formatNum(numArray[i],page.pageNoCount)+"</a>";
		}
		
		pageA += ellipsis_last;
		var pageNoA_last = "<a id=\"pageNoLastA\" href=\"javascript:toPage("+page.pageNoCount+")\">"+page.pageNoCount+"</a>";
		pageA += pageNoA_last;
		
		pageDiv = headDiv + prePageA + pageA + nextPageA + tailDiv;
	}
	return pageDiv;
}
/**
 * 拼接游戏数据html
 * @param dataVo
 */
function assmbedDataDiv(dataVo){
	var div = "";
	if(dataVo.length > 0){
		for(var i=0;i<dataVo.length;i++){
			
			var obj = dataVo[i];
			//拼接div
			var data_div = "<div class=\"box\">";
			data_div += "<img src=\""+obj.icon+"\">";
			data_div += "<span>"+obj.displayName+"</span>";
			data_div += "<p><a href=\"javascript:void(0)\" class='text'>"+obj.className+"</a>";
			data_div += "<a href=\"javascript:void(0)\" class=\"ml-4\">"+obj.apkSize+"M</a></p>";
			data_div += "<p>游戏评分：<a href=\"javascript:void(0)\">"+obj.ratingScore+"</a></p>";
			data_div += "<a href=\""+obj.gameApk+"\" target=\"_blank\" class=\"down\">立即下载</a></div>";
			
			//拼接显示div
			div += data_div;
		}
		//拼接 分页 div
		div += assmbedPagingDiv();
	}else{
		div = "无数据...";
	}
	return div;
}

/**
 * 搜索
 */
function searchData(){
	var searchContent = $("#searchInput").val();
	
	postParam.searchContent = searchContent.trim();
	postParam.pageNo = 1;
	
	fetchData(queryUrl,postParam);
}

/**
 * http 请求
 * @param url 请求url 
 * @param param 请求参数
 */
function fetchData(url,param){
	$("#dataWrapper").html("loading...");
	$.ajax({
		type: "POST",
		url : url,
		data: param,
		dataType: "json",
		success: function(data){
			if(data.code != 2000){
				alert("系统异常!");
				return;
			}
			var obj = data.obj;
			var dataVo = "";
			if(obj.dataVo){
				dataVo = obj.dataVo;
			}
			if(obj.pageVo){
				//page 对象
				page = obj.pageVo;
				//共多少款游戏
				$("#count").html(page.totalCount);
			}
			$("#dataWrapper").html(assmbedDataDiv(dataVo));
			pageDivListener();
		}
	});
}

