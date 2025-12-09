CREATE TABLE employee (
  id BIGINT AUTO_INCREMENT PRIMARY KEY
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL, 
  UNIQUE KEY ux_employee_name (first_name, last_name)
);

CREATE TABLE event (
  id BIGINT AUTO_INCREMENT PRIMARY KEY
  name VARCHAR(200) NOT NULL
);

CREATE TABLE attendance (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  employee_id BIGINT NOT NULL,
  event_id BIGINT NOT NULL,
  attended BOOLEAN,
  CONSTRAINT fk_att_emp FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE,
  CONSTRAINT fk_att_ev FOREIGN KEY (event_id) REFERENCES event_(id) ON DELETE CASCADE,
  UNIQUE KEY ux_emp_event (employee_id, event_id)
);
