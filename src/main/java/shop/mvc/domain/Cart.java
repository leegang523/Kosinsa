package shop.mvc.domain;

public class Cart {
	private int cnum;
	private String cdetail;
	private String cname;
	private int cprice;
	private int ccnt;
	private int cartPrice;
	private String email;
	private int pnum;
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getCdetail() {
		return cdetail;
	}
	public void setCdetail(String cdetail) {
		this.cdetail = cdetail;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	public int getCcnt() {
		return ccnt;
	}
	public void setCcnt(int ccnt) {
		this.ccnt = ccnt;
	}
	public int getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(int cartPrice) {
		this.cartPrice = cartPrice;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public Cart(int cnum, String cdetail, String cname, int cprice, int ccnt, int cartPrice, String email, int pnum) {
		super();
		this.cnum = cnum;
		this.cdetail = cdetail;
		this.cname = cname;
		this.cprice = cprice;
		this.ccnt = ccnt;
		this.cartPrice = cartPrice;
		this.email = email;
		this.pnum = pnum;
	}
	
}
