use vishaldb;
show tables;
                                                    -- Creation Of Tables

create table hcm_skill(
	skill_id int primary key auto_increment,
    skill_name varchar(255),
    description varchar(255)
);

create table hcm_skill_matrix(
	skill_matrix_id int primary key auto_increment,
	skill_id int not null references hcm_skill(skill_id),
    proficiency varchar(255),
    acquired varchar(255)
);

create table hcm_employee(
	emp_id int primary key auto_increment,
    emp_name varchar(255),
    department varchar(255)
);

create table hcm_employee_skill_matrix(
	emp_id int references hcm_employee(emp_id),
skill_matrix_id int references hcm_skill_matrix(skill_matrix_id),
primary key(emp_id,skill_matrix_id)
);
 -- Select Queries

select * from hcm_skill;
select * from hcm_skill_matrix;
select * from hcm_employee_skill_matrix;
select * from hcm_employee;

                                                    --Insert Queries

insert into hcm_skill(skill_name,description) values("C Language","Beautiful Language");
insert into hcm_employee(emp_name,department) values("Vishal", "ABC");
insert into hcm_skill_matrix(skill_id,proficiency,acquired) values("1","1","10-10-2019");
insert into hcm_employee_skill_matrix values(1,1);

                                                    -- Drop Queries

drop table hcm_skill_matrix;
drop table hcm_skill;
drop table hcm_employee_skill_matrix;
drop table hcm_employee;
