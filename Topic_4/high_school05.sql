/* For a given teacher, list the timeline for each course that he is assigned to (ordered by date), and the course name. */

SELECT t.last_name, t.first_name, cst.day_week, cst.start_time, cst.finish_time, c.name
FROM teacher t
INNER JOIN course c ON t.id_teacher = c.id_teacher
INNER JOIN course_schedule_time cst ON c.id_course = cst.id_course
WHERE t.id_teacher = 1
ORDER BY cst.day_week