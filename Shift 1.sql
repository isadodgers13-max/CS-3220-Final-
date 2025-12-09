UPDATE attendance a
JOIN employee e ON a.employee_id=e.id
JOIN event ev ON a.event_id=ev.id
SET a.attended = 1
WHERE e.first_name='Amy' AND e.last_name='Adams' AND ev.name='Shift 1';
