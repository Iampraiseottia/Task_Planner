INSERT INTO employee(id, name, pob, dob, position) Values(1,'Tomi','Penja', now(), 'Accountant');
INSERT INTO employee(id, name, pob, dob, position) Values(2,'Jhon','Kumba', now(), 'Developer');
INSERT INTO employee(id, name, pob, dob, position) Values(3,'Mark','Okou', now(), 'Printer');
INSERT INTO employee(id, name, pob, dob, position) Values(4,'Fabien','Mora', now(), 'IT Technician');
INSERT INTO employee(id, name, pob, dob, position) Values(5,'Marie','Zalang', now(), 'Accountant');


INSERT INTO status(id, name, description) values(1,'OPENED','Task not assigned to a user');
INSERT INTO status(id, name, description) values(2,'ASSIGNED','Task that the resolution is in progress');
INSERT INTO status(id, name, description) values(3,'DONE','Task that meet the criteria of Done');
INSERT INTO status(id, name, description) values(4,'NOT DONE', 'Task that does not meet the criteria of Done');