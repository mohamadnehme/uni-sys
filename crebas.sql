/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2/6/2020 10:15:41 AM                         */
/*==============================================================*/


alter table COURS 
   drop foreign key FK_COURS_TEACH_TEACHER;

alter table JOINED 
   drop foreign key FK_JOINED_JOINED_STUDENT;

alter table JOINED 
   drop foreign key FK_JOINED_JOINED2_COURS;


alter table COURS 
   drop foreign key FK_COURS_TEACH_TEACHER;

drop table if exists COURS;


alter table JOINED 
   drop foreign key FK_JOINED_JOINED_STUDENT;

alter table JOINED 
   drop foreign key FK_JOINED_JOINED2_COURS;

drop table if exists JOINED;

drop table if exists STUDENT;

drop table if exists TEACHER;

/*==============================================================*/
/* Table: COURS                                                 */
/*==============================================================*/
create table COURS
(
   ID_C                 int not null  comment '',
   ID_T                 int  comment '',
   NOM_COURS            varchar(30)  comment '',
   CREDIT               varchar(10)  comment '',
   primary key (ID_C)
);

/*==============================================================*/
/* Table: JOINED                                                */
/*==============================================================*/
create table JOINED
(
   ID_C                 int not null  comment '',
   ID_S                 int  comment '',
   NOTE                 varchar(3)  comment '',
   primary key (ID_C)
);

/*==============================================================*/
/* Table: STUDENT                                               */
/*==============================================================*/
create table STUDENT
(
   ID_S                 int not null  comment '',
   FIRST_NAME           varchar(50)  comment '',
   LAST_NAME            varchar(50)  comment '',
   DOB                  date  comment '',
   GENDRE               char(1)  comment '',
   PHONE                bigint  comment '',
   EMAIL                varchar(50)  comment '',
   PASS                 varchar(50)  comment '',
   IMAGE                varchar(100)  comment '',
   primary key (ID_S)
);

/*==============================================================*/
/* Table: TEACHER                                               */
/*==============================================================*/
create table TEACHER
(
   ID_T                 int not null  comment '',
   NOME_T               varchar(50)  comment '',
   primary key (ID_T)
);

alter table COURS add constraint FK_COURS_TEACH_TEACHER foreign key (ID_T)
      references TEACHER (ID_T);

alter table JOINED add constraint FK_JOINED_JOINED_STUDENT foreign key (ID_S)
      references STUDENT (ID_S);

alter table JOINED add constraint FK_JOINED_JOINED2_COURS foreign key (ID_C)
      references COURS (ID_C);

