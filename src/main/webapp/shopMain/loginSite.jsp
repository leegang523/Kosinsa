<%@ page contentType="text/html;charset=utf-8" import="shop.mvc.domain.Member"%>
<%
	boolean flag = (Boolean)request.getAttribute("loginFlag");
	String email = (String)request.getAttribute("email");
	String pw = (String)request.getAttribute("pw");
%>	
    <script>
    	if(<%=flag%>){
    		alert("로그인 성공 (MV)")
<%
			session.setAttribute("EMAIL", email);
			session.setAttribute("PW", pw);
%>
    		location.href='shopMain.do?m=main&email=<%=email%>';
    	}else{
    		alert("로그인 실패 (MV)")
    		location.href='shop.do?m=login';
    	}
	</script>