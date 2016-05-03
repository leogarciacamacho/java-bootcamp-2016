/* Percentage of students that passed/failed a given course. */

SELECT c.name, "passed" final_condition, count(*)*100/(SELECT count(*) from student_course sc where sc.id_course = 1) percentage
FROM course c
INNER JOIN student_course sc ON c.id_course = sc.id_course
WHERE sc.id_course = 2 AND sc.final_note >= 6
UNION
SELECT c.name, "failed" final_condition , count(*)*100/(SELECT count(*) from student_course sc where sc.id_course = 1) percentage
FROM course c
INNER JOIN student_course sc ON c.id_course = sc.id_course
WHERE sc.id_course = 2 AND sc.final_note < 6