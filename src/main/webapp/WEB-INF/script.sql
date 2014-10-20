DROP TABLE employees_office_pos;
DROP TABLE employees;
DROP TABLE offices_positions;
DROP TABLE offices;
DROP TABLE addresses;
DROP TABLE companies;
DROP TABLE cities;
DROP TABLE countries;
DROP TABLE positions;

create table countries(
	country_id 		NUMBER PRIMARY KEY,
	name			VARCHAR2(20)
);

create table cities(
	city_id 		NUMBER PRIMARY KEY,
	country_id		NUMBER NOT NULL,
	name			VARCHAR2(20),
	FOREIGN KEY (country_id) REFERENCES countries(country_id)
);

create table addresses(
 	address_id 		NUMBER PRIMARY KEY,
 	city_id 	   	NUMBER NOT NULL,
 	street     		VARCHAR2(20),
 	house      		NUMBER(5),
 	apartment 		NUMBER(5),
 	FOREIGN KEY (city_id) REFERENCES cities(city_id)
 );
 
create table companies(
 	company_id 		NUMBER PRIMARY KEY,
 	name	VARCHAR2(30)
);

 
create table offices(
	office_id 		NUMBER PRIMARY KEY,
 	company_id 		NUMBER NOT NULL,
 	address_id		NUMBER NOT NULL,
 	FOREIGN KEY (company_id) REFERENCES companies(company_id),
 	FOREIGN KEY (address_id) REFERENCES addresses(address_id)
);
 
 create table positions(
 	position_id		NUMBER PRIMARY KEY,
 	name			VARCHAR2(30)
 );
 
create table offices_positions (
 	office_pos_id	NUMBER PRIMARY KEY,
 	position_id		NUMBER NOT NULL,
 	office_id 		NUMBER NOT NULL,
 	constraint fk_position
 	FOREIGN KEY (position_id) REFERENCES positions(position_id),
	constraint fk_office
 	FOREIGN KEY (office_id) REFERENCES offices(office_id)
 );
 
create table employees(
	employee_id 	NUMBER PRIMARY KEY,
	first_name		VARCHAR2(20),
	last_name		VARCHAR2(20),
	address_id		NUMBER NOT NULL,
	FOREIGN KEY (address_id) REFERENCES addresses(address_id)
);
 
create table employees_office_pos(
	employee_id 	NUMBER NOT NULL,
	office_pos_id	NUMBER NOT NULL,
	constraint pk_employees_office_pos PRIMARY KEY (office_pos_id, employee_id),
	FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
	FOREIGN KEY (office_pos_id) REFERENCES offices_positions(office_pos_id)
);
 
 
 
 