drop database if exists pp;
create database pp;
use pp;

/*----DQL----*/

DROP USER if exists PS@Pratham;
CREATE USER PS@Pratham IDENTIFIED BY 'admin';
DROP USER IF EXISTS PP@'%';
CREATE USER PP@'%' IDENTIFIED BY 'admin';

SHOW GRANTS FOR PP@'%';

GRANT ALL
ON *.*   
TO PS@'Pratham';

SHOW GRANTS
FOR PS@'Pratham';

GRANT GRANT OPTION 
ON *.* 
TO PS@'Pratham';

REVOKE ALL PRIVILEGES, GRANT OPTION 
FROM PS@'Pratham';

Show grants for PS@'Pratham';




drop table if exists trainer;

create table trainer(
t_id varchar(10) PRIMARY KEY,
t_name varchar(255),
t_track enum('Java','dotnet','mainframe','testing'),
t_qual enum('B.Tech','M.Tech','MCA','M.Sc.IT'),
t_exp varchar(3)
);

delimiter $$
CREATE TRIGGER t1    
	BEFORE INSERT 
         ON trainer FOR EACH ROW    
         BEGIN    
        select 'please enter the values';
        END;   
delimiter ;

/*TCL*/
set autocommit=0;
start transaction;
savepoint sp1;
insert into trainer values
('A1','Trainer1','Java','B.Tech','10'),
('A2','Trainer2','dotnet','M.Tech','5');
savepoint sp2;
insert into trainer values
('A3','Trainer3','mainframe','MCA','8'),
('A4','Trainer4','testing','M.Sc.IT','2');
rollback to sp2;
insert into trainer values
('A3','Trainer3','mainframe','MCA','8'),
('A4','Trainer4','testing','M.Sc.IT','2');
commit;
set autocommit=1;

update trainer set t_exp='6' where t_id='A2';
delete from trainer where t_id='A2';
insert into trainer values
('A2','Trainer2','dotnet','M.Tech','5');


select * from trainer where t_name='Trainer2';
select * from trainer having t_name like '%3';
select * from trainer where t_track in ('mainframe','testing');
select * from trainer where t_track not in ('mainframe','testing');

/*-----------------1st table done---------------------*/





drop table if exists trainee;
create table trainee(
te_id varchar(10) PRIMARY KEY,
te_name varchar(255),
te_track enum('Java','dotnet','mainframe','testing'),
te_qual enum('B.Tech','M.Tech','MCA','M.Sc.IT'),
te_exp varchar(3)
);

insert into trainee values
('B1','Trainee1','dotnet','M.Sc.IT','1'),
('B2','Trainee2','testing','MCA','3'),
('B3','Trainee3','Java','M.Tech','7'),
('B4','Trainee4','mainframe','B.Tech','2');


/*-----------------2nd table done---------------------*/




drop table if exists batch;
create table batch(
topic_name varchar(255),
b_duration float, 
s_date date,
e_date date,
Trainer_id varchar(10),
FOREIGN KEY (Trainer_id) REFERENCES trainer(t_id),
Trainee_id varchar(10),
FOREIGN KEY (Trainee_id) REFERENCES trainee(te_id)
);

insert into batch values
('Core Java','3600','2022-12-19','2023-03-26','A1','B3'),
('Selenium','2400','2022-12-29','2023-03-13','A4','B2'),
('Development','4200','2022-12-23','2023-03-12','A3','B4'),
('Advanced Java','1500','2022-12-26','2023-03-02','A1','B1');


/*-----------Functions--------------*/
drop function Calculate_Hours_of_Training;
delimiter $$
Create Function Calculate_Hours_of_Training
(
	hours float
)
returns int deterministic
begin
		hours=select 
end$$
delimiter ;

select Calculate_Hours_of_Training('hours');

/*-----------------------------------------*/


/*-----------------3rd table done---------------------*/





drop table if exists question_management;
create table question_management(
q_id varchar(10) primary key,
q_section enum('Instructor','Course Material','Learning Effectiveness','Environment','Job Impact'),
q_text varchar(300)
);
insert into question_management values
('Q1','Instructor','How does instructor communicate with the class'),
('Q2','Course Material','Have instructor provided proper course study material'),
('Q3','Learning Effectiveness','Are your all doubts being addressed and solved by the instructor'),
('Q4','Environment','How is the environment of the class'),
('Q5','Learning Effectiveness','Are your all doubts being addressed and solved by the instructor'),
('Q6','Environment','How is the environment of the class'),
('Q7','Job Impact','How did the course help you in your job or project');



/*-----------------4th table done---------------------*/




drop table if exists capture_feedback;
create table capture_feedback(
trainers_id varchar(10),
FOREIGN KEY (trainers_id) REFERENCES trainer(t_id),
trainees_id varchar(10),
FOREIGN KEY (trainees_id) REFERENCES trainee(te_id),
topics_name varchar(255),
question_id varchar(10),
foreign key (question_id) references question_management(q_id),
question_section enum('Instructor','Course Material','Learning Effectiveness','Environment','Job Impact'),
question_text varchar(255),
rating varchar(10)
);

insert into capture_feedback values 
('A1','B3','Core Java','Q1','Instructor','How does instructor communicate with the class','4'),
('A1','B3','Core Java','Q2','Course Material','Have instructor provided proper course study material','1'),
('A1','B3','Core Java','Q3','Learning Effectiveness','Are your all doubts being addressed and solved by the instructor','3'),
('A1','B3','Core Java','Q4','Environment','How is the environment of the class','2'),
('A1','B3','Core Java','Q5','Job Impact','How did the course help you in your job or project','5');



/*-----------------5th table done---------------------*/



/*------------Stored Procedure-------------*/
drop procedure if exists JoinsForReport;
Delimiter //
Create Procedure JoinsForReport()
begin
select trainer.t_name,capture_feedback.rating
from trainer inner join capture_feedback
on trainer.t_id=capture_feedback.trainers_id;
end //
delimiter ;

call JoinsForReport();