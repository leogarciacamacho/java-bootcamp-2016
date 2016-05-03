/* Create a database named 'high-school' and modelate:

-Student: first name, last name, registration number, date of birth)
-Teacher: first name, last name, date of birth)
-Course: name, assigned teacher, hours by week, schedule time (they can be dictated several times during the week)

Notes:
-An student can assist several courses during the same year.
-A teacher can be assigned to several courses.
-For each course, each student has 3 partial notes and a final note.
-Create all relationship that you think they are required. */

CREATE DATABASE high_school;
USE high_school;

CREATE TABLE student(
id_student INT NOT NULL,
first_name VARCHAR(25) NOT NULL,
last_name VARCHAR(25) NOT NULL,
registration_number INT NOT NULL,
day_of_birth DATE NOT NULL,
PRIMARY KEY (id_student)
);

CREATE TABLE teacher(
id_teacher INT NOT NULL,
first_name VARCHAR(25) NOT NULL,
last_name VARCHAR(25)NOT NULL,
day_of_birth DATE NOT NULL,
PRIMARY KEY (id_teacher)
);

CREATE TABLE course(
id_course INT NOT NULL,
name VARCHAR(25) NOT NULL,
id_teacher INT NOT NULL,
hours_by_week INT NOT NULL,
PRIMARY KEY (id_course),
KEY course_fk1 (id_teacher),
CONSTRAINT course_fk1 FOREIGN KEY (id_teacher)
REFERENCES teacher (id_teacher) ON UPDATE CASCADE
);

CREATE TABLE course_schedule_time (
id_course INT NOT NULL,
day_week INT NOT NULL,
start_time time NOT NULL,
finish_time time NOT NULL,
PRIMARY KEY (id_course, day_week),
CONSTRAINT course_schedule_time_fk FOREIGN KEY (id_course)
REFERENCES course (id_course) ON UPDATE CASCADE
);

CREATE TABLE student_course(
id_student INT NOT NULL,
id_course INT NOT NULL,
year INT NOT NULL,
first_note INT default NULL,
second_note INT default NULL,
third_note INT default NULL,
final_note INT default NULL,  
PRIMARY KEY (id_course, id_student, year),
KEY student_course_fk1 (id_student),
KEY student_course_fk2 (id_course),
CONSTRAINT student_course_fk1 FOREIGN KEY (id_student)
REFERENCES student (id_student) ON UPDATE CASCADE,
CONSTRAINT student_course_fk2 FOREIGN KEY (id_course)
REFERENCES course (id_course) ON UPDATE CASCADE
);