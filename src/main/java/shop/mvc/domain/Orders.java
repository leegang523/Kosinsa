package shop.mvc.domain;

import java.sql.Date;

public class Orders {
	private int onum;
	private int ornum;
	private Date odate;
	private String oname;
	private String ophone;
	private String oaddr;
	private int ocnum;
	private String ocdetail;
	private String ocname;
	private int ocprice;
	private int occnt;
	private int ocartprice;
	private int oallprice;
	private String memo;
	private int oinvoice;
	private String email;
	public Orders(int onum, int ornum, Date odate, String oname, String ophone, String oaddr, int ocnum, String ocdetail,
			String ocname, int ocprice, int occnt, int ocartprice, int oallprice, String memo, int oinvoice, String email) {
		super();
		this.onum = onum;
		this.ornum=ornum;
		this.odate = odate;
		this.oname = oname;
		this.ophone = ophone;
		this.oaddr = oaddr;
		this.ocnum = ocnum;
		this.ocdetail = ocdetail;
		this.ocname = ocname;
		this.ocprice = ocprice;
		this.occnt = occnt;
		this.ocartprice = ocartprice;
		this.oallprice = oallprice;
		this.memo = memo;
		this.oinvoice = oinvoice;
		this.email = email;
	}
	public int getOrnum() {
		return ornum;
	}
	public void setOrnum(int ornum) {
		this.ornum = ornum;
	}
	public int getOnum() {
		return onum;
	}
	public void setOnum(int onum) {
		this.onum = onum;
	}
	public Date getOdate() {
		return odate;
	}
	public void setOdate(Date odate) {
		this.odate = odate;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getOphone() {
		return ophone;
	}
	public void setOphone(String ophone) {
		this.ophone = ophone;
	}
	public String getOaddr() {
		return oaddr;
	}
	public void setOaddr(String oaddr) {
		this.oaddr = oaddr;
	}
	public int getOcnum() {
		return ocnum;
	}
	public void setOcnum(int ocnum) {
		this.ocnum = ocnum;
	}
	public String getOcdetail() {
		return ocdetail;
	}
	public void setOcdetail(String ocdetail) {
		this.ocdetail = ocdetail;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getOcname() {
		return ocname;
	}
	public void setOcname(String ocname) {
		this.ocname = ocname;
	}
	public int getOcprice() {
		return ocprice;
	}
	public void setOcprice(int ocprice) {
		this.ocprice = ocprice;
	}
	public int getOccnt() {
		return occnt;
	}
	public void setOccnt(int occnt) {
		this.occnt = occnt;
	}
	public int getOcartprice() {
		return ocartprice;
	}
	public void setOcartprice(int ocartprice) {
		this.ocartprice = ocartprice;
	}
	public int getOallprice() {
		return oallprice;
	}
	public void setOallprice(int oallprice) {
		this.oallprice = oallprice;
	}
	public int getOinvoice() {
		return oinvoice;
	}
	public void setOinvoice(int oinvoice) {
		this.oinvoice = oinvoice;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
