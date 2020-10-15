# --- First database schema

# --- !Ups

set ignorecase true;

create table placeinfo (
  id                        bigint not null,
  name                      varchar(255) not null,
  constraint pk_placeinfo primary key (id))
;

create table place (
  id                        bigint not null,
  name                      varchar(255) not null,
  introduced                timestamp,
  discontinued              timestamp,
  placeinfo_id                bigint,
  constraint pk_place primary key (id))
;

create sequence placeinfo_seq start with 1000;

create sequence place_seq start with 1000;

alter table place add constraint fk_place_placeinfo_1 foreign key (placeinfo_id) references placeinfo (id) on delete restrict on update restrict;
create index ix_place_placeinfo_1 on place (placeinfo_id);


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists placeinfo;

drop table if exists place;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists placeinfo_seq;

drop sequence if exists place_seq;

