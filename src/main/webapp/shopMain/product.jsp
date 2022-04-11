<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, shop.mvc.domain.Product"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<script language="javascript">
function removeCheck() {
	 if (confirm("정말 삭제하시겠습니까??") == true){    //확인
	     document.removefrm.submit();
	 }else{   //취소
	     return false;
	 }
	}
	</script>
<link href="css/styleP.css" rel="stylesheet" type="text/css">
<%
String email = (String) session.getAttribute("EMAIL");
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
				데일리 남성의류 스토어, 예쁜 레더자켓, 티셔츠, 코트, 자켓, 루즈핏 사이즈 등 판매&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<%
	        // 현재 로그인된 아이디가 없다면 (= session에 저장된 id가 없다면)
	        if(email == null) {
%>
            <li><a href="shopMain.do?m=signup">회원가입</a></li>
            <li><a href="shopMain.do?m=login">로그인</a></li>
            <li><a href="shopMain.do?m=cartView&cartViewEmail=<%=email%>">장바구니</a></li>
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
<%
ArrayList<Product> listCateMain = (ArrayList<Product>)request.getAttribute("product");
if(listCateMain != null){
	int size = listCateMain.size();
	if(size == 0){
%>	
<section id="content_box">
	<div class="box">
		<h3>상품 오류</h3>
		<p> 아직 미사용 부분</p>
		<div class="clear"></div>

		<tr>
			<td colspan="5" style ="text-align:center"> 데이터가 하나도 없음</td>
		<tr>
<%
	}else{
		for(Product dto : listCateMain){
%>
<section id="content_box">
	<div class="box">
		<h3><%=dto.getPname() %></h3>
		<p> 아직 미사용 부분</p>
		<div class="clear"></div>
		<ul class="info">
		<li class="b"><%=dto.getPprice() %>원 <span>할인가</span></li>
		<br>
		<li class="b">수량선택</li>
		<form name="f"  method="post" action="shopMain.do?m=product&pnum=<%=dto.getPnum()%>">
		  <select name="ccnt" onChange="submit()">
            <option value=1>1개</option>
			<option value=2>2개</option>
			<option value=3>3개</option>
			<option value=4>4개</option>
		  </select>
		</form>
		<%
		int ccnt = (Integer)request.getAttribute("ccnt");
		%>	
		<br>
			<li class="b"><span><a href="shopMain.do?m=cartIn&pnum=<%=dto.getPnum()%>&cartemail=<%=email%>&ccnt=<%=ccnt%>&cprice=<%=dto.getPprice() %>&cdetail=<%=dto.getPdetail() %>&pname=<%=dto.getPname() %>">  장바구니담기</a></span></li>
		<br>	
			<li class="b"><span><a href="shopMain.do?m=directcartIn&pnum1=<%=dto.getPnum()%>&cartemail1=<%=email%>&ccnt1=<%=ccnt%>&cprice1=<%=dto.getPprice() %>&cdetail1=<%=dto.getPdetail() %>&pname1=<%=dto.getPname() %>">  바로구매</a></span></li>
		</ul>
		<ul class="items">
			<li><img src='img/<%=dto.getPdetail() %>'></li>
			<li><img src='img/<%=dto.getPimage1() %>'></li>
			<li><img src='img/<%=dto.getPimage2() %>'></li>
		</ul>
<%
		}
	}
}

%>						
	</div>

	<div class="clear"></div>
</section>
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