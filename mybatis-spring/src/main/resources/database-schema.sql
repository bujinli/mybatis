drop table t_student if exists;
create table t_student (
    id integer(80) not null,
    name varchar(80) not null
);

insert into t_student VALUES ( 1, 'tutou');


drop table t_school if exists;
create table t_school (
    id integer(80) not null,
    name varchar(80) not null,
    description varchar(80) not null
);

insert into t_school VALUES ( 1, 'tutou school', 'best school');

