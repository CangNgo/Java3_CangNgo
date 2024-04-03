use master 
go	
CREATE DATABASE LAB6 BAI2
GO 
CREATE TABLE STUDENTS(
	regid int , 
	Name nvarchar(50), 
	Address nvarchar(50) null,
	ParentName nvarchar(50), 
	Phone nvarchar(50),
	Standard nvarchar(50), 
	Reddate datetime ,
	primary key(regid),
	foreign key(Standard) 
);

USE LAB6;

INSERT INTO STUDENTS (regid, Name, Address, ParentName, Phone, Standard, Reddate)
VALUES 
    (1, 'John Doe', '123 Main St', 'Jane Doe', '123-456-7890', 'Grade 10', '2023-01-01'),
    (2, 'Alice Smith', '456 Elm St', 'Bob Smith', '456-789-0123', 'Grade 11', '2023-01-02'),
    (3, 'Michael Johnson', '789 Oak St', 'Sarah Johnson', '789-012-3456', 'Grade 12', '2023-01-03'),
    (4, 'Emily Davis', '101 Pine St', 'Chris Davis', '012-345-6789', 'Grade 10', '2023-01-04'),
    (5, 'Daniel Brown', '202 Maple St', 'Jessica Brown', '345-678-9012', 'Grade 11', '2023-01-05'),
    (6, 'Olivia Wilson', '303 Cedar St', 'David Wilson', '678-901-2345', 'Grade 12', '2023-01-06'),
    (7, 'William Taylor', '404 Birch St', 'Sophia Taylor', '901-234-5678', 'Grade 10', '2023-01-07'),
    (8, 'Sophia Martinez', '505 Walnut St', 'William Martinez', '234-567-8901', 'Grade 11', '2023-01-08'),
    (9, 'Alexander Anderson', '606 Spruce St', 'Olivia Anderson', '567-890-1234', 'Grade 12', '2023-01-09'),
    (10, 'Mia Lopez', '707 Cherry St', 'Ethan Lopez', '890-123-4567', 'Grade 10', '2023-01-10');
