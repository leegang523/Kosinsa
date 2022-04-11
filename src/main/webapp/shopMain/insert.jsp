<%@ page contentType="text/html;charset=utf-8" import="shop.mvc.domain.Member"%>
<%
	boolean flag = (Boolean)request.getAttribute("insertFlag");
%>
    <script>
    	if(<%=flag%>){
    		alert("회원가입 되었습니다.")
    	}else{
    		alert("입력 오류")
    	}
    	location.href='shopMain.do?m=login';
	</script>