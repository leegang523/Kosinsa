drop table MEMBER cascade constraint;
drop table PRODUCT cascade constraint;
drop table CART cascade constraint;
drop table DCART cascade constraint;
drop table ORDERS cascade constraint;
drop table ORDERS_DETAIL cascade constraint;
drop table ORDERS_NONE cascade constraint;
drop table ORDERS_NONE_DETAIL cascade constraint;
drop table REVIEW cascade constraint;
drop sequence PRODUCT_SEQ;
drop sequence CART_SEQ;
drop sequence DCART_SEQ;
drop sequence ORDERS_SEQ1;
drop sequence ORDERS_SEQ2;
drop sequence ORDERS_SEQ3;
drop sequence ORDERS_SEQ4;
drop sequence ORDERS_DETAIL_SEQ;
drop sequence ORDERS_NONE_SEQ;
drop sequence ORDERS_NONE_DETAIL_SEQ;
drop sequence REVIEW_SEQ;

create sequence PRODUCT_SEQ increment by 1 start with 1 nocache;
create sequence CART_SEQ increment by 1 start with 1 nocache;
create sequence DCART_SEQ increment by 1 start with 1 nocache;
create sequence ORDERS_SEQ1 increment by 1 start with 1 nocache;
create sequence ORDERS_SEQ2 increment by 1 start with 1 nocache;
create sequence ORDERS_SEQ3 increment by 1 start with 1 nocache;
create sequence ORDERS_SEQ4 increment by 1 start with 1 nocache;
create sequence ORDERS_DETAIL_SEQ increment by 1 start with 1 nocache;
create sequence ORDERS_NONE_SEQ increment by 1 start with 1 nocache;
create sequence ORDERS_NONE_DETAIL_SEQ increment by 1 start with 1 nocache;
create sequence REVIEW_SEQ increment by 1 start with 1 nocache;
purge RECYCLEBIN;

create table MEMBER(
   EMAIL varchar2(50) primary key,
   PW varchar2(30) not null,
   NAME varchar2(20) not null, 
   PHONE varchar2(20) not null,
   ADDR varchar2(200) not null, 
   RDATE date default SYSDATE,
   BIRTH date,
   POINT number default 1000000
); 

create table PRODUCT(
   PNUM number primary key,
   CATEGORY varchar2(30) not null,
   PNAME varchar2(100) not null, 
   PPRICE number(10) not null,
   PCNT number(10) not null,
   PDETAIL varchar2(100) not null,
   PIMAGE1 varchar2(100),
   PIMAGE2 varchar2(100),
   PIMAGE3 varchar2(100),
   PIMAGE4 varchar2(100),
   PDATE date default SYSDATE,
   PSELL number(3)
); 

create table CART(
   CNUM number primary key,
   CDETAIL varchar2(100),
   CNAME varchar2(100),
   CPRICE number(10),
   CCNT number(10),
   CARTPRICE number,
   EMAIL varchar(50) references MEMBER(EMAIL) not null,
   PNUM number references PRODUCT(PNUM) not null
);
create table DCART(
   DCNUM number primary key,
   DCDETAIL varchar2(100),
   DCNAME varchar2(100),
   DCPRICE number(10),
   DCCNT number(10),
   DCARTPRICE number,
   EMAIL varchar(50) references MEMBER(EMAIL) not null,
   PNUM number references PRODUCT(PNUM) not null
);
create table ORDERS(
   ONUM number primary key,
   ORNUM number,
   ODATE date default SYSDATE,
   ONAME varchar2(20) not null,
   OPHONE varchar2(20) not null,
   OADDR varchar2(200) not null,
   OCNUM number,
   OCDETAIL varchar2(100),
   OCNAME varchar2(100),
   OCPRICE number(10),
   OCCNT number(10),
   OCARTPRICE number,
   OPRICE number,
   MEMO varchar2(100),
   OINVOICE number not null,
   EMAIL varchar2(50) references MEMBER(EMAIL)
);

create table ORDERS_DETAIL(
   ODNUM number primary key,
   ODCNT number(3) not null,
   ODPRICE number(10) not null,
   ONUM number references ORDERS(ONUM) not null,
   PNUM number references PRODUCT(PNUM) not null
);

