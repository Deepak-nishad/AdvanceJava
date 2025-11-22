CREATE PROCEDURE `new_procedure` ()
BEGIN
SELECT 
        MIN(Salary) AS MinSalary,
        MAX(Salary) AS MaxSalary
    FROM Employees; 
END
