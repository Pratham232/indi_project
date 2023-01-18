use pp;
create table User(
username varchar(10),
password varchar(10),
role varchar(10)
);
insert into User values
('pp','mb','Admin'),
('ps','md','Trainer'),
('pd','mq','Trainee');

Delimiter //
Create Procedure addQuestions()
begin

end //
delimiter ;