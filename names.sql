INSERT INTO employee (first_name, last_name) VALUES ('Amy','Adams'),('John','Doe'),('Tom','Smith');
INSERT INTO event (name) VALUES ('Shift 1'),('Shift 2'),('Meeting 1'),('Training Session');
-- optionally pre-create attendance
INSERT INTO attendance (employee_id, event_id, attended)
  SELECT e.id, ev.id, NULL FROM employee e CROSS JOIN event ev;
