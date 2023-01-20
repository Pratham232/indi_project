drop database if exists pp;
create database pp;
use pp;

/*This is the DDL statements -----Creation of the tables----------*/

create table trainer(
trainer_id varchar(10) PRIMARY KEY,
trainer_name varchar(255),
trainer_track enum('Java','dotnet','mainframe','testing'),
trainer_qual varchar(255),
trainer_exp varchar(3)
);

create table trainee(
trainee_id varchar(10) PRIMARY KEY,
trainee_name varchar(255),
trainee_track enum('Java','dotnet','mainframe','testing'),
trainee_qual varchar(255),
trainee_exp varchar(3)
);


create table batch(
topic_name varchar(255),
batch_duration integer, 
start_date date,
end_date date,
trainer_id varchar(10),
FOREIGN KEY (Trainer_id) REFERENCES trainer(t_id),
trainee_id varchar(10),
FOREIGN KEY (Trainee_id) REFERENCES trainee(te_id)
);



create table question_management(
question_id varchar(10) primary key,
question_section enum('Instructor','Course Material','Learning Effectiveness','Environment','Job Impact'),
question_text varchar(300)
);



create table capture_feedback(
trainer_id varchar(10),
FOREIGN KEY (trainers_id) REFERENCES trainer(trainer_id),
trainee_id varchar(10),
FOREIGN KEY (trainees_id) REFERENCES trainee(trainee_id),
topic_name varchar(255),
question_id varchar(10),
foreign key (question_id) references question_management(question_id),
rating int
);


/*These are DML commands ------------Inserting the values in the table----------------*/

insert into trainer values
('A1','Trainer1','Java','B.Tech','10'),
('A2','Trainer2','dotnet','M.Tech','5'),
('A3','Trainer3','mainframe','MCA','8'),
('A4','Trainer4','testing','M.Sc.IT','2');

insert into trainee values
('B1','Trainee1','dotnet','M.Sc.IT','1'),
('B2','Trainee2','testing','MCA','3'),
('B3','Trainee3','Java','M.Tech','7'),
('B4','Trainee4','mainframe','B.Tech','2');

insert into batch values
('Core Java','3600','2022-12-19','2023-03-26','A1','B3'),
('Selenium','2400','2022-12-29','2023-03-13','A4','B2'),
('Development','4200','2022-12-23','2023-03-12','A3','B4'),
('Advanced Java','1500','2022-12-26','2023-03-02','A1','B1');

insert into question_management values
('Q1','Instructor','How does instructor communicate with the class'),
('Q2','Course Material','Have instructor provided proper course study material'),
('Q3','Learning Effectiveness','Are your all doubts being addressed and solved by the instructor'),
('Q4','Environment','How is the environment of the class'),
('Q5','Job Impact','How did the course help you in your job or project');

insert into capture_feedback values 
('A1','B3','Core Java','Q1','Instructor','How does instructor communicate with the class','4'),
('A1','B3','Core Java','Q2','Course Material','Have instructor provided proper course study material','1'),
('A1','B3','Core Java','Q3','Learning Effectiveness','Are your all doubts being addressed and solved by the instructor','3'),
('A1','B3','Core Java','Q4','Environment','How is the environment of the class','2'),
('A1','B3','Core Java','Q5','Job Impact','How did the course help you in your job or project','5');


/*This is the DQL Statements----------------displaying the table----------------*/

select * from trainer;
select * from trainee;
select * from batch;
select * from question_management;
select * from capture_feedback;



/**/
