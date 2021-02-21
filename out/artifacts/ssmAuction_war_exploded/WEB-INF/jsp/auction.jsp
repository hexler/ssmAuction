<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>竞拍页面</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
      <div class="logout right"><a href="${pageContext.request.contextPath}/quit" title="注销">注销</a></div>
  </div>
  <div class="items sg-font lf">
      <ul class="rows">
        <li>名称：</li>
        <li class="borderno">${auctionByAuctionid.auctionname}</li>
      </ul>
      <ul class="rows">
        <li>描述：</li>
        <li class="borderno">${auctionByAuctionid.auctionname}</li>
      </ul>
      <ul class="rows">
        <li>开始时间：</li>
        <li class="borderno"><fmt:formatDate value="${auctionByAuctionid.auctionstarttime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></li>
      </ul>
      <ul class="rows">
        <li>结束时间：</li>
        <li class="borderno"><fmt:formatDate value="${auctionByAuctionid.auctionendtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></li>
      </ul>
      <ul class="rows border-no">
        <li>起拍价：</li>
        <li class="borderno">${auctionByAuctionid.auctionstartprice}</li>
      </ul>
  </div>
  <div class="rg borders"><img src="images/${auctionByAuctionid.auctionpic}" width="270" height="185" alt="" /></div>
  <div class="cl"></div>

  <div class="top10 salebd">
       <p>
       <label for="sale">出价：</label>
       <form action="${pageContext.request.contextPath}/saveAuctionrecord" method="get">
      <input type="hidden" value="${auctionByAuctionid.auctionid}" name="auctionid"/>
       <input type="text"  class="inputwd" id="sale" value="${a1.auctionprice+100}" name="auctionprice"/>
       <input name="" type="submit" value="竞 拍" class="spbg buttombg f14  sale-buttom" />
       </form>
       </p>
       <p class="f14 red">不能低于最高竞拍价</p>
  </div>

  <div class="top10">
    <input name="" type="submit" value="刷 新" class="spbg buttombg f14" />
    <input name="" type="submit" value="返回列表" class="spbg buttombg f14" />
  </div>
  <div class="offer">
    <h3>出价记录</h3>
    <div class="items sg-font">
      <ul class="rows even strong">
        <li>竞拍时间</li>
        <li>竞拍价格</li>
        <li class="borderno">竞拍人</li>
      </ul>
        <c:forEach items="${auctionrecordList}" var="auctionrecord">
            <ul class="rows">
                <li><fmt:formatDate value="${auctionrecord.auctiontime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></li>
                <li>${auctionrecord.auctionprice}</li>
                <li class="borderno">${auctionrecord.user.username}</li>
            </ul>
        </c:forEach>


  </div>
  </div>
<!-- main end-->
</div>
</body>
</html>