create table ORDERS_NONE(
   ONNUM number primary key not null,
   ONDATE date default sysdate not null,
   ONNAME varchar2(20) not null,
   ONPHONE varchar2(20) not null,
   ONADDR varchar2(200) not null,
   ONPRICE number not null,
   ONINVOICE number not null,
   ONEMAIL varchar2(50) not null
);

create table ORDERS_NONE_DETAIL(
   ONDNUM number primary key not null,
   ONDCNT number(3) not null,
   ONDPRICE number(10) not null,
   ONNUM number references ORDERS_NONE(ONNUM) not null,
   PNUM number references PRODUCT(PNUM) not null
);

create table REVIEW(
   RNUM number primary key not null,
   RNAME varchar2(20) not null,
   RTITLE varchar2(50) not null,
   RCONTENTS varchar2(300) not null,
   RPHOTO1 varchar2(50),
   RPHOTO2 varchar2(50),
   REDATE date default sysdate not null,
   PNUM number references PRODUCT(PNUM) not null
);

commit;
insert into MEMBER values('test1','1234','�׽���1','010-7758-xxxx','�����1',SYSDATE, null ,1000000 );
insert into MEMBER values('test2','1234','�׽���2','020-7758-xxxx','�����2',SYSDATE, null ,1000000 );
insert into MEMBER values('test3','1234','�׽���3','030-7758-xxxx','�����3',SYSDATE, null ,1000000 );
insert into MEMBER values('test4','1234','�׽���4','040-7758-xxxx','�����4',SYSDATE, null ,1000000 );
insert into MEMBER values('test5','1234','�׽���5','050-7758-xxxx','�����5',SYSDATE, null ,1000000 );

insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','������ �Ұ��� ��Ϸ���','152100','89','shoes.jpg','shoes(1).jpg','shoes(2).jpg','null','null',SYSDATE,14 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','ÿ�� ��Ŭ���� ��','119900','178','shoes1.jpg','shoes1(1).jpg','shoes1(2).jpg','shoes1(3).jpg','null',SYSDATE,21 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','��Ŀ�� ���� ��Ϸ���','84480','44','shoes2.jpg','shoes2(1).jpg','shoes2(2).jpg','null','null',SYSDATE,23 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','���ϼ��� ������','118150','64','shoes3.jpg','shoes3(1).jpg','shoes3(2).jpg','shoes3(3).jpg','null',SYSDATE,24 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','���� ����','148000','57','shoes4.jpg','shoes4(1).jpg','shoes4(2).jpg','shoes4(3).jpg','shoes4(4).jpg',SYSDATE,22 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','LOAFER PREMIUM','86000','42','shoes5.jpg','shoes5(1).jpg','shoes5(2).jpg','shoes5(3).jpg','shoes5(4).jpg',SYSDATE,21 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','�� ûŰ LITE SD NY','109000','95','shoes6.jpg','shoes6(1).jpg','shoes6(2).jpg','shoes6(3).jpg','shoes6(4).jpg',SYSDATE,35 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','Vol iv','292500','35','shoes7.jpg','shoes7(1).jpg','shoes7(2).jpg','shoes7(3).jpg','shoes7(4).jpg',SYSDATE,56 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','���̽����� ����','111000','87','shoes8.jpg','shoes8(1).jpg','null','null','null',SYSDATE,23 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','����Ƽ ��','59000','24','shoes9.jpg','shoes9(1).jpg','shoes9(2).jpg','shoes9(3).jpg','shoes9(4).jpg',SYSDATE,43 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','���� ������','80100','89','shoes10.jpg','shoes10(1).jpg','shoes10(2).jpg','shoes10(3).jpg','shoes10(4).jpg',SYSDATE,31 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','����ž ��Ŀ�� ����','64350','54','shoes11.jpg','shoes11(1).jpg','null','null','null',SYSDATE,7 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','8Ȧ ���� �� ����','240000','12','shoes12.jpg','shoes12(1).jpg','null','null','null',SYSDATE,8 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','��Ϸ��� ����','259000','23','shoes13.jpg','shoes13(1).jpg','shoes13(2).jpg','shoes13(3).jpg','shoes13(4).jpg',SYSDATE,5 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','���¸� ���� ������','89100','42','shoes14.jpg','shoes14(1).jpg','shoes14(2).jpg','null','null',SYSDATE,7 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','LOGAN SUEDE ����','116100','25','shoes15.jpg','shoes15(1).jpg','shoes15(2).jpg','shoes15(4).jpg','null',SYSDATE,4 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','�� Ŭ���� ����','109200','73','shoes16.jpg','shoes16(1).jpg','shoes16(2).jpg','shoes16(4).jpg','null',SYSDATE,22 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','���彦�� ������ ������','88000','45','shoes17.jpg','shoes17(1).jpg','shoes17(2).jpg','shoes17(4).jpg','null',SYSDATE,16);
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','���� ��Ŭ �轺����','70850','63','shoes18.jpg','shoes18(1).jpg','shoes18(2).jpg','null','null',SYSDATE,19 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','�Ұ��� ��Ϸ��� ����','84150','41','shoes19.jpg','shoes19(1).jpg','shoes19(2).jpg','shoes19(4).jpg','shoes19(5).jpg',SYSDATE,32 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','���κ�Ƽ �ø��ö�','38000','42','shoes20.jpg','shoes20(1.jpg)','shoes20(2).jpg','shoes20(4.jpg)','shoes20(4).jpg',SYSDATE,46 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'shoes','�������� �����̵� 5��','114300','75','shoes21.jpg','shoes21(1).jpg','shoes21(2).jpg','shoes21(4).jpg','shoes21(4).jpg',SYSDATE,26 );

