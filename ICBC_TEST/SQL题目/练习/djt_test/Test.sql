create database if not exists mydb3;
use mydb3;
-- Create table
create table if not exists EXAM_CONTRACTexam_contract
(
  company     VARCHAR(10),
  contract_no VARCHAR(30),
  valid_date  VARCHAR(10),
  customer    VARCHAR(60),
  start_date  VARCHAR(10),
  end_date    VARCHAR(10)
);
insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000003', '20100130', 'li.lei', '20100130', '20200130');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000004', '20100320', 'li.lei', '20110512', '20131123');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000004', '20100320', 'zhang.hao', '20090112', '20161201');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000005', '20100320', 'li.lei', '20131001', '20210101');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('ikbc', '1000005', '20100320', 'zhang.hao', '20011111', '20250612');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000006', '20100130', 'li.lei', '19990122', '20101122');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000006', '20100320', 'li.lei', '20200101', '20200130');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000007', '20100320', 'zhang.hao', '20060707', '20160130');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000010', '20100320', 'li.lei', '20180606', '20200630');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('ikbc', '1000008', '20100320', 'zhang.hao', '20170715', '20180715');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000003', '20100130', 'li.lei', '20001001', '20210130');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000004', '20100320', 'li.lei', '20130511', '20160817');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000004', '20100320', 'zhang.hao', '20300112', '20201230');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000005', '20100320', 'li.lei', '19981230', '19991231');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('ikbc', '1000005', '20100320', 'zhang.hao', '20200114', '20500101');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000006', '20100130', 'li.lei', '20300130', '20340212');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000006', '20100320', 'li.lei', '19950101', '19990114');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000007', '20100320', 'zhang.hao', '20101201', '20300101');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('icbc', '1000010', '20100320', 'li.lei', '20060616', '20101018');

insert into exam_contract (COMPANY, CONTRACT_NO, VALID_DATE, CUSTOMER, START_DATE, END_DATE)
values ('ikbc', '1000007', '20100320', 'zhang.hao', '19991231', '20051001');

desc exam_contract;





