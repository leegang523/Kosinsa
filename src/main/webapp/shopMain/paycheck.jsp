<%@ page contentType="text/html;charset=utf-8" import="shop.mvc.domain.*"%>
<%
	String checkemail = (String)request.getAttribute("checkemail");
	String checkname = (String)request.getAttribute("checkname");
	String checkphone = (String)request.getAttribute("checkphone");
	String checkmemo = (String)request.getAttribute("checkmemo");
	String checkaddr = (String)request.getAttribute("checkaddr");
	int checkpaycheck = (Integer)request.getAttribute("checkpaycheck");
	int checkuserP = (Integer)request.getAttribute("checkuseP");
	boolean flag = (checkuserP-checkpaycheck > 0);
%>
<script>
    	if(<%=flag%>){
    		location.href='shopMain.do?m=payment&paymentEmail=<%=checkemail%>&name=<%=checkname%>&phone=<%=checkphone%>&addr=<%=checkaddr%>&memo=<%=checkmemo%>&paycheck=<%=checkpaycheck%>&userP=<%=checkuserP%>';
    	}else{
    		alert("금액이 부족합니다")
    		location.href='shopMain.do?';
    	}
</script>