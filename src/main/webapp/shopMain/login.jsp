<%@ page contentType="text/html;charset=utf-8" import="javax.sql.DataSource, java.sql.*"%>

<meta charset="utf-8">
<style>
	table, th, td {
	   border: 1px solid black;
	   border-collapse: collapse;
	}
	th, td {
	   padding: 5px;
	}
	a { text-decoration:none }
</style>
<body onload="document.f.name.focus()">
<center>
   <h1>
		KOSINSA
   </h1>
   <a href='shopMain.do'>홈페이지</a>
   <form name="f" action="shopMain.do?m=loginsite" method="post">
       <table border="1" width="300" height="200">
	      <tr>
		     <td width="30%" colspan="2" align="center"><h2>로그인창</h2></td>
		     <a href="shopMain.do?m=signup">회원가입</a>
		  </tr>
		  <tr>
		     <th width="30%">아이디</th> 
			 <td><input name="email" align="center" size="20" align="center"></td>
		  </tr>
		  <tr>
		     <th width="30%">비밀번호</th> 
			 <td><input name="pw" size="20" align="center"></td>
		  </tr>
		  <tr>
		     <td colspan="2" align="center">
			     <input type="submit" value="로그인"/>
				 <input type="reset" value="취소"/>
			 </td> 
		  </tr>
	   </table>
   </form>
</center>
</body>
