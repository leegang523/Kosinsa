<%@ page contentType="text/html;charset=utf-8" import="shop.mvc.domain.*"%>
<%	
String email = (String) session.getAttribute("EMAIL");
	String dcDetail = (String)request.getAttribute("dcDetail");
	String dcPname = (String)request.getAttribute("dcPname");
	String checkemail = (String)request.getAttribute("drcheckemail");
	String checkname = (String)request.getAttribute("drcheckname");
	String checkphone = (String)request.getAttribute("drcheckphone");
	String checkmemo = (String)request.getAttribute("drcheckmemo");
	String checkaddr = (String)request.getAttribute("drcheckaddr");
	int checkpaycheck = (Integer)request.getAttribute("drcheckpaycheck");
	int checkuserP = (Integer)request.getAttribute("drcheckuseP");
	int drpay = (Integer)request.getAttribute("drpay");
	int ccntdr = (Integer)request.getAttribute("ccntdr");
	int cpricedr = (Integer)request.getAttribute("cpricedr");
	boolean flag = (checkuserP-checkpaycheck > 0);
%>
<script>
    	if(<%=flag%>){  
    		location.href='shopMain.do?m=drpayment&drpaychecking=<%=checkuserP-checkpaycheck%>&ccntdr=<%=ccntdr%>&cpricedr=<%=cpricedr%>&dcDetail=<%=dcDetail%>&dcPname=<%=dcPname%>&drpay=<%=drpay%>&paymentEmail=<%=email%>&name=<%=checkname%>&phone=<%=checkphone%>&addr=<%=checkaddr%>&memo=<%=checkmemo%>&paycheck=<%=checkpaycheck%>&userP<%=checkuserP%>';
    	}else{
    		alert("금액이 부족합니다")
    		location.href='shopMain.do?';
    	}
</script>