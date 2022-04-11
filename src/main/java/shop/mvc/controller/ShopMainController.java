package shop.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

import shop.mvc.domain.*;
import shop.mvc.model.ShopService;

@WebServlet("/shopMain/shopMain.do")
public class ShopMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String[] cnumlist;
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//(1)Model 핸들링 (java)
		//(2)View 지정 (jsp)
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m){
			case "main": main(request, response); break;
			case "cateMain": cateMain(request, response); break;
			case "product": product(request, response); break;
			case "login": login(request, response); break;
			case "logout": logout(request, response); break;
			case "loginsite": loginsite(request, response); break;
			case "signup": signup(request, response); break;
			case "insertMem": insertMem(request, response); break;
			case "cartIn": cartIn(request, response); break;
			case "cartView": cartView(request, response); break;
			case "ordersIn": ordersIn(request, response); break;
			case "payment": payment(request, response); break;
			case "drpayment": drpayment(request, response); break;
			case "paycheck": paycheck(request, response); break;
			case "drpaycheck": drpaycheck(request, response); break;
			case "orderlist": orderlistR(request, response); break;
			case "directcartIn": directcartIn(request, response); break;
			case "directorder": directorder(request, response); break;
			}
			}else{
				main(request, response);
		}
	}
	private void main(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int cPage; //현재 페이지를 의미
        try {
            cPage = Integer.parseInt(request.getParameter("cPage"));
        }catch (NumberFormatException e) {
            cPage = 1;
        }
        int numPerPage;//페이지당 자료수
        try {
            numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
        }catch (NumberFormatException e) {
            numPerPage = 15;
        }
        
		ShopService service = ShopService.getInstance();
		ShopService service1 = ShopService.getInstance();
		ArrayList<Product> listMain = service.listMainS(cPage,numPerPage);
		int totalMember = service1.listMainCntS(cPage, numPerPage);

        //전체페이수
        int totalPage = (int)Math.ceil((double)totalMember/numPerPage);
        //페이지바 html코드 누적변수
        String pageBar="";
        //페이지바 길이
        int pageBarSize =5;
        int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
        int pageEnd = pageNo+pageBarSize-1;
        
        if(pageNo==1) {
            pageBar +="<span>[이전]</span>";
        }else {
            pageBar += "<a href='"+request.getContextPath()+
                    "/shopMain/shopMain.do?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'>[이전]</a>";
        }
        //선택페이지 만들기
        while(!(pageNo>pageEnd || pageNo>totalPage))
        {
            if(cPage==pageNo) {
                pageBar += "<span class='cPage'>"+pageNo+"</span>";
            }else {
                pageBar += "<a href='"+request.getContextPath()+
                        "/shopMain/shopMain.do?cPage="+(pageNo)+"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
            }
            pageNo++;
        }
        //[다음] 구현
        if(pageNo>totalPage) 
        {
            pageBar += "<span>[다음]</span>";
        }else {
            pageBar +="<a href='"+request.getContextPath()+
                    "/shopMain/shopMain.do?cPage="+pageNo+"&numPerPage="+numPerPage+"'>[다음]</a>";
        }
        
        request.setAttribute("cPage", cPage);
        request.setAttribute("numPerPage", numPerPage);
        request.setAttribute("pageBar", pageBar);
		request.setAttribute("listMain" , listMain);
		//(2)View 지정 (jsp)
		String view = "main.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
		
	}
	private void cateMain(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int cPage; //현재 페이지를 의미
        try{
            cPage = Integer.parseInt(request.getParameter("cPage"));
        }catch (NumberFormatException e){
            cPage = 1;
        }
        int numPerPage;//페이지당 자료수
        try{
            numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
        }catch (NumberFormatException e){
            numPerPage = 15;
        }
        String cate = request.getParameter("category"); //상품의 종류
		ShopService service = ShopService.getInstance();
		ArrayList<Product> listCateMain = service.listCateMainS(cPage,numPerPage,cate);

		int totalMember = service.listCateCntS(cate);
        //전체페이수
        int totalPage = (int)Math.ceil((double)totalMember/numPerPage);
        //페이지바 html코드 누적변수
        String pageBar="";
        //페이지바 길이
        int pageBarSize =5;
        int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
        int pageEnd = pageNo+pageBarSize-1;
        
        if(pageNo==1) {
            pageBar +="<span>[이전]</span>";
        }else {
            pageBar += "<a href='"+request.getContextPath()+
                    "/shopMain/shopMain.do?m=cateMain&category="+cate+"&cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'>[이전]</a>";
        }
        //선택페이지 만들기
        while(!(pageNo>pageEnd || pageNo>totalPage))
        {
            if(cPage==pageNo) {
                pageBar += "<span class='cPage'>"+pageNo+"</span>";
            }else {
                pageBar += "<a href='"+request.getContextPath()+
                        "/shopMain/shopMain.do?m=cateMain&category="+cate+"&cPage="+(pageNo)+"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
            }
            pageNo++;
        }
        //[다음] 구현
        if(pageNo>totalPage) 
        {
            pageBar += "<span>[다음]</span>";
        }else {
            pageBar +="<a href='"+request.getContextPath()+
                    "/shopMain/shopMain.do?m=cateMain&category="+cate+"&cPage="+pageNo+"&numPerPage="+numPerPage+"'>[다음]</a>";
        }
        request.setAttribute("cate", cate);
        request.setAttribute("cPage", cPage);
        request.setAttribute("numPerPage", numPerPage);
        request.setAttribute("pageBar", pageBar);
		request.setAttribute("listCateMain" , listCateMain);
		//(2)View 지정 (jsp)
		String view = "cateMain.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);	
	}
	private void product(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		ShopService service = ShopService.getInstance();
		int pnum = getPnum(request); //상품번호
		int ccnt = getCcnt(request);
		ArrayList<Product> product = service.productS(pnum);
		request.setAttribute("ccnt", ccnt);
		request.setAttribute("product" , product);
		//(2)View 지정 (jsp)
		String view = "product.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
		
	}
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		response.sendRedirect("login.jsp");
	}
	private void loginsite(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		ShopService service = ShopService.getInstance();
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		Member dto = new Member(email, pw, null, null, null, null, null,1000000);
		boolean flag = service.loginHomeS(dto);
		request.setAttribute("loginFlag" , flag);	
		request.setAttribute("email", email);
		request.setAttribute("pw", pw);
		//(2)View 지정 (jsp)
		String view = "loginSite.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
	}
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		response.sendRedirect("logout.jsp");
	}
	private void insertMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		ShopService service = ShopService.getInstance();
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		Member dto = new Member(email, pw, name, phone, addr, null, null,1000000);
		boolean flag = service.insertMemS(dto);
		request.setAttribute("insertFlag", flag);
		String view = "insert.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
	}
	private void signup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		response.sendRedirect("signUp.jsp");
	}
	private void cartIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		ShopService service = ShopService.getInstance();
		String cdetail = request.getParameter("cdetail");
		String cname = request.getParameter("pname");
		String email = request.getParameter("cartemail");
		int ccnt = getCcnt(request);
		if (ccnt == -1) ccnt = 1;
		int pnum = getPnum(request);
		int cprice = getCprice(request);
		int cartPrice = ccnt*cprice;
		Cart dto = new Cart(-1, cdetail, cname, cprice, ccnt, cartPrice, email, pnum);
		boolean flag = service.cartInS(dto);
		request.setAttribute("cartInFlag", flag);
		String view = "cartIn.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
	}
	private void directcartIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		ShopService service = ShopService.getInstance();
		int dcCnt = getCcnt1(request);
		if (dcCnt == -1) dcCnt = 1;
		int dcPrice = getCprice1(request);
		String dcDetail = request.getParameter("cdetail1");
		String dcPname = request.getParameter("pname1");
		String dcEmail = request.getParameter("cartemail1");
		//int pp = dcPrice*dcCnt;
		request.setAttribute("dcEmail", dcEmail);
		//request.setAttribute("pp", pp);
		request.setAttribute("dcPname", dcPname);
		request.setAttribute("dcDetail", dcDetail);
		request.setAttribute("dcPrice", dcPrice);
		request.setAttribute("dcCnt", dcCnt);
		Member dcMember = service.selectMemS(dcEmail);
		request.setAttribute("dcMember", dcMember);
		String view = "directcartIn.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
	}
	private void cartView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		ShopService service = ShopService.getInstance();
		String cartViewEmail = request.getParameter("cartViewEmail");
		ArrayList<Cart> cartlist = service.cartlistS(cartViewEmail);
		request.setAttribute("cartlist" , cartlist);
		String view = "cartView.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
	}
	private void ordersIn(HttpServletRequest request, HttpServletResponse response)//오더카트 리스트 포문돌리고 안에 멤버는 고정으로 같은거 삽입 nextval 두개줘서 하나는 처음인서트때 뽑아서 계속 리스트만큼 포문 돌ㄹ리기
			throws ServletException, IOException{
		ShopService service = ShopService.getInstance();
		ShopService service1 = ShopService.getInstance();
		ShopService service2 = ShopService.getInstance();
		ShopService service3 = ShopService.getInstance();
		String OEmail = request.getParameter("OEmail");
		String derOrin = request.getParameter("DOR");
		cnumlist = request.getParameterValues("item");
		if (derOrin.equals("m")){
			ArrayList<Cart> orderCart = service1.selectCartS(OEmail,cnumlist);
			int payment = service2.selectPaymentS(OEmail,cnumlist);
			Member orderMember = service.selectMemS(OEmail);
			request.setAttribute("cnumlist", cnumlist);
			request.setAttribute("orderMember", orderMember);
			request.setAttribute("orderCart", orderCart);
			request.setAttribute("paymentOrder", payment);
			String view = "ordersIn.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request,response);
		}else if(derOrin.equals("d")) {
			service3.delCartS(OEmail,cnumlist);
			ArrayList<Cart> cartlist = service.cartlistS(OEmail);
			request.setAttribute("cartlist" , cartlist);
			String view = "cartView.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request,response);
		}
	}
	private void payment(HttpServletRequest request, HttpServletResponse response)//로직순서 1)email(paymentEmail)과 총금액(pay)을 받아서 멤버테이블에 업데이트함 2)이메일이랑 리스트만받아오고
			throws ServletException, IOException{
		ShopService service = ShopService.getInstance();
		ShopService service1 = ShopService.getInstance();
		ShopService service3 = ShopService.getInstance();
		ShopService service4 = ShopService.getInstance();
		String OEmail = request.getParameter("paymentEmail");
		ArrayList<Cart> orderCart = service1.selectCartS(OEmail,cnumlist);
		//int payment = service2.selectPaymentS(OEmail,cnumlist);
		Member orderMember = service.selectMemS(OEmail);
		int paycheck = getPaycheck(request); //총금액
		int userP = getUserp(request); // 유저 잔액
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String memo = request.getParameter("memo");
		if(memo == null) {memo="메모 없음";}
		int userPay = userP-paycheck; // 현재금액
		ArrayList<Orders> orderlist = service3.orderInsertS(orderMember, orderCart, name, phone, addr ,memo, paycheck,userPay);
		service4.delCartS(OEmail,cnumlist);
		request.setAttribute("orderName", name);
		request.setAttribute("orderPhone", phone);
		request.setAttribute("orderAddr", addr);
		request.setAttribute("orderMemo", memo);
		request.setAttribute("rOrderlist", orderlist);
		request.setAttribute("orderUserp", userPay);
		request.setAttribute("orderpaycheck", paycheck);
		String view = "payment.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
	}
	private void drpayment(HttpServletRequest request, HttpServletResponse response)//로직순서 1)email(paymentEmail)과 총금액(pay)을 받아서 멤버테이블에 업데이트함 2)이메일이랑 리스트만받아오고
			throws ServletException, IOException{
		ShopService service = ShopService.getInstance();
		ShopService service1 = ShopService.getInstance();
		String OEmail = request.getParameter("paymentEmail");
		int dc = getDc(request);
		Member orderMember = service.selectMemS(OEmail);
		int paycheck = getPaycheck(request); //총금액
		int userP = getUserp(request); // 유저 잔액
		int ccntdr = getCcntdr(request);
		int cpricedr = getCpricedr(request);
		String dcDetail = request.getParameter("dcDetail");
		String dcPname = request.getParameter("dcPname");
		int pay = ccntdr * cpricedr ;
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String memo = request.getParameter("memo");
		String rMemo = null;
		if(memo == null) {rMemo="메모 없음";}
		int userPay = userP-paycheck;
		Orders orderlistdr = service1.orderInsertdrS(orderMember, name, phone, addr ,rMemo, paycheck, ccntdr, cpricedr, dcDetail, dcPname, pay,OEmail,dc);
		response.setContentType("text/html;charset=utf-8");
		//service.pointdel(OEmail,pay);
		request.setAttribute("orderNamedr", name);
		request.setAttribute("orderPhonedr", phone);
		request.setAttribute("orderAddrdr", addr);
		request.setAttribute("orderMemodr", memo);
		request.setAttribute("rOrderlistdr", orderlistdr);
		request.setAttribute("orderUserpdr", userPay);
		request.setAttribute("drlastpay", pay);
		String view = "drpayment.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
	}
	private void paycheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String email = request.getParameter("paycheckEmail");
		int paycheck = getPaycheck(request); //총금액
		int userP = getUserp(request); // 유저 잔액
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String memo = request.getParameter("memo");
		request.setAttribute("checkemail", email);
		request.setAttribute("checkpaycheck" , paycheck);
		request.setAttribute("checkname", name);
		request.setAttribute("checkuseP" , userP);
		request.setAttribute("checkphone", phone);
		request.setAttribute("checkmemo" , memo);
		request.setAttribute("checkaddr" , addr);
		
		String view = "paycheck.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
		
	}
	private void drpaycheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String email = request.getParameter("paycheckEmail");
		int paycheck = getPaycheckdr(request); //총금액
		int userP = getUserpdr(request); // 유저 잔액
		int ccntdr = getCcnt(request);
		int cpricedr = getCprice(request);
		int drpay = ccntdr*cpricedr;
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String memo = request.getParameter("memo");
		String dcDetail = request.getParameter("dcDetail");
		String dcPname = request.getParameter("dcPname");
		request.setAttribute("drpay", drpay);
		request.setAttribute("ccntdr", ccntdr);
		request.setAttribute("cpricedr" , cpricedr);
		request.setAttribute("dcDetail", dcDetail);
		request.setAttribute("dcPname" , dcPname);
		request.setAttribute("drcheckemail", email);
		request.setAttribute("drcheckpaycheck" , paycheck);
		request.setAttribute("drcheckname", name);
		request.setAttribute("drcheckuseP" , userP);
		request.setAttribute("drcheckphone", phone);
		request.setAttribute("drcheckmemo" , memo);
		request.setAttribute("drcheckaddr" , addr);
		
		String view = "drpaycheck.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
		
	}
	private void orderlistR(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		ShopService service = ShopService.getInstance();
		ShopService service1 = ShopService.getInstance();
		String email = request.getParameter("olEmail");
		ArrayList<Orders> orderlistR = service.orderlistRS(email);
		int memPoint = service1.memberPointS(email);
		request.setAttribute("memPointol", memPoint);
		request.setAttribute("rOrderlistR", orderlistR);
		
		String view = "orderlist.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
		
	}
	private void directorder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String email = request.getParameter("paycheckEmail");
		int paycheck = getPaycheck(request); //총금액
		int userP = getUserp(request); // 유저 잔액
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String memo = request.getParameter("memo");
		request.setAttribute("checkemail", email);
		request.setAttribute("checkpaycheck" , paycheck);
		request.setAttribute("checkname", name);
		request.setAttribute("checkuseP" , userP);
		request.setAttribute("checkphone", phone);
		request.setAttribute("checkmemo" , memo);
		request.setAttribute("checkaddr" , addr);
		
		String view = "orderlist.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
		
	}

	private int getDc(HttpServletRequest request){
        int drpaychecking = -1; 
		String numStr = request.getParameter("drpaychecking");
		if(numStr != null){
			numStr = numStr.trim();
			if(numStr.length() != 0){
				try{
					drpaychecking = Integer.parseInt(numStr); 
					return drpaychecking;
				}catch(NumberFormatException ne){
				}
			}
		}
		return drpaychecking;
	}
	private int getCcntdr(HttpServletRequest request){
        int ccntdr = -1; 
		String numStr = request.getParameter("ccntdr");
		if(numStr != null){
			numStr = numStr.trim();
			if(numStr.length() != 0){
				try{
					ccntdr = Integer.parseInt(numStr); 
					return ccntdr;
				}catch(NumberFormatException ne){
				}
			}
		}
		return ccntdr;
	}
	private int getCpricedr(HttpServletRequest request){
        int cpricedr = -1; 
		String numStr = request.getParameter("cpricedr");
		if(numStr != null){
			numStr = numStr.trim();
			if(numStr.length() != 0){
				try{
					cpricedr = Integer.parseInt(numStr); 
					return cpricedr;
				}catch(NumberFormatException ne){
				}
			}
		}
		return cpricedr;
	}
	private int getPaycheck(HttpServletRequest request){
        int paycheck = -1; 
		String numStr = request.getParameter("paycheck");
		if(numStr != null){
			numStr = numStr.trim();
			if(numStr.length() != 0){
				try{
					paycheck = Integer.parseInt(numStr); 
					return paycheck;
				}catch(NumberFormatException ne){
				}
			}
		}
		return paycheck;
	}
	private int getUserp(HttpServletRequest request){
        int userP = -1; 
		String numStr = request.getParameter("userP");
		if(numStr != null){
			numStr = numStr.trim();
			if(numStr.length() != 0){
				try{
					userP = Integer.parseInt(numStr); 
					return userP;
				}catch(NumberFormatException ne){
				}
			}
		}
		return userP;
	}
	private int getPaycheckdr(HttpServletRequest request){
        int paycheck = -1; 
		String numStr = request.getParameter("drpaycheck");
		if(numStr != null){
			numStr = numStr.trim();
			if(numStr.length() != 0){
				try{
					paycheck = Integer.parseInt(numStr); 
					return paycheck;
				}catch(NumberFormatException ne){
				}
			}
		}
		return paycheck;
	}
	private int getUserpdr(HttpServletRequest request){
        int userP = -1; 
		String numStr = request.getParameter("druserP");
		if(numStr != null){
			numStr = numStr.trim();
			if(numStr.length() != 0){
				try{
					userP = Integer.parseInt(numStr); 
					return userP;
				}catch(NumberFormatException ne){
				}
			}
		}
		return userP;
	}
	private int getCprice(HttpServletRequest request){
        int cprice = -1;
		String numStr = request.getParameter("cprice");
		if(numStr != null){
			numStr = numStr.trim();
			if(numStr.length() != 0){
				try{
					cprice = Integer.parseInt(numStr); 
					return cprice;
				}catch(NumberFormatException ne){
				}
			}
		}
		return cprice;
	}
	private int getCprice1(HttpServletRequest request){
        int cprice = -1;
		String numStr = request.getParameter("cprice1");
		if(numStr != null){
			numStr = numStr.trim();
			if(numStr.length() != 0){
				try{
					cprice = Integer.parseInt(numStr); 
					return cprice;
				}catch(NumberFormatException ne){
				}
			}
		}
		return cprice;
	}
	private int getCcnt(HttpServletRequest request){
        int ccnt = -1;
		String numStr = request.getParameter("ccnt");
		if(numStr != null){
			numStr = numStr.trim();
			if(numStr.length() != 0){
				try{
					ccnt = Integer.parseInt(numStr); 
					return ccnt;
				}catch(NumberFormatException ne){
				}
			}
		}
		return ccnt;
	}
	private int getCcnt1(HttpServletRequest request){
        int ccnt1 = -1;
		String numStr = request.getParameter("ccnt1");
		if(numStr != null){
			numStr = numStr.trim();
			if(numStr.length() != 0){
				try{
					ccnt1 = Integer.parseInt(numStr); 
					return ccnt1;
				}catch(NumberFormatException ne){
				}
			}
		}
		return ccnt1;
	}
	private int getPnum(HttpServletRequest request){
        int pnum = -1;
		String numStr = request.getParameter("pnum");
		if(numStr != null){
			numStr = numStr.trim();
			if(numStr.length() != 0){
				try{
					pnum = Integer.parseInt(numStr); 
					return pnum;
				}catch(NumberFormatException ne){
				}
			}
		}
		return pnum;
	}
}
