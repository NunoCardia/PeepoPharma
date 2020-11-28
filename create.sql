create table pp_medication (medication_id  bigserial not null, created_date timestamp not null, dosage varchar(255) not null, last_modified_date timestamp not null, medication_number varchar(255) not null, medication_status varchar(20) check (medication_status in ('In stock', 'Out of stock', 'Ordered')) not null, name varchar(255) not null, price float4 not null, quantity int4 not null, versioned_lock bigint DEFAULT 0 not null, medication_prescription_id int8, medication_stock_purchase_id int8 not null, primary key (medication_id))
create table pp_medication_sales (medication_medication_id int8 not null, sales_sale_id int8 not null)
create table pp_prescription (prescription_id  bigserial not null, created_date timestamp not null, last_modified_date timestamp not null, prescription_number varchar(255) not null, quantity int4 not null, versioned_lock bigint DEFAULT 0 not null, client int8 not null, doctor int8 not null, primary key (prescription_id))
create table pp_sale (sale_id  bigserial not null, created_date timestamp not null, last_modified_date timestamp not null, versioned_lock bigint DEFAULT 0 not null, client int8 not null, pharmaceutist int8 not null, primary key (sale_id))
create table pp_sale_medications (sale_sale_id int8 not null, medications_medication_id int8 not null)
create table pp_stock_purchases (stock_purchase_id  bigserial not null, company_name varchar(255) not null, created_date timestamp not null, last_modified_date timestamp not null, versioned_lock bigint DEFAULT 0 not null, stock_purchase_admin int8 not null, primary key (stock_purchase_id))
create table pp_user (user_id  bigserial not null, address varchar(255) not null, citizen_card varchar(255) not null, created_date timestamp not null, email varchar(255) not null, last_modified_date timestamp not null, name varchar(255) not null, phone_number varchar(13) not null, status varchar(20) check (status in ('Admin', 'Pharmaceutist', 'Client', 'Doctor')) not null, vat varchar(255) not null, versioned_lock bigint DEFAULT 0 not null, primary key (user_id))
create index IDX8nrnqe6xjyqb0ayluckq2o5l5 on pp_medication (medication_id, medication_number)
alter table if exists pp_medication add constraint UK_obdjljlhruk56ha4beleu8m48 unique (medication_number)
create index IDXgaql6sfb249lxujmsp9dq6vf2 on pp_prescription (prescription_id, prescription_number)
create index IDXlq02y7gbi3msu09mt22skwa63 on pp_sale (sale_id)
create index IDXmp7kmle4iqjjdv2fav5h2v66r on pp_stock_purchases (stock_purchase_id)
create index IDXafgt6jquka44ok2pgtvv9msbd on pp_user (user_id, citizen_card, vat)
alter table if exists pp_user add constraint UK_aince7mckphl63pqouo579049 unique (citizen_card)
alter table if exists pp_user add constraint UK_cy4x8xndkuemrukmfh00cr7v9 unique (email)
alter table if exists pp_user add constraint UK_pveai0q1da250rb8h4msmlcii unique (vat)
alter table if exists pp_medication add constraint FKrk74rry9vg12f3g44a7a06jpf foreign key (medication_prescription_id) references pp_prescription
alter table if exists pp_medication add constraint FK3vs21b6r89lggn7xvqch3xf80 foreign key (medication_stock_purchase_id) references pp_stock_purchases
alter table if exists pp_medication_sales add constraint FKngjivg7suiatvshb2wf5mn6i4 foreign key (sales_sale_id) references pp_sale
alter table if exists pp_medication_sales add constraint FKnxptmq7053yvws3ukqm0n6p56 foreign key (medication_medication_id) references pp_medication
alter table if exists pp_prescription add constraint FK2ve2xnfji3oh39bfvr3sjja6j foreign key (client) references pp_user
alter table if exists pp_prescription add constraint FKp32xehmtv12f0hsish0t88grg foreign key (doctor) references pp_user
alter table if exists pp_sale add constraint FK7u727x3tuxw6k7rekf0ogv1e5 foreign key (client) references pp_user
alter table if exists pp_sale add constraint FKr52q2achqjebkxrgk9r450ybg foreign key (pharmaceutist) references pp_user
alter table if exists pp_sale_medications add constraint FK258b4o498lo1f2p7kv8fje640 foreign key (medications_medication_id) references pp_medication
alter table if exists pp_sale_medications add constraint FK6ywee8bumc6edb2jceeb5mmhs foreign key (sale_sale_id) references pp_sale
alter table if exists pp_stock_purchases add constraint FKivdgl5r9kl8205l45oi1o7ltf foreign key (stock_purchase_admin) references pp_user
