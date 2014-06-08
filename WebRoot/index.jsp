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
<!-- Shell -->
<div id="shell">
	<!-- Header -->
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
	<!-- /Header -->
	
	<!-- Navigation -->
	<div id="navigation">
		<ul>
			<li><a href="index.html" class="active"><span>首页</span></a></li>
<!-- 			<li><a href="#"><span>视频标注</span></a></li>
			<li><a href="image.html?id=0"><span>图像标注</span></a></li> -->
			<li><a href="image.html?id=0"><span>图像检索</span></a></li>
			<li><a href="#"><span>联系我们</span></a></li>
			
		</ul>
		<div class="cl">&nbsp;</div>
	</div>
	<!-- /Navigation -->
	
	<!-- Main -->
	<div id="main" class="big-box">
		<div class="bg-top">
			<div class="bg-bottom">
				<!-- Big Slider -->
				<div id="big-slider" class="slider">
					<!-- Slider Holder -->
					<div class="slider-holder">
						<ul>
							<!-- Slide -->
						    <li>
						    	<div class="image">
						    		<img src="css/images/big-slide-1.jpg" alt="" />
						    	</div>
						    	
						    	<div class="data">
						    		<h2>Lorem ipsum dolor sit amet, consectetur adipisc- ing elit.</h2>
						    		
						    		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent aliquet lacus at metus accumsan porta. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in ligula ut dui adipiscing commodo.</p>
						    		<p>Cras aliquet tellus sed dolor aliquet condimentum. Quisque in ligula orci &hellip; <a href="#">read more</a></p>
						    	</div>
						    </li>
						    <!-- Slide -->
						    
							<!-- Slide -->
						    <li>
						    	<div class="image">
						    		<img src="css/images/big-slide-1.jpg" alt="" />
						    	</div>
						    	
						    	<div class="data">
						    		<h2>Lorem ipsum dolor sit amet, consectetur adipisc- ing elit.</h2>
						    		
						    		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent aliquet lacus at metus accumsan porta. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in ligula ut dui adipiscing commodo.</p>
						    		<p>Cras aliquet tellus sed dolor aliquet condimentum. Quisque in ligula orci &hellip; <a href="#">read more</a></p>
						    	</div>
						    </li>
						    <!-- Slide -->
						    
							<!-- Slide -->
						    <li>
						    	<div class="image">
						    		<img src="css/images/big-slide-1.jpg" alt="" />
						    	</div>
						    	
						    	<div class="data">
						    		<h2>Lorem ipsum dolor sit amet, consectetur adipisc- ing elit.</h2>
						    		
						    		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent aliquet lacus at metus accumsan porta. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in ligula ut dui adipiscing commodo.</p>
						    		<p>Cras aliquet tellus sed dolor aliquet condimentum. Quisque in ligula orci &hellip; <a href="#">read more</a></p>
						    	</div>
						    </li>
						    <!-- Slide -->
						</ul>
						<div class="cl">&nbsp;</div>
					</div>
					<!-- Slider Holder -->
					
					<!-- Slider Link -->
					<a href="#" class="slider-link">View</a>
					<!-- /Slider Link -->
				</div>
				<!-- /Big Slider -->
				
				<!-- Top Text Block -->
				<div id="top" class="text-block">
					<!-- Content -->
					<div id="content" class="box">
						<h3>Nulla tellus tempus magna. </h3>
						
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dictum, neque ut imperdiet pellen- tesque, nulla tellus tempus magna, sed consectetur orci metus a justo. Integer dictum, neque ut imperdiet pellentesque, nulla tellus tempus magna, sed consectetur orci metus a justo. Aliquam ac congue nunc. Mauris a tortor ut massa egestas tempus. </p>
						<p>Cras aliquet tellus sed dolor aliquet condimentum. Quisque in ligula orci &hellip; <a href="#">read more</a></p>
					</div>
					<!-- Content -->
					<!-- Box -->
					<div class="box last">
						<h3>Consectetur  elit</h3>
						
						<p>Aliquam ac congue nunc. Mauris a tortor ut massa egestas tempus. Pellentesque tincidunt fermentum diam sagittis ullamcorper.</p>
						
						<p>Cras aliquet tellus sed dolor aliquet condimentum &hellip; <a href="#">read more</a></p>
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
		</div>
	</div>
	<!-- /Main -->
	
	<!-- Footer >
	<div id="footer">
		<p>
			&copy; 2010 <a href="#">Blogger</a> | 
			Design by <a href="http://chocotemplates.com" target="_blank" title="The Sweetest CSS Templates WorldWide">ChocoTemplates.com</a>
		</p>
	</div-->
	<!-- /Footer -->
</div>
<!-- /Shell -->
</body>
</html>