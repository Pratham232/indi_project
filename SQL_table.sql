drop database if exists pp;
create database pp;
use pp;
show databases;

create table trainer(
t_id varchar(10) PRIMARY KEY,
t_name varchar(255),
t_track varchar(255),
t_qual varchar(255),
t_exp varchar(3)
);

insert into trainer values
('1','GD','SQL','PhD','16'),
('2','Preethi','Communication','MBA','5'),
('3','Sathya','QC','Mtech','4');

create table trainee(
te_id varchar(10) PRIMARY KEY,
te_name varchar(255),
te_track varchar(255),
te_qual varchar(255),
te_exp varchar(3)
);

insert into trainee values
('01','Prathamesh','SQL','Bachelors','1'),
('02','Aakash','QC','Bachelors','2'),
('03','Vasavi','Communication','Mtech','4'),
('04','Krunal','SQL','PhD','3');

create table batch(
topic_name varchar(255) primary key,
b_duration int(10), 
s_date date,
e_date date,
Trainer_id varchar(10),
FOREIGN KEY (Trainer_id) REFERENCES trainer(t_id),
Trainee_id varchar(10),
FOREIGN KEY (Trainee_id) REFERENCES trainee(te_id)
);

insert into batch values
('Core Java',1000,'19/12/2022','26/03/20233','1','01'),
('Spft Skills',1050,'23/12/2022','15/02/20233','2','03'),
('Quality Test',900,'27/12/2022','29/03/20233','3','02'),
('Core Java',1000,'19/12/2022','26/03/20233','1','04');


create table questions(
q_id varchar(10) primary key,
q_section varchar(255) unique,
q_text varchar(300) unique
);

create table capture_feedback(
rating varchar(10),
trainers_id varchar(10),
FOREIGN KEY (trainers_id) REFERENCES trainer(t_id),
trainees_id varchar(10),
FOREIGN KEY (trainees_id) REFERENCES trainee(te_id),
topics_name varchar(255),
FOREIGN KEY (topics_name) REFERENCES batch(topic_name),
question_section varchar(255),
FOREIGN KEY (question_section) REFERENCES questions(q_section),
question_id varchar(10),
FOREIGN KEY (question_id) REFERENCES questions(q_id),
question_text varchar(255),
FOREIGN KEY (question_text) REFERENCES questions(q_text)
);