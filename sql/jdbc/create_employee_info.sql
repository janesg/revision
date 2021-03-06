CREATE TABLE employee_info (
  ID           NUMBER(10)    NOT NULL,
  FIRST_NAME   VARCHAR2(30)  NOT NULL,
  LAST_NAME    VARCHAR2(30)  NOT NULL,
  JOB_TITLE    VARCHAR2(100) NOT NULL,
  DEPARTMENT   VARCHAR2(100),
  SALARY       NUMBER(14,2),
  CONSTRAINT pk_employee_info PRIMARY KEY (ID)
);

CREATE SEQUENCE employee_info_seq
START WITH 1
INCREMENT BY 1
CACHE 100;

CREATE OR REPLACE TRIGGER employee_info_ins_trg 
BEFORE INSERT ON employee_info 
FOR EACH ROW
BEGIN
  SELECT employee_info_seq.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;
/