insert into PRODUCT values(PRODUCT_SEQ.nextval, 'top','ȭ�� ���� ���� ��Ʈ','79000','15','top1.jpg','top1(1).jpg','top1(2).jpg','top1(3).jpg','top1(4).jpg',SYSDATE,10 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'top','���̾�� ũ��� ����Ƽ','9900','105','top2.jpg','top2(1).jpg','top2(2).jpg','top2(3).jpg','top2(4).jpg',SYSDATE,13 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'top','Traveller Oversized Sweater','31000','45','top3.jpg','top3(1).jpg','top3(2).jpg','top3(3).jpg','top3(4).jpg',SYSDATE,195);
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'top','2 TONE ARCH HOODIE GRAY','41000','35','top4.jpg','top4(1).jpg','top4(2).jpg','top4(3).jpg','top4(4).jpg',SYSDATE,196 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'top','���� ���� ������ ��','69000','200','top5.jpg','top5(1).jpg','top5(2).jpg','top5(3).jpg','top5(4).jpg',SYSDATE,190 );

insert into PRODUCT values(PRODUCT_SEQ.nextval, 'outer','M-1965 �ǽ����� �� ��ī','68900','15','outer1.jpg','outer1(1).png','outer1(2).jpg','outer1(3).jpg','outer1(4).jpg',SYSDATE,200 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'outer','�������� M-1965 �ǽ����� ��ī','72000','105','outer2.jpg','outer2(1).png','outer2(2).jpg','outer2(3).jpg','outer2(4).jpg',SYSDATE,198 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'outer','2WAY ���� �ĵ� ���� (MELANGE GREY)','51900','45','outer3.jpg','outer3(1).jpg','outer3(2).jpg','outer3(3).jpg','outer3(4).jpg',SYSDATE,197 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'outer','������ ����Ų �̱� ����','225000','35','outer4.jpg','outer4(1).jpg','outer4(2).jpg','outer4(3).jpg','outer4(4).jpg',SYSDATE,196 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'outer','���������� �� ������ BLACK','137000','200','outer5.jpg','outer5(1).jpg','outer5(2).jpg','outer5(3).jpg','outer5(4).jpg',SYSDATE,199 );

