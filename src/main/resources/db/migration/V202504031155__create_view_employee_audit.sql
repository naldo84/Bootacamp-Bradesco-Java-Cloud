DROP VIEW IF EXISTS view_employee_audit;

CREATE VIEW view_employee_audit AS
    SELECT employee_id, name, old_name, salary, old_salary, birthday, old_birthday, operation
    FROM employees_audit
    ORDER BY created_at;
