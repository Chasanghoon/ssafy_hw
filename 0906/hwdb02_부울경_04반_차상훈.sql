use hwdb02_부울경_04반_차상훈;

-- 1. 상품정보를 저장할 수 있는 테이블 구성
create table producttable(
		productid varchar(16),
        productname varchar(16),
        productprice int,
        primary key(productid)
);

-- 2. 상품 데이터를 5개 이상 저장하는 SQL 작성(Tv 3개, Notebook 3개)
insert into producttable(productid, productname, productprice) values('T001', 'TV1', 3000000);
insert into producttable(productid, productname, productprice) values('T002', 'TV2', 2700000);
insert into producttable(productid, productname, productprice) values('T003', 'TV3', 2800000);

insert into producttable(productid, productname, productprice) values('N001', 'Notebook1', 3200000);
insert into producttable(productid, productname, productprice) values('N002', 'Notebook2', 2600000);
insert into producttable(productid, productname, productprice) values('N003', 'Notebook3', 2500000);

select * from producttable;

-- 3. 15% 인하된 가격의 상품 정보를 출력
select productid, (productprice * 0.85) as 'productprice 15% down' from producttable;
select productid, truncate((productprice * 0.85),0) as 'productprice 15% down' from producttable;

-- 4. TV 관련 상품의 가격 20% 인하하여 저장 후 그 결과 출력
update producttable set productprice=truncate((productprice * 0.8),0) where productid like 'T%';
select * from producttable;

-- 5. 상품 가격의 총 금액을 출력
select sum(productprice) as '총 금액' from producttable;