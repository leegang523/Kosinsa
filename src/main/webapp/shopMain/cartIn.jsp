<%@ page contentType="text/html;charset=utf-8" import="shop.mvc.domain.Member"%>
<%
	boolean flag = (Boolean)request.getAttribute("cartInFlag");
	String cartViewEmail = (String) session.getAttribute("EMAIL");
%>
    <script>
    	if(<%=flag%>){
    		alert("장바구니에 담겼습니다.")
    		location.href='shopMain.do?m=cartView&cartViewEmail=<%=cartViewEmail%>';
    		
    	}else{
    		alert("장바구니 오류")
    		location.href='shopMain.do?m=login';
    	}
	</script>