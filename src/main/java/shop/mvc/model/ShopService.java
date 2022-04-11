package shop.mvc.model;
import java.util.ArrayList;

import shop.mvc.domain.*;

public class ShopService{
	private ShopDAO dao;
	//SingleTon Object Model - start!
	private static final ShopService instance = new ShopService();
	private ShopService() {
		dao = new ShopDAO();
	}
	public static ShopService getInstance() {
		return instance;
	}
	//SingleTon Object Model - end!
	
	public ArrayList<Product> listMainS(int cPage, int numPerPage){
		return dao.listMain(cPage, numPerPage);
	}
	public ArrayList<Product> listCateMainS(int cPage, int numPerPage, String cate){
		return dao.listCateMain(cPage, numPerPage, cate);
	}
	public ArrayList<Product> productS(int pnum) {
		return dao.product(pnum);
	}
	public ArrayList<Cart> cartlistS(String email) {
		return dao.cartlist(email);
	}
	public int listMainCntS(int cPage, int numPerPage) {
		return dao.listMainCnt(cPage, numPerPage);
	}
	public int memberPointS(String email) {
		return dao.memberPoint(email);
	}
	public int listCateCntS(String cate) {
		return dao.listCateCnt(cate);
	}
	public boolean loginHomeS(Member dto){
		return dao.loginHome(dto);
	}	
	public boolean insertMemS(Member dto){
		return dao.insertMem(dto);
	}
	public boolean cartInS(Cart dto) {
		return dao.cartIn(dto);
	}
	public Member selectMemS(String OEmail) {
		return dao.selectMem(OEmail);
	}
	public ArrayList<Cart> selectCartS(String OEmail,String[] cnumlist){
		return dao.selectCart(OEmail,cnumlist);
	}
	public int selectPaymentS(String OEmail,String[] cnumlist) {
		return dao.selectPayment(OEmail,cnumlist);
	}
	public ArrayList<Orders> orderInsertS(Member orderMember, ArrayList<Cart> orderCart, String name, String phone, String addr, String memo, int paycheck,int userPay){
		return dao.orderInsert(orderMember, orderCart, name, phone, addr ,memo ,paycheck,userPay);
	}
	public Orders orderInsertdrS(Member orderMember, String name, String phone, String addr, String rMemo, int paycheck ,int ccntdr, int cpricedr, String dcDetail, String dcPname, int pay,String OEmail,int dc) {
		return dao.orderInsertdr(orderMember,name,phone,addr,rMemo,paycheck,ccntdr,cpricedr,dcDetail,dcPname,pay,OEmail,dc);
	}
	public ArrayList<Orders> orderlistRS(String email){
		return dao.orderlistR(email);
	}
	public boolean delCartS(String OEmail, String[] cnumlist) {
		return dao.delCart(OEmail,cnumlist);
	}
}