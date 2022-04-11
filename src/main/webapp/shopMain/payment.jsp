<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, shop.mvc.domain.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title> KOSINSA </title> 
	<link href="css/style.css" rel="stylesheet" type="text/css">
</head> 

</head>
<body>
<header>
	<div id="top">
		<div class="box">
			<div id="top_logo">
				<img src="img/logo1.png"width='50' height='50'>
				</div>
<%			
ArrayList<Orders> ol = (ArrayList<Orders>)request.getAttribute("rOrderlist");
String orderName = (String)request.getAttribute("orderName");
String orderPhone = (String)request.getAttribute("orderPhone");
String orderAddr = (String)request.getAttribute("orderAddr");
String orderMemo = (String)request.getAttribute("orderMemo");
int checkpaycheck = (Integer)request.getAttribute("orderpaycheck");
int checkuseP = (Integer)request.getAttribute("orderUserp");
      String email = (String) session.getAttribute("EMAIL"); // 현재 로그인된 아이디가 없다면 (= session에 저장된 id가 없다면)
	        %>
	        
	        <div id="top_ad">
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

<div class="container"> 
<br>
<br>
<br>
<br>
<br>
<h1>주문 내역</h1> 
<br>
<fieldset> <legend>&nbsp;수령자 정보 &nbsp;</legend>
<ul>
<li>
<br> 
<label for="uname" class="title">&nbsp; 이름</label>
<a><%=orderName %></a> 
</li> 
<li> 
<label for="tel1" class="title">&nbsp; 연락처</label> 
<a><%=orderPhone %></a>
</li>
<li> 
<label for="tel1" class="title">&nbsp; 주소</label> 
<a><%=orderAddr %></a>
</li> 
</ul> 
</fieldset>
<%
int i = 0;
if(ol != null){
for(Orders dto : ol){
	if(i==0){
%>
		<fieldset> <legend>&nbsp;배송 정보 &nbsp;</legend>
		<ul>
		<li>
		<img><img src='img/<%=dto.getOcdetail()%>'width='100' height='100'></img>
		</li>
		<li>
		<label for="uname" class="title">&nbsp; 제품명</label> 
		<a><%=dto.getOcname() %></a>
		</li> 
		<li> 
		<label for="tel1" class="title">&nbsp; 가격</label> 
		<a><%=dto.getOcprice() %></a>
		</li>
		<li> 
		<label for="tel1" class="title">&nbsp; 수량</label> 
		<a><%=dto.getOccnt() %></a>
		</li>
		<li> 
		<label for="tel1" class="title">&nbsp; 합계</label> 
		<a><%=dto.getOcartprice() %></a>
		</li> 
		</ul>
		</fieldset>
<%		
		i=1;
		}
	else{
		%>
		<fieldset>
		<ul>
		<li>
		<br>
		<li>
		<img><img src='img/<%=dto.getOcdetail()%>'width='100' height='100'></img>
		</li>
		<li>
		<label for="uname" class="title">&nbsp; 제품명</label> 
		<a><%=dto.getOcname() %></a>
		</li> 
		<li> 
		<label for="tel1" class="title">&nbsp; 가격</label> 
		<a><%=dto.getOcprice() %></a>
		</li>
		<li> 
		<label for="tel1" class="title">&nbsp; 수량</label> 
		<a><%=dto.getOccnt() %></a>
		</li>
		<li> 
		<label for="tel1" class="title">&nbsp; 합계</label> 
		<a><%=dto.getOcartprice() %></a>
		</li> 
		</ul>
		</fieldset>
		<%	
	}
	}
}
%>
<fieldset>
<ul> 
<br>
<li> 
<label for="uname" class="title">&nbsp; 배송메모</label> 
<a><%=orderMemo%></a>
</li>
<li>
<label for="tel1" class="title">&nbsp; 결제금액</label> 
<a><%=checkpaycheck%></a>
</li>
</ul>
</fieldset>
<br> 
<div class="centered"> 
<button type="button" style="color: black; background:white; font-size:14px; border-radius:0.5em; padding:5px 20px;" onclick="location.href='shopMain.do?m=orderlist&olEmail=<%=email%>'">전체 주문 내역보기</button>
<button type="button" style="color: black; background:white; font-size:14px; border-radius:0.5em; padding:5px 20px;" onclick="location.href='shopMain.do?' ">쇼핑 계속하기</button>
</div> 
</div> 
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
</body> 
</html>
