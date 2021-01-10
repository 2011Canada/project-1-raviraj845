CREATE TABLE ERS_USER_ROLES
(
    
    ERS_USER_ROLE_ID INT NOT NULL,
    USER_ROLE VARCHAR(10) NOT NULL
    
);

ALTER TABLE ERS_USER_ROLES add constraint ERS_USER_ROLES_PK  PRIMARY KEY (ERS_USER_ROLE_ID);


CREATE TABLE ERS_REIMBURSEMENT_TYPE
(
    
    REIMB_TYPE_ID INT NOT NULL,
    REIMB_TYPE VARCHAR(10) NOT NULL
    
);

ALTER TABLE ERS_REIMBURSEMENT_TYPE add constraint REIMBURSEMENT_TYPE_PK  PRIMARY KEY (REIMB_TYPE_ID);

drop table ERS_REIMBURSEMENT_TYPE;


CREATE TABLE ERS_REIMBURSEMENT_STATUS
(
    
    REIMB_STATUS_ID INT NOT NULL,
    REIMB_STATUS VARCHAR(10) NOT NULL
    
);

ALTER TABLE ERS_REIMBURSEMENT_STATUS add constraint REIMB_STATUS_PK  PRIMARY KEY (REIMB_STATUS_ID);

CREATE TABLE ERS_USERS
(
    
    ERS_USERS_ID INT NOT NULL,
    ERS_USERNAME VARCHAR(50) NOT NULL,
    ERS_PASSWORD VARCHAR(50) NOT NULL,
    USER_FIRST_NAME VARCHAR(100) NOT NULL,
    USER_LAST_NAME VARCHAR(100) NOT NULL,
    USER_EMAIL VARCHAR(150),
    USER_ROLE_ID INT NOT NULL
    
    
);

ALTER TABLE ERS_USERS 

add constraint ERS_USERS_PK  PRIMARY KEY (ERS_USERS_ID),
ADD CONSTRAINT USER_ROLES_FK FOREIGN KEY (USER_ROLE_ID) REFERENCES ERS_USER_ROLES (ERS_USER_ROLE_ID);

drop  TABLE ERS_REIMBURSEMENT;

CREATE TABLE ERS_REIMBURSEMENT
(
    
    REIMB_ID SERIAL  NOT NULL,
    REIMB_AMOUNT NUMERIC NOT NULL,
    REIMB_SUBMITTED TIMESTAMP,
     REIMB_RESOLVED TIMESTAMP,
     REIMB_DESCRIPTION VARCHAR(250),
     REIMB_RECEIPT BYTEA,
     REIMB_AUTHOR INT,
     REIMB_RESOLVER INT,
     REIMB_STATUS_ID INT,
     REIMB_TYPE_ID INT NOT NULL
     
    
    
    
);

ALTER TABLE ERS_REIMBURSEMENT 

add constraint ERS_REIMBURSEMENT_PK  PRIMARY KEY (REIMB_ID),
ADD CONSTRAINT ERS_USERS_FK_AUTH FOREIGN KEY (REIMB_AUTHOR) REFERENCES ERS_USERS (ERS_USERS_ID),
ADD CONSTRAINT ERS_USERS_FK_RESLVR FOREIGN KEY (REIMB_AUTHOR) REFERENCES ERS_USERS (ERS_USERS_ID),
ADD CONSTRAINT ERS_REIMBURSEMENT_STATUS_FK FOREIGN KEY (REIMB_STATUS_ID) REFERENCES ERS_REIMBURSEMENT_STATUS (REIMB_STATUS_ID),
ADD CONSTRAINT ERS_REIMBURSEMENT_TYPE_FK FOREIGN KEY (REIMB_TYPE_ID) REFERENCES ERS_REIMBURSEMENT_TYPE (REIMB_TYPE_ID);



***********************************************************************************************************

insert into ers_reimbursement_status (REIMB_STATUS_ID,REIMB_STATUS)
values
 (1,'Approved'),
 (2,'Pending'),
 (3,'Denied');
 
select * from ers_reimbursement_type;

insert into ers_reimbursement_type (REIMB_TYPE_ID,REIMB_TYPE)
values
 (1,'LODGING'),
 (2,'TRAVEL'),
 (3,'FOOD'),
 (4,'OTHER');
 

insert into ers_user_roles (ERS_USER_ROLE_ID,USER_ROLE)
values
 (1,'Employee'),
 (2,'Manager');

select * from ers_user_roles;

insert into ers_users (ers_users_id,ers_username,ers_password,first_name,last_name,email, user_role_id)
values
 (1,'rdodiya','project1','Ravi','Dodiya','rdodiya@revature.com',1),
 (2,'vkohli','project1','Virat','Kohli','vkhohli@revature.com',1),
 (3,'abatson','javascript','Alec','Batson','abatson@revature.com',2);

select * from ers_users;

insert into ers_reimbursement (REIMB_ID,REIMB_AMOUNT,REIM_SUBMITTED,REIM_RESOLVED,REIM_DESCRIPTION,REIM_RECEIPT,REIMB_AUTHOR,REIMB_RESOLVER,REIMB_STATUS_ID,REIMB_TYPE_ID)

values

(1,100,'2020-12-27 12:25:00','2020-12-28 12:25:00','Stayed at Hilton',null,1,3,2,1);

select* from ers_reimbursement;


jdbc:postgresql://training-database.cfn9ljihtkgc.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=ERS", "postgres", "Summer16#"

insert into ers_reimbursement (REIMB_ID,REIMB_AMOUNT,REIMB_SUBMITTED,REIMB_RESOLVED,REIMB_DESCRIPTION,REIMB_RECEIPT,REIMB_AUTHOR,REIMB_RESOLVER,REIMB_STATUS_ID,REIMB_TYPE_ID)

values

(1,100,'2020-12-27 12:25:00','2020-12-28 12:25:00','Stayed at Hilton',null,1,3,2,3);


insert into ers_reimbursement (REIMB_ID,REIMB_AMOUNT,REIMB_SUBMITTED,REIMB_RESOLVED,REIMB_DESCRIPTION,REIMB_RECEIPT,REIMB_AUTHOR,REIMB_RESOLVER,REIMB_STATUS_ID,REIMB_TYPE_ID)

values

(2,150,'2020-12-21 12:25:00','2020-12-28 12:25:00','travelled to ottawa',null,1,3,1,2),
(3,20,'2020-12-21 12:25:00',null,'Lunch at Thai King',null,1,3,2,1),
(4,50,'2020-12-21 12:25:00','2020-12-28 12:25:00','Dinner at The Drake',null,1,3,3,1),
(5,50,'2020-12-23 8:25:00',null,'stay at Days inn',null,2,3,2,3),
(6,120,'2020-12-23 9:21:00','2020-12-28 12:25:00','travelled to vancouver',null,2,3,1,2),
(7,120,'2020-12-22 7:41:00','2020-12-28 9:25:00','went to museam',null,2,3,3,4);


 
 
