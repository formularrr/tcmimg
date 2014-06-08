<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%String context_header = request.getContextPath();%>
    <link rel="stylesheet" type="text/css" href="。/resources/commonpages/css/nav_header.css"></link>
    <link rel="stylesheet" type="text/css" href="。/resources/commonpages/dropdown/dropdown.css"></link>
    <script src="。/resources/commonpages/js/nav_header.js"></script>
	<div id="common_nav">
	    <div class="cf" id="common_nav_L2">
	        <ul>
	            <li>
	                <a title="注册" href="./user/registerpage" rel="nofollow">注册</a>
	            </li>
                <c:if test="${empty user}">
                    <li>
                        <a title="登录" href="./user/loginpage" rel="nofollow">登录</a>
                    </li>
                </c:if>
	            <c:if test="${not empty user}">
	                <li>
	                    <ul id="dropdown">
						    <li>
						        <a href="#" class="parent">${user.userName}<b class="a_trig"></b></a> 
						        
						        <ul class="children">
						            <li><a href="./user/${user.userId}/">个人信息</a></li>
						            <li><a href="./user/logout">退出系统</a></li>
						        </ul>
						    </li>
						</ul>
	                </li>
	            </c:if>
	            <li><a title="帮助中心" href="javascript:void(0);" rel="nofollow">帮助中心</a></li>
	            <li><a title="知识中心导航" href="javascript:void(0);" rel="nofollow">知识中心导航</a></li>
	            <li><a title="知识中心首页" href="http://www.udms.org/ckcest/" rel="nofollow">知识中心首页</a></li>
	            <li><a class="current" title="中草药系统首页"  href="./" rel="nofollow">中草药系统首页</a></li>
	        </ul>
	    </div>
	</div>