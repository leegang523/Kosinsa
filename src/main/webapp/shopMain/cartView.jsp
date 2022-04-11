<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, shop.mvc.domain.*"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
	<link href="css/style.css" rel="stylesheet" type="text/css">
<title>장바구니</title>

<script type="text/javascript">
function check()
{ 	
	document.input.DOR.value = "m"
	document.input.submit();
}
function check1()
{ 	
	document.input.DOR.value = "d"
	document.input.submit();
}
</script>
<header>
	<div id="top">
		<div class="box">
			<div id="top_logo">
				<img src="img/logo1.png"width='50' height='50'>
			</div>
			<div id="top_ad">
			<%
	        // 현재 로그인된 아이디가 없다면 (= session에 저장된 id가 없다면)
	        String email = (String) session.getAttribute("EMAIL");
			%>
				데일리 남성의류 스토어, 예쁜 레더자켓, 티셔츠, 코트, 자켓, 루즈핏 사이즈 등 판매&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; - <%=email %> 회원님 어서오세요
<%
	        if(email == null) {
%>
            <li><a href="shopMain.do?m=signup">회원가입</a></li>
            <li><a href="shopMain.do?m=login">로그인</a></li>
            <li><a href="shopMain.do?m=cartView">장바구니</a></li>
<%          
            }
		
        // 현재 로그인된 아이디가 있다면 (= session에 저장된 id가 있다면)
			else {
%>
            <li><a href="shopMain.do?m=logout">로그아웃</a></li>
            <li><a href="shopMain.do?m=cartView&cartViewEmail=<%=email%>">장바구니</a></li>
            <li><a href="shopMain.do?m=orderlist&olEmail=<%=email%>">주문 내역보기</a></li>
<%			
        	}
%>	
				
				
			</div>
			<div id="search">
				<input type="text">				
			</div>
		</div>
	</div> <!-- top -->
	<div class="clear"></div>
	<div id="logo">
		<div class="box">
			<div id="jjim">
				<img src="img/jjim.png">
			</div>
			<div id="logo_image">
				<a href="shopMain.do">
				<img src="img/logo.png"width='230' height='100'>
				</a>
			</div>
		</div>
	</div> <!-- logo -->
</header>
<nav id="main_menu">
	<div class="box">
		<ul>
		<li><a href="shopMain.do">전체 상품</a></li>
		<li><a href="shopMain.do?m=cateMain&category=outer">아우터</a></li>
		<li><a href="shopMain.do?m=cateMain&category=top">상의</a></li>
		<li><a href="shopMain.do?m=cateMain&category=bottom">하의</a></li>
		<li><a href="shopMain.do?m=cateMain&category=shoes">신발</a></li>
		<li><a href="shopMain.do?m=cateMain&category=others">기타</a></li>
		</ul>
	</div>
</nav>
<body>
<div align="center">
	<br>
	<br>
	<br>
	<br>
	<h3>[장바구니 보기]</h3>
	<br>
	<br>
	<table border="1">
		<tr>
			<th style="background-color: #eae1d8; text-align: center;">선택폼
			<th style="background-color: #eae1d8; text-align: center;">카트번호</th>
			<th style="background-color: #eae1d8; text-align: center;">제품이미지</th>
			<th style="background-color: #eae1d8; text-align: center;">제품이름</th>
			<th style="background-color: #eae1d8; text-align: center;">가격 </th>
			<th style="background-color: #eae1d8; text-align: center;">주문 수량</th>
			<th style="background-color: #eae1d8; text-align: center;">결제 금액</th>
		</tr>
<%
ArrayList<Cart> cartlist = (ArrayList<Cart>)request.getAttribute("cartlist");
if(cartlist != null){
		if(cartlist.size() == 0) {
%>
		<tr align='center'>
			<td colspan= '7'>
				장바구니에 담긴 상품이 없습니다.
			</td>
		</tr>
<%
		} else {
		%>
		<form name="input" method="post" action="shopMain.do?m=ordersIn&OEmail=<%=email%>">	
				<input type="hidden" name="DOR" value="">
		<%	
			for(Cart dto : cartlist){
		%>
		<tr align= 'center'>
		<th>
		<input type="checkbox" name="item" value="<%=dto.getCnum() %>">
			<td><%=dto.getCnum() %></td>
			<td><img><img src='img/<%=dto.getCdetail() %>'width='100' height='100'></img></td>
			<td><%=dto.getCname() %></td>
			<td><%=dto.getCprice()%></td>
			<td><%=dto.getCcnt() %></td>
			<td><%=dto.getCartPrice() %></td>
		</tr>
		
<% 
			}
%>
		</form>
		</th>
<%
		}
}	
%>
	</table>
	<br>
	<tr align = 'center'>
			<td colspan= '4'>
				<input type="button" style="color: black; background:white; font-size:14px; border-radius:0.5em; padding:5px 20px;" value="주문하기" onclick="check()">
				<input type='button' value='장바구니 비우기' style="color: black; background:white; font-size:14px; border-radius:0.5em; padding:5px 20px;" onclick="check1()" />
				<input type='button' value='쇼핑 계속하기' style="color: black; background:white; font-size:14px; border-radius:0.5em; padding:5px 20px;" onclick="location.href='shopMain.do?'" />
			</td>
		</tr>
</div>
</body>
<footer>
	<div class="box">
		<ul id="footer_menu">
		<li>팀장 이경훈</li>
		<li> | </li>
		<li>조원 신동찬</li>
		<li> | </li>
		<li>조원 지윤배</li>
		<li> | </li>
		<li>조원 최상휘</li>
		<li> | </li>
		<li>조원 이환규</li>
		</ul>
		<div class="footers">
			<h3>코신사 회사(주)</h3>
			<ul>
			<li>사업자 등록번호 0523</li>
			<li>대표이사 이경훈 | 서울특별시 금천구 가산동 426-5 월드 메르디앙 벤처 센터 2 차 15강의실</li>
			<li>전화 010-7758-xxxx </li>
			</ul>
		</div>
		<div class="footers">
			<h3>고객센터</h3>
			<ul>
			<li>서울특별시 금천구 가산동 426-5 월드 메르디앙 벤처 센터 2 차 15강의실</li>
			<li>전화 1234-1234</li>
			<li><span>1:1 문의 바로가기</span></li>
			</ul>
		</div>
		<div class="footers">
			<h3>전자금융거래 분쟁처리</h3>
			<ul>
			<li>전화 1234-1234</li>
			<li><span>1:1 문의 바로가기</span></li>
			</ul>
		</div>
	</div>
</footer>
</html>