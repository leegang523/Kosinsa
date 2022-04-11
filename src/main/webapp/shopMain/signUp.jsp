<%@ page contentType="text/html;charset=utf-8"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script>
$(function() {
  $( "#datepicker1" ).datepicker({
    dateFormat: 'yy.mm.dd',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    dayNames: ['일','월','화','수','목','금','토'],
    dayNamesShort: ['일','월','화','수','목','금','토'],
    dayNamesMin: ['일','월','화','수','목','금','토'],
    showMonthAfterYear: true,
    changeMonth: true,
    changeYear: true,
    yearSuffix: '년'
    
  });});
</script>
<script language="javascript">
	function check()
	  {
	    if(document.input.email.value == "")
		{
			alert("이메일을 입력해주세요");
			return false;
		}
		if(document.input.pw.value == "")
		{
			alert("비번을 입력해주세요");
			return false;
		}
		if(document.input.name.value == "")
		{
			alert("이름을 입력해주세요");
			return false;
		}
		if(document.input.phone.value == "")
		{
			alert("전화번호를 입력해주세요");
			return false;
		}
		if(document.input.addr.value == "")
		{
			alert("주소를 입력해주세요");
			return false;
		}
		document.input.submit();
	  }
	</script>
	
	
 <link href="css/styleSign.css" rel="stylesheet" type="text/css">
 <head>
 
 </head>
 <div class="wrap wd668">
      <div class="container">
        <div class="form_txtInput">
         <form name="input" method="post" action="shopMain.do?m=insertMem">
          <h2 class="sub_tit_txt">KOSINSA</h2>
          <h2 class="sub_tit_txt">회원가입</h2>
          <p class="exTxt">생일 입력시 생일날 쿠폰이 지급됩니다.</p>
          <div class="join_form">
            <table>
              <colgroup>
                <col width="30%"/>
                <col width="auto"/>
              </colgroup>
              <tbody>
                <tr>
                  <th><span>이메일</span></th>
                  <td><input type="text" name="email" placeholder="이메일을 입력해주세요."></td>
                </tr>
                 <tr>
                  <th><span>비밀번호</span></th>
                  <td><input type="text" name="pw"  placeholder="비밀번호를 입력해주세요."></td>
                </tr>
                <tr>
                  <th><span>닉네임</span></th>
                  <td><input type="text" name="name" placeholder="사용하실 이름을 입력해주세요."></td>
                </tr>
                <tr>
                  <th><span>휴대폰 번호</span></th>
                  <td><input type="text" name="phone" placeholder="휴대전화번호를 입력해주세요."></td>
                </tr>
                <tr>
                  <th><span>주소</span></th>
                  <td><input type="text" name="addr" placeholder="주소를 입력해주세요."></td>
                </tr>
                <tr>
                  <th><nospan>생일</nospan></th>
                  <td><input type="text" id="datepicker1" name="rdate" placeholder="생일을 선택해주세요."></td>
                </tr>
              </tbody>
            </table>
            <div class="exform_txt"><span>표시는 필수적으로 입력해주셔야 가입이 가능합니다.</span></div>
          </div><!-- join_form E  -->
          <div class="agree_wrap">
            <div class="checkbox_wrap">
              <input type="checkbox" id="news_letter" name="news_letter" class="agree_chk">
              <label for="news_letter">[선택]뉴스레터 수신동의</label>
            </div>
            <div class="checkbox_wrap mar27">
              <input type="checkbox" id="marketing" name="marketing" class="agree_chk">
              <label for="marketing">[선택]마케팅 목적 개인정보 수집 및 이용에 대한 동의</label>
              <ul class="explan_txt">
                <li><span class="red_txt">항목 : 성별, 생년월일</span></li>
                <li>고객님께서는 위의 개인정보 및 회원정보 수정 등을 통해 추가로 수집하는 개인정보에<br/>
                  대해 동의하지 않거나 개인정보를 기재하지 않음으로써 거부하실 수 있습니다.<br/>
                  다만 이때 회원 대상 서비스가 제한될 수 있습니다.
                </li>
              </ul>
            </div>
          </div>
          <div class="btn_wrap">
            <input type="button" 
            style="color: black; background:white; font-size:14px; border-radius:0.5em; padding:5px 20px;"
            value="회원가입" onclick="check()">
          </div>
          </form>
        </div> <!-- form_txtInput E -->
      </div><!-- content E-->
    </div> <!-- container E -->