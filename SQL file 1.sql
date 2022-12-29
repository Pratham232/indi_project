/*use pp;

insert into trainer values
('1','GD','SQL','PhD','16'),
('2','Preethi','Communication','MBA','5'),
('3','Sathya','QC','Mtech','4');

insert into trainee values
('01','Prathamesh','SQL','Bachelors','1'),
('02','Aakash','QC','Bachelors','2'),
('03','Vasavi','Communication','Mtech','4'),
('04','Krunal','SQL','PhD','3');*/

/*
topic_name varchar(255) primary key,
b_duration int(10), 
s_date date,
e_date date,
Trainer_id varchar(10),
FOREIGN KEY (Trainer_id) REFERENCES trainer(t_id),
Trainee_id varchar(10),
FOREIGN KEY (Trainee_id) REFERENCES trainee(te_id)



insert into batch values
('Core Java',1000,'19/12/2022','26/03/20233','1','01'),
('Spft Skills',1050,'23/12/2022','15/02/20233','2','03'),
('Quality Test',900,'27/12/2022','29/03/20233','3','02'),
('Core Java',1000,'19/12/2022','26/03/20233','1','04');
*/



create table questions(
q_id varchar(10) primary key,
q_section varchar(255) unique,
q_text varchar(300) unique
);


insert into questions values
('Q1','','')

















