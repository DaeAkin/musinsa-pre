drop table if exists brand CASCADE;
drop table if exists category CASCADE;
drop table if exists product CASCADE;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
create table brand (id bigint generated by default as identity, name varchar(255), primary key (id));
create table category (id bigint generated by default as identity, name varchar(255), primary key (id));
create table product (id bigint generated by default as identity, name varchar(255), price numeric(19,2), brand_id bigint, category_id bigint, primary key (id));
alter table product add constraint FK_PRODUCT_BRAND foreign key (brand_id) references brand;
alter table product add constraint FK_PRODUCT_CATEGORY foreign key (category_id) references category;
