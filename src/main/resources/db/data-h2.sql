INSERT INTO `employee` (first_name, last_name, email) VALUES
   ('Leslie','Andrews','leslie@luv2code.com'),
   ('Emma','Baumgarten','emma@luv2code.com'),
   ('Avani','Gupta','avani@luv2code.com'),
   ('Yuri','Petrov','yuri@luv2code.com'),
   ('Juan','Vega','juan@luv2code.com');

-- --
-- -- Inserting data for table `users`
-- --

-- INSERT INTO `users` 
-- VALUES 
-- ('john','{noop}test123',1),
-- ('mary','{noop}test123',1),
-- ('susan','{noop}test123',1);

-- password is  fun123
INSERT INTO `users` 
VALUES 
('john','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('mary','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('susan','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');