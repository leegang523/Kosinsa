package shop.mvc.model;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.sql.*;
import shop.mvc.domain.*;
import shop.mvc.model.*;

class ShopDAO {
	private DataSource ds;
	public ShopDAO(){
		try{
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne){
		}
	}
	ArrayList<Product> listMain(int cPage, int numPerPage){ //메인 페이지
		ArrayList<Product> listMain = new ArrayList<Product>();
        Connection con = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = ShopSQL.SELECTMAIN;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
            pstmt.setInt(2, cPage*numPerPage);
            rs = pstmt.executeQuery();
			while(rs.next()){
				int rnum = rs.getInt(1);
				int pnum = rs.getInt(2);
				String category = rs.getString(3);
				String pname = rs.getString(4);
				int pprice = rs.getInt(5);
				int pcnt = rs.getInt(6);
				String pdetail = rs.getString(7);
				String pimage1 = rs.getString(8);
				String pimage2 = rs.getString(9);
				String pimage3 = rs.getString(10);
				String pimage4 = rs.getString(11);
				Date pdate = rs.getDate(12);
				int psell = rs.getInt(13);
				listMain.add(new Product(rnum, pnum, category, pname, pprice, pcnt, pdetail, pimage1, pimage2,pimage3,pimage4, pdate, psell));
			}
			return listMain;
		 }catch(SQLException se){
			 System.out.println("#ShopDAO listMain() se: " + se);
			 return null;
		 }finally{
			 try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			 }catch(SQLException se){}
		 }
	}
	ArrayList<Product> listCateMain(int cPage, int numPerPage, String cate){ //카테고리 클릭시 메인페이지
		ArrayList<Product> listCateMain = new ArrayList<Product>();
        Connection con = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = ShopSQL.SELECTCATEMAIN;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cate);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
            pstmt.setInt(3, cPage*numPerPage);
            
            rs = pstmt.executeQuery();
			while(rs.next()){
				int rnum = rs.getInt(1);
				int pnum = rs.getInt(2);
				String category = rs.getString(3);
				String pname = rs.getString(4);
				int pprice = rs.getInt(5);
				int pcnt = rs.getInt(6);
				String pdetail = rs.getString(7);
				String pimage1 = rs.getString(8);
				String pimage2 = rs.getString(9);
				String pimage3 = rs.getString(10);
				String pimage4 = rs.getString(11);
				Date pdate = rs.getDate(12);
				int psell = rs.getInt(13);
				listCateMain.add(new Product(rnum, pnum, category, pname, pprice, pcnt, pdetail, pimage1, pimage2,pimage3,pimage4, pdate, psell));
			}
			return listCateMain;
		 }catch(SQLException se){
			 System.out.println("#ShopDAO listCateMain() se: " + se);
			 return null;
		 }finally{
			 try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			 }catch(SQLException se){}
		 }
	}
	int listMainCnt(int cPage, int numPerPage) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int mainCnt = 0;
		String sql = ShopSQL.SELECTMAINCNT;
		try{
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				mainCnt = rs.getInt(1);
			}
			return mainCnt;
		 }catch(SQLException se){
			 System.out.println("#AddrDAO listMainCnt() se: " + se);
		 }finally{
			 try{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			 }catch(SQLException se){}
		 }
		return mainCnt;
	}
	int listCateCnt(String cate) {
		 Connection con = null;
	        PreparedStatement pstmt = null;
			ResultSet rs = null;
			int cateCnt = 0;
			String sql = ShopSQL.SELECTCATEMAINCNT;
			try{
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, cate);
            
	            rs = pstmt.executeQuery();
				while(rs.next()){
					cateCnt = rs.getInt(1);
				}
			return cateCnt;
		 }catch(SQLException se){
			 System.out.println("#AddrDAO listMainCnt() se: " + se);
		 }finally{
			 try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			 }catch(SQLException se){}
		 }
		return cateCnt;
	}
	ArrayList<Product> product(int pnum){ //카테고리 클릭시 메인페이지
		ArrayList<Product> product = new ArrayList<Product>();
        Connection con = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = ShopSQL.SELECTPRODUCT;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pnum);
            
            rs = pstmt.executeQuery();
			while(rs.next()){
				String category = rs.getString(2);
				String pname = rs.getString(3);
				int pprice = rs.getInt(4);
				int pcnt = rs.getInt(5);
				String pdetail = rs.getString(6);
				String pimage1 = rs.getString(7);
				String pimage2 = rs.getString(8);
				String pimage3 = rs.getString(9);
				String pimage4 = rs.getString(10);
				Date pdate = rs.getDate(11);
				int psell = rs.getInt(12);
				product.add(new Product(-1, pnum, category, pname, pprice, pcnt, pdetail, pimage1, pimage2, pimage3,pimage4, pdate, psell));
			}
			return product;
		 }catch(SQLException se){
			 System.out.println("#ShopDAO product() se: " + se);
			 return null;
		 }finally{
			 try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			 }catch(SQLException se){}
		 }
	}
	ArrayList<Cart> cartlist(String email){ //카트번호 구매수 구매자 제품번호
		ArrayList<Cart> cartlist = new ArrayList<Cart>();
        Connection con = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = ShopSQL.SELECTCART;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
            
            rs = pstmt.executeQuery();
			while(rs.next()){
				int cnum = rs.getInt(1);
				String cdetail = rs.getString(2);
				String cname = rs.getString(3);
				int cprice = rs.getInt(4);
				int ccnt = rs.getInt(5);
				int cartPrice = rs.getInt(6);
				String cartemail = rs.getString(7);
				int pnum = rs.getInt(8);
				cartlist.add(new Cart(cnum, cdetail, cname, cprice, ccnt, cartPrice, cartemail, pnum));
			}
			return cartlist;
		 }catch(SQLException se){
			 System.out.println("#ShopDAO product() se: " + se);
			 return null;
		 }finally{
			 try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			 }catch(SQLException se){}
		 }
	}
	public boolean loginHome(Member dto){
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = ShopSQL.SELECTMEMBER;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPw());
			int i = pstmt.executeUpdate();
			if(i>0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException se){
			System.out.println("#ShopDAO loginHome() se: "+ se);
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	public boolean insertMem(Member dto){
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = ShopSQL.INSERTMEMBER;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getAddr());
			pstmt.setDate(6, dto.getBirth());
			int i = pstmt.executeUpdate();
			if(i>0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException se){
			System.out.println("#ShopDAO insertMem() se: "+ se);
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	boolean cartIn(Cart dto){            
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = ShopSQL.CARTIN;  	// sql 부분 "insert into CART values(CART_SEQ.nextval,?,?,?,?,?,?,?)";
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getCdetail());
			pstmt.setString(2, dto.getCname());
			pstmt.setInt(3, dto.getCprice());
			pstmt.setInt(4, dto.getCcnt());
			pstmt.setInt(5, dto.getCartPrice());
			pstmt.setString(6, dto.getEmail());
			pstmt.setInt(7, dto.getPnum());
			int i = pstmt.executeUpdate();
			if(i>0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException se){
			System.out.println("#ShopDAO CartIn() se: "+ se);
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	
	Member selectMem(String OEmail) {// 회원정보 부르기
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(ShopSQL.ORDERSIN);
			pstmt.setString(1,OEmail);
			rs = pstmt.executeQuery();
				if(rs.next()) {
					//int num = rs.getInt(1);
					String pw = rs.getString(2);
					String name = rs.getString(3);
					String phone = rs.getString(4);
					String addr = rs.getString(5);
					Date rdate = rs.getDate(6);
					Date birth = rs.getDate(7);
					int point = rs.getInt(8);
					System.out.println();
					Member orderMember = new Member(OEmail, pw, name, phone, addr, rdate, birth, point);
					return orderMember;
				}else {
					return null;
				}
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	ArrayList<Cart> selectCart(String email, String[] cnumlist){ //카트번호 구매수 구매자 제품번호 카트번호를 맨앞 onum에 줘서 기본키값받게 주문번호를 만들어서 스트링입력(이메일과 + 
		ArrayList<Cart> orderCart = new ArrayList<Cart>();
        Connection con = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = ShopSQL.ORDERSIN2;
		try{
		for(String cnum: cnumlist){
			int cnumIn = -1;
			cnumIn = Integer.parseInt(cnum);
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
            pstmt.setInt(2,cnumIn);
            rs = pstmt.executeQuery();
			while(rs.next()){
				String cdetail = rs.getString(2);
				String cname = rs.getString(3);
				int cprice = rs.getInt(4);
				int ccnt = rs.getInt(5);
				int cartPrice = rs.getInt(6);
				String cartemail = rs.getString(7);
				int pnum = rs.getInt(8);
				orderCart.add(new Cart(cnumIn, cdetail, cname, cprice, ccnt, cartPrice, cartemail, pnum));
				}
			}
			return orderCart;
		 }catch(SQLException se){
			 System.out.println("#ShopDAO seleCart() se: " + se);
			 return null;
		 }finally{
			 try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			 }catch(SQLException se){}
		 }
	}
	int selectPayment(String email, String[] cnumlist){ //카트번호 구매수 구매자 제품번호
		ArrayList<Cart> orderCart = new ArrayList<Cart>();
        Connection con = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pay = 0;
		String sql = ShopSQL.ORDERSIN2;
		try{
		for(String cnum: cnumlist){
			int cnumIn = -1;
			cnumIn = Integer.parseInt(cnum);
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
            pstmt.setInt(2,cnumIn);
            rs = pstmt.executeQuery();
			while(rs.next()){
				String cdetail = rs.getString(2);
				String cname = rs.getString(3);
				int cprice = rs.getInt(4);
				int ccnt = rs.getInt(5);
				int cartPrice = rs.getInt(6);
				String cartemail = rs.getString(7);
				int pnum = rs.getInt(8);
				pay = pay +cartPrice;
				}
			}
			return pay;
		 }catch(SQLException se){
			 System.out.println("#ShopDAO selectPayment() se: " + se);
			 return pay;
		 }finally{
			 try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			 }catch(SQLException se){}
		 }
	}

	ArrayList<Orders> orderInsert(Member dto1, ArrayList<Cart> orderCart, String name, String phone, String addr, String memo ,int paycheck ,int userPay){
		int ornum = 0;
		int i=0;
		int j=0;
		ArrayList<Orders> orderlist = new ArrayList<Orders>();
		Connection con = null;
		PreparedStatement pstmt1 = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		ResultSet rs2 = null;
		String sql1 = ShopSQL.INSERTORDERS; // 기준카트를 뽑기위한 기본문 인서트
		String sql2 = ShopSQL.SELECTORDERSDATA; // 기준카트의 ornum 셀렉
		String sql3 = ShopSQL.UPDATEORDERSDATA; // 기준카트로우 업데이트
		String sql4 = ShopSQL.INSERTOERDERSDATA; // 기준카트로우와 같은 ornum의 데이터들 삽입     i이용해서 포문안에 int i = 0으로 초기화하고 if(i=0)일떄 업데이트 이후 else는 인서트로  
		String sql5 = ShopSQL.SELECTORDERS;//주문내역 출력
		String sql6 = ShopSQL.DELPOINT;
		try{
			con = ds.getConnection();
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, name);
			pstmt1.setString(2, phone);
			pstmt1.setString(3, addr);
			pstmt1.setString(4, memo);
			pstmt1.setString(5, dto1.getEmail());
			pstmt1.executeUpdate();
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery(sql2);
			while(rs1.next()){
				ornum = rs1.getInt(2);
			}
			for (Cart dto2 : orderCart)
			{
				if(i==0) {
					pstmt2 = con.prepareStatement(sql3);
					pstmt2.setInt(1, dto2.getCnum());
					pstmt2.setString(2, dto2.getCdetail());
					pstmt2.setString(3, name);
					pstmt2.setString(4, dto2.getCname());
					pstmt2.setInt(5, dto2.getCcnt());
					pstmt2.setInt(6, dto2.getCartPrice());
					pstmt2.setInt(7, dto2.getCprice());
					pstmt2.setString(8, memo);
					pstmt2.setInt(9, paycheck);
					pstmt2.setInt(10, ornum);
					pstmt2.executeUpdate();
					i=1;
				}else { 
					pstmt3 = con.prepareStatement(sql4);
					pstmt3.setInt(1, ornum);
					pstmt3.setString(2, name);
					pstmt3.setString(3, phone);
					pstmt3.setString(4, addr);
					pstmt3.setInt(5, dto2.getCnum());
					pstmt3.setString(6, dto2.getCdetail());
					pstmt3.setString(7, dto2.getCname());
					pstmt3.setInt(8, dto2.getCprice());
					pstmt3.setInt(9, dto2.getCcnt());
					pstmt3.setInt(10, dto2.getCartPrice());
					pstmt3.setInt(11, paycheck);
					pstmt3.setString(12, memo);
					pstmt3.setString(13, dto1.getEmail());
					j = pstmt3.executeUpdate();
				}
			}
			pstmt5 = con.prepareStatement(sql6);
			pstmt5.setString(2, dto1.getEmail());
			pstmt5.setInt(1, userPay);
			pstmt5.executeUpdate();
			pstmt4 = con.prepareStatement(sql5);
			pstmt4.setString(1, dto1.getEmail());
			pstmt4.setInt(2, ornum);
			rs2 = pstmt4.executeQuery();
			while(rs2.next()){
				int onum = rs2.getInt(1);
				int ornum1 = rs2.getInt(2);
				Date odate = rs2.getDate(3);
				String oname = rs2.getString(4);
				String ophone = rs2.getString(5);
				String oaddr = rs2.getString(6);
				int ocnum = rs2.getInt(7);
				String ocdetail = rs2.getString(8);
				String ocname = rs2.getString(9);
				int ocprice = rs2.getInt(10);
				int occnt = rs2.getInt(11);
				int ocartprice = rs2.getInt(12);
				int oallprice = rs2.getInt(13);
				String memo1 =rs2.getString(14);
				int oinvoice = rs2.getInt(15);
				String email = rs2.getString(16);
				orderlist.add(new Orders(onum, ornum1, odate, oname, ophone, oaddr, ocnum, ocdetail, ocname,ocprice,occnt,ocartprice,oallprice,memo1,oinvoice,email));
			}
		}catch(SQLException se){
			System.out.println("#ShopDAO orderInsert() se: "+ se);
		}finally{
			try{
				if(rs2 != null) rs2.close();
				if(pstmt4 != null) pstmt4.close();
				if(pstmt5 != null) pstmt5.close();
				if(pstmt3 != null) pstmt3.close();
				if(pstmt2 != null) pstmt2.close();
				if(rs1 != null) rs1.close();
				if(stmt1 != null) stmt1.close();
				if(pstmt1 != null) pstmt1.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
		return orderlist;
	}
	Orders orderInsertdr(Member dto1, String name, String phone, String addr, String memo ,int paycheck, int ccntdr, int cpricedr, String dcDetail, String dcPname, int pay ,String OEmail,int dc) {
		int ornum = 0;
		Connection con = null;
		PreparedStatement pstmt1 = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		ResultSet rs2 = null;
		String sql1 = ShopSQL.INSERTOERDERSDATADR; // 기준카트를 뽑기위한 기본문 인서트
		String sql2 = ShopSQL.SELECTORDERSDATA; // 기준카트의 ornum 셀렉
		String sql3 = ShopSQL.SELECTORDERS;
		String sql4 = ShopSQL.DELPOINT;
		try{
			con = ds.getConnection();
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, name);
			pstmt1.setString(2, phone);
			pstmt1.setString(3, addr);
			pstmt1.setString(4, dcDetail);
			pstmt1.setString(5, dcPname);
			pstmt1.setInt(6, cpricedr);
			pstmt1.setInt(7, ccntdr);
			pstmt1.setInt(8, pay);
			pstmt1.setInt(9, pay);
			pstmt1.setString(10, memo);
			pstmt1.setString(11, OEmail);
			pstmt1.executeUpdate();
			pstmt5 = con.prepareStatement(sql4);
			pstmt5.setString(2, OEmail);
			pstmt5.setInt(1, dc);
			pstmt5.executeUpdate();
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery(sql2);
			while(rs1.next()){
				ornum = rs1.getInt(2);
			}
			pstmt4 = con.prepareStatement(sql3);
			pstmt4.setString(1, dto1.getEmail());
			pstmt4.setInt(2, ornum);
			rs2 = pstmt4.executeQuery();
			while(rs2.next()){
				int onum = rs2.getInt(1);
				int ornum1 = rs2.getInt(2);
				Date odate = rs2.getDate(3);
				String oname = rs2.getString(4);
				String ophone = rs2.getString(5);
				String oaddr = rs2.getString(6);
				int ocnum = rs2.getInt(7);
				String ocdetail = rs2.getString(8);
				String ocname = rs2.getString(9);
				int ocprice = rs2.getInt(10);
				int occnt = rs2.getInt(11);
				int ocartprice = rs2.getInt(12);
				int oallprice = rs2.getInt(13);
				String memo1 =rs2.getString(14);
				int oinvoice = rs2.getInt(15);
				String email = rs2.getString(16);
				Orders orderlistdr = new Orders(onum, ornum1, odate, oname, ophone, oaddr, ocnum, ocdetail, ocname,ocprice,occnt,ocartprice,oallprice,memo1,oinvoice,email);
				return orderlistdr;
			}
		}catch(SQLException se){
			System.out.println("#ShopDAO orderInsert() se: "+ se);
			return null;
		}finally{
			try{
				if(rs2 != null) rs2.close();
				if(pstmt4 != null) pstmt4.close();
				if(pstmt3 != null) pstmt3.close();
				if(pstmt2 != null) pstmt2.close();
				if(rs1 != null) rs1.close();
				if(stmt1 != null) stmt1.close();
				if(pstmt5!=null) pstmt5.close();
				if(pstmt1 != null) pstmt1.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
		return null;
	}
	ArrayList<Orders> orderlistR(String email){
		ArrayList<Orders> orderlistR = new ArrayList<Orders>();
		Connection con = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		String sql1 = ShopSQL.SELECTORDERSLIST; // 기준카트를 뽑기위한 기본문 인서트
		try{
			con = ds.getConnection();
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, email);
			rs = pstmt1.executeQuery();
			while(rs.next()){
				int onum = rs.getInt(1);
				int ornum1 = rs.getInt(2);
				Date odate = rs.getDate(3);
				String oname = rs.getString(4);
				String ophone = rs.getString(5);
				String oaddr = rs.getString(6);
				int ocnum = rs.getInt(7);
				String ocdetail = rs.getString(8);
				String ocname = rs.getString(9);
				int ocprice = rs.getInt(10);
				int occnt = rs.getInt(11);
				int ocartprice = rs.getInt(12);
				int oallprice = rs.getInt(13);
				String memo1 =rs.getString(14);
				int oinvoice = rs.getInt(15);
				String email1 = rs.getString(16);
				orderlistR.add(new Orders(onum, ornum1, odate, oname, ophone, oaddr, ocnum, ocdetail, ocname,ocprice,occnt,ocartprice,oallprice,memo1,oinvoice,email1));
			}
		}catch(SQLException se){
			System.out.println("#ShopDAO orderInsert() se: "+ se);
		}finally{
			try{
				if(rs != null) rs.close();;
				if(pstmt1 != null) pstmt1.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
		return orderlistR;
	}
	int memberPoint(String email) {
		 Connection con = null;
	        PreparedStatement pstmt = null;
			ResultSet rs = null;
			int mempoint = 0;
			String sql = ShopSQL.SELECTPOINT;
			try{
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, email);
           
	            rs = pstmt.executeQuery();
				while(rs.next()){
					mempoint = rs.getInt(1);
				}
			return mempoint;
		 }catch(SQLException se){
			 System.out.println("#AddrDAO listMainCnt() se: " + se);
		 }finally{
			 try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			 }catch(SQLException se){}
		 }
		return mempoint;
	}
	boolean delCart(String OEmail, String[] cnumlist) {
        Connection con = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		int i = 0;
		String sql = ShopSQL.DELCART;
		try{
		for(String cnum: cnumlist){
			int cnumIn = -1;
			cnumIn = Integer.parseInt(cnum);
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(2, OEmail);
            pstmt.setInt(1,cnumIn);
            i = pstmt.executeUpdate();
			}
		if(i==0) {
			return false;
		}
		else {
			return true;
		}
		}catch(SQLException se){
			System.out.println("#ShopDAO selectPayment() se: " + se);
			return false;
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
//System.out.println("cdetail: "+dto.getCdetail()+"cname: "+dto.getCname()+"cprice: "+dto.getCprice()+"ccnt: "+dto.getCcnt()+"cartPrice: "+dto.getCartPrice()+"email: "+dto.getEmail()+"pnum: "+dto.getPnum());
//System.out.println(" rnum: "+ rnum +" pnum: "+pnum + " category: "+category + " pname: "+pname +" pprice: "+pprice + " pcnt: "+pcnt + " pdetail: "+pdetail + " pimage1: "+pimage1 + " pimage2: "+pimage2 + " pdate: "+pdate + " psell: "+psell);