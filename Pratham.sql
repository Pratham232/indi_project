create database pp;
use pp;
show databases;

create table trainer(
t_id int(10) PRIMARY KEY,
t_name varchar(255),
t_id int(10),
foreign key (t_id) references batch(topic_id),
t_track varchar(255),
t_qual varchar(255),
t_exp int(3)
);

create table trainee(
te_id int(10) PRIMARY KEY,
te_name varchar(255),
tt_id int(10),
foreign key (tt_id) references batch(topic_id),
te_track varchar(255),
te_qual varchar(255),
te_exp int(3)
);

create table batch(
topic_id int(10),
topic_name varchar(255),
b_duration int(10)
);

create table questions(
q_id int(10),
q_section varchar(255),
q_text text(300)
);