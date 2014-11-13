
$(function(){

	
    $("#upload_image").uploadify({
        height        : 30,
        swf           : './resources/uploadify/uploadify.swf',
//        uploader      : './resources/uploadify/uploadify.php',
        uploader      : 'uploadimage.html',
        width         : 120,
        'method'   : 'post',
        'onUploadSuccess' : function(file, data, response) {
        	console.log(data);
        	var datas = data.split(",");
        	var name = datas[0];
        	var type = datas[1];
        	$("#img0").attr("src", './resources/uploads/' + name);
        	$("#search_image").show();
        	$("#pic_type_div").show();
        	
        	robj = document.getElementsByName("plant_type");
        	for(i = 0; i < robj.length; i++)
        		if(robj[i].value == type)
        			robj[i].checked = true;
        	
            
           	$("#search_image").live('click', function() {
           		$('.bxslider').html("");
           		$("#search_result").html("");
        		var obj = $.ajax({
        			type : "post",
        			url : "searchimage.html",
        			data : name,
        /*        			contentType : contentType,
        			dataType : "json",*/
        			cache : "false",
        /*        			statusCode : {
        				400 : function() {
        					alert("非法请求");
        				},
        				401 : function() {
        					alert("非法用户");
        				},
        				403 : function() {
        					alert("无权限");
        				},
        				404 : function() {
        					alert("URL访问路径错误");
        				},
        				409 : function() {
        					alert("操作冲突，不允许");
        				},
        				500 : function() {
        					alert("服务器错误");
        				}
        			},*/
        			success : function(data) {
                   		$('.bxslider').html("");
                   		$("#search_result").html("");
        				console.log(data);
        				var list = data.substring(1, data.length - 1).split(",");
        				var tmp = "";
        				for(var i = 0; i < list.length; ++i){
        					
        					var path = "ftp://10.15.62.28" + list[i].LTrim();
        					path = path.RTrim();
        					var all = path.split("+");
        					
        					var url = all[0];
        					changeChinese(url);
        					console.log(url + " '''" + all[1]);
        					tmp += "<li>";
        					tmp = tmp +	"<img src='" + url + "'  width='500px' height='300px' />"
        					tmp += "</li>"
        				}
        				
        				$("#search_result").html(tmp);
        				//init();
        				
        				$('.bxslider').bxSlider({
        					  minSlides: 1,
        					  maxSlides: 1,
        					  slideWidth: 960,
        					  slideMargin: 10
        					});
        				$("#search_result").show();
        				
        				
        			}
        		})
        		
        	});
        	
        }
    });

	
});

function init(){
	$('.bxslider').bxSlider({
		 mode: 'fade',
		  captions: true
		});
	$("#search_result").show();
}

String.prototype.Trim = function()  
{  
	return this.replace(/(^\s*)|(\s*$)/g, "");  
}  
String.prototype.LTrim = function()  
{  
	return this.replace(/(^\s*)/g, "");  
}  
String.prototype.RTrim = function()  
{  
	return this.replace(/(\s*$)/g, "");  
}  

function changeChinese(url){

	var index = url.indexOf("plantPhotoCn");
	if(index == -1)
		return;
	
	var tmp = url.substring(index + 13);
	index = tmp.indexOf("\\");
	tmp = tmp.substring(0, index);
	
	console.log((tmp));
	
}


