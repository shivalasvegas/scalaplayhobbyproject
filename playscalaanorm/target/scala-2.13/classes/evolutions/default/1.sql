# --- First database schema

# --- !Ups

set ignorecase true;

create table company (
  id                        bigint not null,
  name                      varchar(255) not null,
  constraint pk_company primary key (id))
;

create table place (
  id                        bigint not null,
  name                      varchar(255) not null,
  introduced                timestamp,
  discontinued              timestamp,
  company_id                bigint,
  constraint pk_place primary key (id))
;

create sequence company_seq start with 1000;

create sequence place_seq start with 1000;

alter table place add constraint fk_place_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_place_company_1 on place (company_id);


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists company;

drop table if exists place;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

drop sequence if exists place_seq;

