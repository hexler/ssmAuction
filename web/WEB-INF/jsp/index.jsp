<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>在线拍卖系统首页</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎：<span style="color: red">${userinfo.username}</span></h1>
    <div class="logout right"><a href="${pageContext.request.contextPath}/quit" title="注销">注销</a></div>
  </div>
  <div class="forms">
    <label for="name">名称</label>
    <input name="" type="text" class="nwinput" id="name"/>
    <label for="names">描述</label>
    <input name="" type="text" id="names" class="nwinput"/>
    <label for="time">开始时间</label>
    <input name="" type="text" id="time" class="nwinput"/>
    <label for="end-time">结束时间</label>
    <input name="" type="text" id="end-time" class="nwinput" />
    <label for="price">起拍价</label>
    <input name="" type="text" id="price" class="nwinput" />
    <input name="" type="button"  value="查询" class="spbg buttombg f14  sale-buttom"/>
    <input type="button"  value="发布" class="spbg buttombg f14  sale-buttom buttomb"/>
  </div>
  <div class="items">
      <ul class="rows even strong">
        <li>名称</li>
        <li class="list-wd">描述</li>
        <li>开始时间</li>
        <li>结束时间</li>
        <li>起拍价</li>
        <li class="borderno">操作</li>
      </ul>

      <%--<c:forEach begin="0" end="100" var="i">
          ${i}
      </c:forEach>--%>
      <c:forEach items="${auctionList}" var="auction">
          <ul class="rows">
              <li><a href="#" title="">${auction.auctionname}</a></li>
              <li class="list-wd">${auction.auctionname}</li>
              <li><fmt:formatDate value="${auction.auctionstarttime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></li>
              <li><fmt:formatDate value="${auction.auctionendtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></li>
              <li>${auction.auctionstartprice}</li>
              <li class="borderno red">
                 <%-- <a href="#" title="竞拍" onclick="dele();">修改</a>|
                  <a href="#" title="竞拍" onclick="abc();">删除</a>--%>
                     <a href="${pageContext.request.contextPath}/toAuction?auctionid=${auction.auctionid}" title="竞拍" >竞拍</a>
              </li>
          </ul>

      </c:forEach>


      <div class="page">
        <a href="#" title="">首页</a>
        <a href="#" title="">上一页</a>
        <span class="red">前5页</span>
        <a href="#" title="">1</a> 
        <a href="#" title="">2</a> 
        <a href="#" title="">3</a> 
        <a href="#" title="">4</a>
        <a href="#" title="">5</a> 
        <a href="#" title="">下一页  </a>
        <a href="#" title="">尾页</a> 
      </div>
  </div>
  <script>
   function abc(){
	   
	   if(confirm("你真的确认要删除吗？请确认")){
	    
		   return true;
		 }
		 else{
			 return false;
			 }
			 
	   };
	   function dele(){
		   if(confirm("你真的确认要修改吗？请确认")){
			   return true;
			   }
			   else{
				   return false;
				   }
		   }
  </script>
<!-- main end-->
</div>
</body>
</html>
