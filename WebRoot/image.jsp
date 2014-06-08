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
	<!-- 			<li><a href="#"><span>视频标注</span></a></li>
				<li><a href="image.html?id=0"><span>图像标注</span></a></li> -->
			<li><a href="image.html?id=0" class="active"><span>图像检索</span></a></li>
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
			<input type="file" name="file0" id="file0" multiple="multiple" /><br><img src="" id="img0" >			
			</form>
					</div>
					<!-- Content -->
					<!-- Box -->
					<div class="box last">
						<h3>Consectetur  elit</h3>
						
						<p>Aliquam ac congue nunc. Mauris a tortor ut massa egestas tempus. Pellentesque tincidunt fermentum diam sagittis ullamcorper.</p>
						
						<p>Cras aliquet tellus sed dolor aliquet condimentum &hellip; <a href="#">read more</a></p>
					</div>
							<div id="content" class="box">

		</div>
					<!-- /Box -->
					<div class="cl">&nbsp;</div>
					
				</div>
				<!-- /Top Text Block -->
				
				
				
				<!-- Small Slider -->
				<div id="small-slider" class="slider">
					<!-- Sldier Headings -->
					<div class="slider-head">
						<h4>Whats HOT this week</h4>
					
						<div class="categories">
							<a href="#" class="active">Events</a>
							<a href="#">News</a>
							<a href="#">Interviews</a>
							<a href="#">Opinions</a>
						</div>
						<div class="cl">&nbsp;</div>
					</div>
					<!-- /Slider Headings -->
					
					<!-- Slider Holder -->
					<div class="slider-holder">
						<ul>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-1.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-2.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-3.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-4.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-5.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-6.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-7.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-1.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-2.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-3.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-4.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-5.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-6.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="css/images/big-slide-1.jpg" rel="small-slider">
									<span>&nbsp;</span>
									<img src="css/images/small-slider-7.jpg" alt="" />
								</a>
							</li>
						</ul>
						
						<div class="cl">&nbsp;</div>
					</div>
					<!-- /Slider Holder -->
				</div>
				<!-- /Small Slider -->
				
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
		</di
	</div>

</div>
<script>	
$("#file0").change(function(){
	var objUrl = getObjectURL(this.files[0]) ;
	console.log("objUrl = "+objUrl) ;
	if (objUrl) {
		$("#img0").attr("src", objUrl) ;
	}
}) ;
//建立一個可存取到該file的url
function getObjectURL(file) {
	var url = null ; 
	if (window.createObjectURL!=undefined) { // basic
		url = window.createObjectURL(file) ;
	} else if (window.URL!=undefined) { // mozilla(firefox)
		url = window.URL.createObjectURL(file) ;
	} else if (window.webkitURL!=undefined) { // webkit or chrome
		url = window.webkitURL.createObjectURL(file) ;
	}
	return url ;
}
</script>
</body>
</html>