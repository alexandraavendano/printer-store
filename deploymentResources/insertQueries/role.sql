INSERT INTO printerstore.role (name) VALUES ('ROLE_ADMIN');
INSERT INTO printerstore.role (name) VALUES ('ROLE_CLIENT');
INSERT INTO printerstore.role (name) VALUES ('ROLE_EMPLOYEE');

INSERT INTO printerstore.employee (email, firstName, lastName, password, jobTitle, role_name) VALUES ('admin@test.com', 'name', 'lastName', '$2a$10$6rE19JcWUphVbkubOZ91S.UIOFF.PmPLqzPmhhKEcMH0F8YHrsRi2', 'ADMINISTRATOR', 'ROLE_ADMIN');
INSERT INTO printerstore.employee (email, firstName, lastName, password, jobTitle, role_name) VALUES ('employee@test.com', 'name', 'lastName', '$2a$10$6rE19JcWUphVbkubOZ91S.UIOFF.PmPLqzPmhhKEcMH0F8YHrsRi2', 'DESIGNER', 'ROLE_EMPLOYEE');
INSERT INTO printerstore.client (email, firstName, lastName, password, role_name) VALUES ('user@test.com', 'name', 'lastName', '$2a$10$6rE19JcWUphVbkubOZ91S.UIOFF.PmPLqzPmhhKEcMH0F8YHrsRi2', 'ROLE_CLIENT');