insert into PRODUCT values(PRODUCT_SEQ.nextval, 'bottom',' Deep One Tuck Sweat Pants','39000','15','bottom1.jpg','bottom1(1).jpg','bottom1(2).jpg','bottom1(3).jpg','bottom1(4).jpg',SYSDATE,201 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'bottom','���ϼ��� ���� ���̵� ��� ������','29000','105','bottom2.jpg','bottom2(1).jpg','bottom2(2).jpg','bottom2(3).jpg','bottom2(4).jpg',SYSDATE,13 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'bottom','���̵� ���� ���� (LIGHT BLUE)','38900','45','bottom3.jpg','bottom3(1).jpg','bottom3(2).jpg','bottom3(3).jpg','bottom3(4).jpg',SYSDATE,1 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'bottom',' Classic Sweat Pants [Black]','29000','35','bottom4.jpg','bottom4(1).jpg','bottom4(2).jpg','bottom4(3).jpg','bottom4(4).jpg',SYSDATE,189 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'bottom','�����۵� ���� ��� ũ�� ������','89000','200','bottom5.jpg','bottom5(1).jpg','bottom5(2).jpg','bottom5(3).jpg','bottom5(4).jpg',SYSDATE,20 );

insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','��ī�̺� ��ũ �޽�����','79000','15','bag1.png','bag1(1).png','bag1(2).png','bag3(3).png','bag3(4).png',SYSDATE,10 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','THINK PACK(����)','119000','105','bag2.png','bag2(1).png','bag2(2).png','bag2(3).png','bag2(4).png',SYSDATE,13 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','�һ��̾�Ƽ ��Ʈ��','879000','45','bag3.png','bag3(1).png','bag3(2).png','bag3(3).png','bag3(4).png',SYSDATE,1 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','���� ����Ʈ ����','169000','35','bag4.png','bag4(1).png','bag4(2).png','bag4(3).png','bag4(4).png',SYSDATE,14 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','��Ʃ��Ʈ BLACK','89000','200','bag5.png','bag5(1).png','bag5(2).png','bag5(3).png','bag5(4).png',SYSDATE,20 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','BUCKLE STRAP HOBO BAG','99000','135','bag6.png','bag6(1).png','bag6(2).png','bag6(3).png','bag6(4).png',SYSDATE,21 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','�ۼַ�Ʈ ���� ��','94000','101','bag7.png','bag7(1).png','bag7(2).png','bag7(3).png','bag7(4).png',SYSDATE,101 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','����)NM2DM15A �ּ�','117000','30','bag8.png','bag8(1).png','bag8(2).png','bag8(3).png','bag8(4).png',SYSDATE,90 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','������ ���� aaa237u','187000','34','bag9.png','bag9(1).png','bag9(2).png','bag9(3).png','bag9(4).png',SYSDATE,12 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','ACCORDION WALLET','85000','63','wallet1.png','wallet1(1).png','wallet1(2).png','wallet1(3).png','wallet1(4).png',SYSDATE,23 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','���� �÷��� ĸ ��','139000','12','cap1.jpg','cap1(1).jpg',null,null,null,SYSDATE,45 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','���� �÷��� ĸ ȭ��Ʈ','139000','21','cap2.jpg','cap2(1).jpg',null,null,null,SYSDATE,32 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','�� ���� ��� NY','39000','155','cap3.jpg','cap3(1).jpg',null,null,null,SYSDATE,11 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','���� ġ�� ���̽���ĸ','69000','102','cap4.jpg','cap4(1).jpg',null,null,null,SYSDATE,15 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','�� CKJ ���׷� ĸ','59000','234','cap5.jpg','cap5(1).jpg',null,null,null,SYSDATE,16 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','247ĳ�ù̾� ���÷�','39900','301','muffler1.jpg','muffler1(1).jpg',null,null,null,SYSDATE,17 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','�̴ϸ� ������ ������Ʈ','43000','50','belt1.jpg','belt1(1).jpg',null,null,null,SYSDATE,18 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','���� ������ ������Ʈ','29900','60','belt2.jpg','belt2(1).jpg',null,null,null,SYSDATE,19 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','CHECKBOARD MUFFLER','88000','102','muffler2.jpg','muffler2(1).jpg',null,null,null,SYSDATE,11 );
insert into PRODUCT values(PRODUCT_SEQ.nextval, 'others','������ ��Ʈ üũ ���÷�','39000','46','muffler3.jpg','muffler3(1).jpg',null,null,null,SYSDATE,123 );
commit;
