<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, shop.mvc.domain.*"%>

<%
 
    request.setCharacterEncoding("UTF-8");
 
%>


<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>

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
<link href="css/style.css" rel="stylesheet" type="text/css">

<%
	String[] cnumberlist = (String[])request.getAttribute("cnumlist");
	int pO = (int)request.getAttribute("paymentOrder");
	Member oM = (Member)request.getAttribute("orderMember");
%>

</head>
<body>
<header>
	<div id="top">
		<div class="box">
			<div id="top_logo">
				<img src="img/logo1.png"width='50' height='50'>
			</div>
			<div id="top_ad">
				데일리 남성의류 스토어, 예쁜 레더자켓, 티셔츠, 코트, 자켓, 루즈핏 사이즈 등 판매
<%
	        // 현재 로그인된 아이디가 없다면 (= session에 저장된 id가 없다면)
	        String email = (String) session.getAttribute("EMAIL");
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
            <li><a href="">마이페이지</a></li>
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
		<h3> 주문 페이지 </h3>
		<p> 현재 내 포인트 : <%=oM.getPoint() %>포인트 </p>
		<div class="clear"></div>
	<form name="f" method="post" action="shopMain.do?m=paycheck&paycheckEmail=<%=oM.getEmail()%>&paycheck=<%=pO%>&userP=<%=oM.getPoint()%>">
	   <table border="1" width="600" align="center"  cellpadding="3" cellspacing="1">
		  <tr>
		     <td align="center">수령인</td>
			 <td align="center"><input type="text" name="name" size="60" value="<%=oM.getName()%>"></td>
		  </tr>
          <tr>
		     <td align="center">휴대전화</td>
			 <td align="center"><input type="text" name="phone" size="60"value="<%=oM.getPhone()%>"></td>
		  </tr>
		  <tr>
		     <td align="center">배송지 주소</td>
			 <td align="center"><input type="text" name="addr" size="60"value="<%=oM.getAddr()%>"></td>
		  </tr>
		  <tr>
		     <td align="center">배송 메모</td>
			 <td align="center"><input type="text" name="memo" size="60"></td>
		  </tr>
		  		<tr>
			<th>카트번호</th>
			<th>제품이미지</th>
			<th>제품이름</th>
			<th>가격 </th>
			<th>주문 수량</th>
			<th>결제 금액</th>
		</tr>
<%
ArrayList<Cart> oC = (ArrayList<Cart>)request.getAttribute("orderCart");
if(oC != null){
		if(oC.size() == 0) {
%>
		<tr align='center'>
			<td colspan= '5'>
				주문상품을 선택해주세요
				<a href= 'shopMain.do?m=main'>주문하기</a>
			</td>
		</tr>
<%
		} else {
			for(Cart dto : oC){
		%>
		<tr align= 'center'>
			<td><%=dto.getCnum() %></td>
			<td><%=dto.getCdetail() %></td>
			<td><%=dto.getCname() %></td>
			<td><%=dto.getCprice()%></td>
			<td><%=dto.getCcnt() %></td>
			<td><%=dto.getCartPrice() %></td>
		</tr>
<% 
			}
		}
}	
%>
		  <tr>
		     <td colspan="2" align="center">
				<input type="reset" value="다시입력">
				<input type="button" value="<%=pO%>원결제하기" onclick="checkValue()">
			 </td>
		  </tr>
	   </table>
	   <br>
	   <hr width="600" size="2" noshade>
	</form>
	</div>

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