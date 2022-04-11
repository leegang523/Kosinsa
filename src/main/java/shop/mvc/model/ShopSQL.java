package shop.mvc.model;

class ShopSQL {
	static final String SELECTMAIN = "SELECT * FROM (SELECT ROWNUM AS RNUM, V.* FROM ( SELECT * FROM PRODUCT ORDER BY PSELL desc ) V ) V  WHERE RNUM BETWEEN ? AND ?";
	static final String SELECTMAINCNT = "SELECT COUNT(*) FROM( SELECT * from PRODUCT )";
	static final String SELECTCATEMAIN = "SELECT * FROM (SELECT ROWNUM AS RNUM, V.* FROM ( select * from PRODUCT where category = ? order by psell desc ) V ) V  WHERE RNUM BETWEEN ? AND ?";
	static final String SELECTCATEMAINCNT = "SELECT COUNT(*) FROM( SELECT * from PRODUCT where category = ? )";
	static final String SELECTPRODUCT = "SELECT * FROM PRODUCT where PNUM = ?";
	static final String CARTIN = "insert into CART values(CART_SEQ.nextval,?,?,?,?,?,?,?)";
	static final String CARTSEL = "select * from CART where EMAIL = ?";
	static final String SELECTMEMBER = "select * from MEMBER where EMAIL=? and PW=?";
	static final String INSERTMEMBER ="insert into MEMBER values(?, ?, ?, ?, ?, SYSDATE, ?, 1000000)";
	static final String SELECTCART = "select * from cart where EMAIL = ? order by CNUM";
	static final String ORDERSIN = "select * from MEMBER where EMAIL = ?";
	static final String ORDERSIN2 = "select * from cart where EMAIL = ? and CNUM = ? order by CNUM";
	static final String INSERTORDERS = "insert into ORDERS values(ORDERS_SEQ1.NEXTVAL, ORDERS_SEQ2.NEXTVAL, SYSDATE , ?, ?, ?, -1, NULL, NULL, -1,-1,-1,-1, ?, -1, ?)";
	static final String SELECTORDERSDATA = "select * from ORDERS order by ONUM";
	static final String UPDATEORDERSDATA = "update ORDERS set OCNUM=?, OCDETAIL=?, ONAME=?, OCNAME=?, OCCNT=?, OCARTPRICE=?, OCPRICE=?, MEMO=?, OPRICE = ?,OINVOICE=ORDERS_SEQ3.NEXTVAL where ORNUM=?";
	static final String INSERTOERDERSDATA = "insert into ORDERS values(ORDERS_SEQ1.NEXTVAL, ?,SYSDATE, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ORDERS_SEQ3.NEXTVAL , ?)";
	static final String INSERTOERDERSDATADR = "insert into ORDERS values(ORDERS_SEQ1.NEXTVAL, ORDERS_SEQ2.NEXTVAL ,SYSDATE, ?, ?, ?,ORDERS_SEQ4.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ORDERS_SEQ3.NEXTVAL , ?)";
	static final String SELECTORDERS = "select * from orders where EMAIL = ? and ORNUM = ?";
	static final String DELPOINT = "update MEMBER set POINT= ? where EMAIL = ?";
	static final String SELECTORDERSLIST = "select * from ORDERS where EMAIL = ? order by ORNUM , ONUM";
	static final String SELECTPOINT = "select POINT from MEMBER where EMAIL = ?";
	static final String DELCART = "delete from CART where CNUM = ? and EMAIL = ?";

}