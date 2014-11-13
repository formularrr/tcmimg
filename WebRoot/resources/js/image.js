var root = "ftp://10.15.62.28";
$(function(){
	
	$("#test").live('click', function() {
		var obj = $.ajax({
			type : "post",
			url : "searchimage.html",
			contentType:"application/json;charset=utf-8",
			/* 			data : name,
       			contentType : contentType,
			dataType : "json",*/
			cache : "false",

			success : function(data) {
				console.log(data);
			}
		})
	});

    $("#upload_image").uploadify({
        height        : 30,
        swf           : './resources/uploadify/uploadify.swf',
//        uploader      : './resources/uploadify/uploadify.php',
        uploader      : 'uploadimage.html',
        width         : 120,
        'buttonText'		: '请选择图片',
        'method'   : 'post',
        'onUploadSuccess' : function(file, data, response) {
        	console.log(data);
        	var datas = data.split(",");
        	var name = datas[0];
        	var type = datas[1];
        	$("#img0").attr("src", './resources/uploads/' + name);
        	
			$(".preview").attr("src",'./resources/uploads/' + name);
			$('#img0').Jcrop({
				minSize: [50,50],
				setSelect: [0,0,300,300],
				onChange: updatePreview,
				onSelect: updatePreview,
				onSelect: updateCoords,
				aspectRatio: 1
			},
			function(){
				// Use the API to get the real image size
				var bounds = this.getBounds();
				boundx = bounds[0];
				boundy = bounds[1];
				// Store the API in the jcrop_api variable
				jcrop_api = this;
			});
			$(".imgchoose").show(1000);
			$("#avatar_submit").show(1000);
        	
        	$("#search_image").show();
        	$("#pic_type_div").show();
        	
        	robj = document.getElementsByName("plant_type");
        	for(i = 0; i < robj.length; i++)
        		if(robj[i].value == type)
        			robj[i].checked = true;
        	
            
           	$("#search_image").live('click', function() {
           		$('.bxslider').html("");
           		$("#search_result").html("");
           		var dataJson = 
           		{
           			"name":name,
           		};
           		
        		var obj = $.ajax({
        			type : "post",
        			url : "searchimage.html",
        			data : JSON.stringify(dataJson),
        			dataType : "json",
        			contentType:"application/json;charset=utf-8",
        /*        			contentType : contentType,
        			dataType : "json",*/
        			cache : "false",

        			success : function(data) {
        				console.log(data);
                   		$('.bxslider').html("");
                   		$("#search_result").html("");
        				var tmp = "";
        				for(var i = 0; i < data.rs.length; ++i){
        					
        					tmp = tmp + "<li><img src='" +  root + data.rs[i][0] + "'  width='500px' height='300px' /></li>";
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
var jcrop_api, boundx, boundy;
	
	function updateCoords(c)
	{
		$('#x').val(c.x);
		$('#y').val(c.y);
		$('#w').val(c.w);
		$('#h').val(c.h);
	};
	function checkCoords()
	{
		if (parseInt($('#w').val())) return true;
		alert('请选择图片上合适的区域');
		return false;
	};
	function updatePreview(c){
		if (parseInt(c.w) > 0){
			var rx = 112 / c.w;
			var ry = 112 / c.h;
			$('#preview').css({
				width: Math.round(rx * boundx) + 'px',
            	height: Math.round(ry * boundy) + 'px',
            	marginLeft: '-' + Math.round(rx * c.x) + 'px',
            	marginTop: '-' + Math.round(ry * c.y) + 'px'
			});
		}
		{
			var rx = 200 / c.w;
			var ry = 200 / c.h;
			$('#preview3').css({
				width: Math.round(rx * boundx) + 'px',
				height: Math.round(ry * boundy) + 'px',
				marginLeft: '-' + Math.round(rx * c.x) + 'px',
				marginTop: '-' + Math.round(ry * c.y) + 'px'
			});
		}
	};
	
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


