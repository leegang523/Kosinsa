package shop.mvc.domain;
import java.sql.Date;

public class Member {
	private String email;
	private String pw;
	private String name;
	private String phone;
	private String addr;
	private Date rdate;
	private Date birth;
	private int point;
	public Member(String email, String pw, String name, String phone, String addr, Date rdate, Date birth, int point) {
		super();
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.rdate = rdate;
		this.birth = birth;
		this.point = point;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	} 
}
