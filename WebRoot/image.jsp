<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
	<title>中草药图像检索系统</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<link rel="shortcut icon" href="./resources/css/images/favicon.ico?cb=1" />
	<link rel="stylesheet" href="./resources/css/style.css" type="text/css" media="all" />
	<!--[if IE 6]>
		<link rel="stylesheet" href="./resources/css/ie6.css" type="text/css" media="all" />
	<![endif]-->
	<link rel="stylesheet" href="./resources/js/fancybox/jquery.fancybox-1.3.1.css" type="text/css" media="screen" />
	
	<script type="text/javascript" src="./resources/js/jquery_1_8_3.js"></script>
	<script type="text/javascript" src="./resources/js/jquery.jcarousel.js"></script>
	<script type="text/javascript" src="./resources/js/fancybox/jquery.fancybox-1.3.1.js"></script>
	<script type="text/javascript" src="./resources/js/jquery-func.js"></script>
	<script type="text/javascript" src="./resources/js/image.js"></script>
	
	<!-- 图片上传插件 -->
	<script type="text/javascript" src="./resources/uploadify/jquery.uploadify.min.js"></script>
	<link rel="stylesheet" href="./resources/uploadify/uploadify.css" type="text/css" media="screen" />
	
	<!-- 图片轮播插件 -->
	<script type="text/javascript" src="./resources/jquery.bxslider/jquery.bxslider.min.js"></script>
	<link rel="stylesheet" href="./resources/jquery.bxslider/jquery.bxslider.css" type="text/css" media="screen" />
	
</head>
<body>
<div id="shell">
	<div id="header" class="big-box">
		<div class="bg-bottom">
			<!-- Logo -->
			<h1 id="logo"><a href="#">中草药图像检索系统</a></h1>
			<!-- /Logo -->
			
			<!-- Search >
			<div id="search">
				<form action="#" method="post">
					<fieldset>
						<input type="text" name="string" value="" class="field" />
						<input type="submit" value="SEARCH" class="submit" />
					</fieldset>
				</form>
			</div>
			<!-- /Search -->
			
			<div class="cl">&nbsp;</div>
		</div>
	</div>
	
	<div id="navigation">
		<ul>
			<li><a href="index.html" ><span>首页</span></a></li>
			<li><a href="image.html" class="active"><span>图像检索</span></a></li>
			<li><a href="#"><span>联系我们</span></a></li>
			
		</ul>
		<div class="cl">&nbsp;</div>
	</div>
	
	<div id="main" class="big-box">
		 <div class="bg-top">
			<div class="bg-bottom">
				<!-- Top Text Block -->
				<div id="top" class="text-block">
					<!-- Content -->
					<div id="content" class="box">
						<h3>请选择想要检索的图片 </h3>
						<form name="form0" id="form0" >
							<input type="file" name="upload_image" id="upload_image" multiple="multiple" /><br>	<img src="" id="img0" width="500px" height="300px"></br>	
							
							
							<div id="pic_type_div" style="display:none">
							<form name="plant_type_form">
							<input type="radio" name="plant_type" value="1" /> 叶子
							<input type="radio" name="plant_type" value="2" /> 花
							<input type="radio" name="plant_type" value="3" /> 全株
							<input type="radio" name="plant_type" value="4" /> 茎
							<input type="radio" name="plant_type" value="5" /> 果实
							</form>
						</div>
						
						<button type="button" style="display:none" id="search_image">开始检索</button>
						</form>
						

						
					</div>
					

					<!-- Content -->
					<!-- Box -->
<!-- 					<div class="box last">
						<h3>Consectetur  elit</h3>
						
						<p>Aliquam ac congue nunc. Mauris a tortor ut massa egestas tempus. Pellentesque tincidunt fermentum diam sagittis ullamcorper.</p>
						
						<p>Cras aliquet tellus sed dolor aliquet condimentum &hellip; <a href="#">read more</a></p>
					</div> -->

					<!-- /Box -->
					<div class="cl">&nbsp;</div>
					
				</div>
				<!-- /Top Text Block -->
				<!-- <h3>该图片有可能为 Carpinus betulus<h3></br> -->
				<div class="bxslider" id="search_result"></div>
				
				<!-- Bottom Text Block -->
				<div id="bottom" class="text-block">
					<!-- Box -->
					<div class="box">
						<h3>Aliquam ac congue.</h3>
						
						<p>Aliquam ac congue nunc. Mauris a tortor ut massa egestas tempus. Pellentesque tincidunt fermentum diam sagittis ullamcorper.</p>
						
						<p>Cras aliquet tellus sed dolor aliquet condimentum &hellip; <a href="#">read more</a></p>
					</div>
					<!-- /Box -->
					
					<!-- Box -->
					<div class="box">
						<h3>Mauris a tortor ut </h3>
						
						<p>Aliquam ac congue nunc. Mauris a tortor ut massa egestas tempus. Pellentesque tincidunt fermentum diam sagittis ullamcorper.</p>
						
						<p>Cras aliquet tellus sed dolor aliquet condimentum &hellip; <a href="#">read more</a></p>
					</div>
					<!-- /Box -->
					
					<!-- Box -->
					<div class="box last">
						<h3>Integer dictum</h3>
						
						<p>Aliquam ac congue nunc. Mauris a tortor ut massa egestas tempus. Pellentesque tincidunt fermentum diam sagittis ullamcorper.</p>
						
						<p>Cras aliquet tellus sed dolor aliquet condimentum &hellip; <a href="#">read more</a></p>
					</div>
					<!-- /Box -->
					
					<div class="cl">&nbsp;</div>
				</div>
				<!-- /Bottom Text Block -->
				
				
			</div>
	</div>

</div>

</body>
</html>