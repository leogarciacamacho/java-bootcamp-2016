/* List students and teachers for a given course. */

SELECT c.name, t.last_name, t.first_name, s.last_name, s.first_name
FROM teacher t
INNER JOIN course c ON t.id_teacher = c.id_teacher
INNER JOIN student_course sc ON c.id_course = sc.id_course
INNER JOIN student s ON sc.id_student = s.id_student
WHERE c.id_course = 1
ORDER BY s.last_name