create table board(
	no bigint primary key auto_increment,
	subject varchar(255) not NULL,
	content text not null,
	writer varchar(255) not NULL,
	read_count int default 0,
	user_ip varchar(255) not NULL,
	created_date timestamp default current_timestamp(),
	updated_date timestamp default current_timestamp() on update current_timestamp()
	
);
create table reply(
	no bigint primary key auto_increment,
	content text not null,
	writer varchar(255) not NULL,
	read_count int default 0,
	created_date timestamp default current_timestamp(),
	updated_date timestamp default current_timestamp() on update CURRENT_TIMESTAMP(),
	board_no BIGINT NOT NULL,
	CONSTRAINT reply_board_fk FOREIGN KEY(board_no) REFERENCES board(no)
);


create table my_board(
	bno bigint primary key auto_increment,
	title varchar(255) not NULL,
	content text not null,
	writer varchar(255) not null,
	read_count int default 0,
	created_date timestamp default current_timestamp(),
	updated_date timestamp default current_timestamp() on update current_timestamp()
	
);

create table goods(
	no bigint primary key auto_increment,
	title varchar(255) not NULL,
	content text not null,
	price int not null,
	stock int not null,
	created_date timestamp default current_timestamp(),
	updated_date timestamp default current_timestamp() on update current_timestamp()
	
);

create table goods_category(
	gno bigint CONSTRAINT goods_category_goods_fk REFERENCES goods(NO),
	cno bigint CONSTRAINT goods_category_category_fk REFERENCES category(NO)
);

create table goods_image(
	no bigint primary key auto_increment,
	bucket_key varchar(255) not NULL,
	org_name varchar(255) not null,
	new_name varchar(255) not null,
	size bigint not null,
	def BIT NOT null,
	gno bigint not null
);

ALTER TABLE goods_image ADD CONSTRAINT goods_image_fk
 FOREIGN KEY (gno) REFERENCES goods(NO);




create table product(
	pno bigint primary key auto_increment,
	title varchar(255) not NULL,
	content text not null,
	price int not null,
	created_date timestamp default current_timestamp(),
	updated_date timestamp default current_timestamp() on update current_timestamp()
	
);

create table product_file(
	fno bigint primary key auto_increment,
	org_name VARCHAR(255) NOT NULL,
	new_name varchar(255) not null,
	created_date timestamp default current_timestamp(),
	updated_date timestamp default current_timestamp() on update current_timestamp(),
	pno bigint not null,
	def_yn BIT NOT NULL DEFAULT 0,
	constraint fk_product_file_product foreign KEY(pno) references product(pno)
	
);


create table ncs_test10(
	no bigint primary key auto_increment,
	name varchar(255),
	c_date timestamp
);

create table member(
	mno bigint primary key auto_increment,
	email varchar(255) not NULL unique,
	name varchar(255) not NULL,
	pass varchar(255) not NULL,
	created_date timestamp default current_timestamp(),
	updated_date timestamp default current_timestamp() on update current_timestamp()
	
);


INSERT INTO hc_board(writer, title, content,cno) VALUE("test5", "test5","test5", 1);my_userncsitem_categorymember_entity_role_set