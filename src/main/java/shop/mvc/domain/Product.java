package shop.mvc.domain;
import java.sql.Date;

public class Product {
	private int rnum;
	private int pnum; //제품번호
	private String category; //제품 종류(아우터 등등)
	private String pname; //제품이름
	private int pprice; //가격
	private int pcnt; //재고량
	private String pdetail; //상세컷(지금은 아이콘이미지)
	private String pimage1;
	private String pimage2;
	private String pimage3;
	private String pimage4;
	private Date pdate;//등록일
	private int psell;//판매량
	public Product(int rnum, int pnum, String category, String pname, int pprice, int pcnt, String pdetail, String pimage1,
			String pimage2,String pimage3,String pimage4, Date pdate, int psell) {
		super();
		this.rnum = rnum;
		this.pnum = pnum;
		this.category = category;
		this.pname = pname;
		this.pprice = pprice;
		this.pcnt = pcnt;
		this.pdetail = pdetail;
		this.pimage1 = pimage1;
		this.pimage2 = pimage2;
		this.pimage3 = pimage3;
		this.pimage4 = pimage4;
		this.pdate = pdate;
		this.psell = psell;
	}
	public int getRnum() {
		return pnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPcnt() {
		return pcnt;
	}
	public void setPcnt(int pcnt) {
		this.pcnt = pcnt;
	}
	public String getPdetail() {
		return pdetail;
	}
	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}
	public String getPimage1() {
		return pimage1;
	}
	public void setPimage1(String pimage1) {
		this.pimage1 = pimage1;
	}
	public String getPimage2() {
		return pimage2;
	}
	public void setPimage2(String pimage2) {
		this.pimage2 = pimage2;
	}
	public String getPimage3() {
		return pimage3;
	}
	public void setPimage3(String pimage3) {
		this.pimage3 = pimage3;
	}
	public String getPimage4() {
		return pimage4;
	}
	public void setPimage4(String pimage4) {
		this.pimage4 = pimage4;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getPsell() {
		return psell;
	}
	public void setPsell(int psell) {
		this.psell = psell;
	}
}
