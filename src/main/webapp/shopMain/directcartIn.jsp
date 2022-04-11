<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, shop.mvc.domain.*"%>

<%
 
    request.setCharacterEncoding("UTF-8");
 
%>


<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript">
function checkValue()
{
	if(document.f.name.value == "")
	{
	  alert("수령자명을 입력해주세요");
	  return false;
	}
	if(document.f.phone.value == "")
	{
	  alert("휴대전화번호를 입력해주세요");
	  return false;
	}
	if(document.f.addr.value == "")
	{
	  alert("주소를 입력해주세요");
	  return false;
	}
	document.f.submit();
}
</script>


<%

	Member dc = (Member)request.getAttribute("dcMember");
	String dcEmail = (String)request.getAttribute("dcEmail");
	String dcPname = (String)request.getAttribute("dcPname");
	String dcDetail = (String)request.getAttribute("dcDetail");
	int dcPrice = (Integer)request.getAttribute("dcPrice");
	int dcCnt = (Integer)request.getAttribute("dcCnt");
	
	
%>

</head>
<body>
<header>
	<div id="top">
		<div class="box">
			<div id="top_logo">
				<img src="img/logo1.png"width='50' height='50'>
			</div>
			
<%
String email = (String) session.getAttribute("EMAIL");
%>
			<div id="top_ad">
				데일리 남성의류 스토어, 예쁜 레더자켓, 티셔츠, 코트, 자켓, 루즈핏 사이즈 등 판매&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; - <%=email %> 회원님 어서오세요
<%
	        // 현재 로그인된 아이디가 없다면 (= session에 저장된 id가 없다면)
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


<section id="content_box">
	<div class="box">
		<h3> [주문 페이지] </h3>
		<p> 현재 내 포인트 : <%=dc.getPoint() %>포인트 </p>
		<br>
		<br>
		<br>
		<br>
		<div class="clear"></div>
		<form name="f" method="post" action="shopMain.do?m=drpaycheck&drpaycheckEmail=<%=dc.getEmail()%>&drpaycheck=<%=dcPrice*dcCnt%>&druserP=<%=dc.getPoint()%>&dcDetail=<%=dcDetail%>&dcPname=<%=dcPname%>&cprice=<%=dcPrice%>&ccnt=<%=dcCnt%>">
	   	<div align="center">
	   <div class="join_form">
	   	<table>
	   <colgroup>
	   <col width="30%"/>
	   <col width="auto"/>
	   </colgroup>
		  <tr>
		     <td align="center">수령인</td>
			 <td align="center"><input type="text" name="name" size="60" value="<%=dc.getName()%>"></td>
		  </tr>
          <tr>
		     <td align="center">휴대전화</td>
			 <td align="center"><input type="text" name="phone" size="60"value="<%=dc.getPhone()%>"></td>
		  </tr>
		  <tr>
		     <td align="center">배송지 주소</td>
			 <td align="center"><input type="text" name="addr" size="60"value="<%=dc.getAddr()%>"></td>
		  </tr>
		  <tr>
		     <td align="center">배송 메모</td>
			 <td align="center"><input type="text" name="memo" size="60" value="메모 없음"></td>
		  </tr>
		  </table>
		  </div>
		  <br>
		  <br>
		  <br>
		  
		  <table border="1">
		  		<tr>
			<th style="background-color: #eae1d8; text-align: center;">제품이미지</th>
			<th style="background-color: #eae1d8; text-align: center;">제품이름</th>
			<th style="background-color: #eae1d8; text-align: center;">가격 </th>
			<th style="background-color: #eae1d8; text-align: center;">주문 수량</th>
			<th style="background-color: #eae1d8; text-align: center;">결제 금액</th>
		</tr>
		<th>
		<tr align= 'center'>
			<td><img><img src ='img/<%=dcDetail %>' width='100' height='100'></img></td>
			<td><%=dcPname %></td>
			<td><%=dcPrice%></td>
			<td><%=dcCnt %></td>
			<td><%=dcPrice*dcCnt %></td>
		</tr>
		</th>
		
		</table>
		<br>
		</form>
		</div>
		</div>
		  <tr>
		  <center>
				<input type="button" style="color: black; background:white; font-size:14px; border-radius:0.5em; padding:5px 20px;" value="<%=dcPrice*dcCnt%>원결제하기" onclick="checkValue()">
		</center>

	<div class="clear"></div>
</section>

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