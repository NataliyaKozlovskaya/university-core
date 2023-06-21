ALTER DATABASE `university` CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE  university(
                            id INTEGER PRIMARY KEY AUTO_INCREMENT,
                            name VARCHAR(60) NOT NULL,
                            address VARCHAR(30) NOT NULL,
                            rector VARCHAR(60) NOT NULL,
                            year_of_foundation INTEGER NOT NULL

);

CREATE TABLE  faculty(
                         id INTEGER PRIMARY KEY AUTO_INCREMENT,
                         university_id INTEGER NOT NULL,
                         name VARCHAR(40) NOT NULL,
                         dean VARCHAR(60) NOT NULL,
                         rating INTEGER,
                         CONSTRAINT FOREIGN KEY (university_id) REFERENCES university (id)

);


CREATE TABLE  professor(
                           id INTEGER PRIMARY KEY AUTO_INCREMENT,
                           faculty_id INTEGER NOT NULL,
                           full_name VARCHAR(60) NOT NULL,
                           age INTEGER NOT NULL,
                           email VARCHAR(30) NOT NULL,
                           work_experience INTEGER NOT NULL,
                           CONSTRAINT FOREIGN KEY (faculty_id) REFERENCES faculty(id)
);


CREATE TABLE student(
                        id INTEGER PRIMARY KEY AUTO_INCREMENT,
                        full_name VARCHAR(60) NOT NULL,
                        faculty_id INTEGER NOT NULL,
                        year_of_study INTEGER NOT NULL,
                        average_mark DOUBLE NULL,
                        CONSTRAINT FOREIGN KEY (faculty_id) REFERENCES faculty(id)
);


INSERT INTO university (name, address, rector, year_of_foundation) VALUES ('БГТУ','г.Минкс ул.Свердлова 13А','Войтов Игорь Витальевич', 1930);
INSERT INTO university (name, address, rector, year_of_foundation) VALUES ('БГУ','г.Минск, пр.Независимости 4','Абламейко Сергей Владимирович', 1921);
INSERT INTO university (name, address, rector, year_of_foundation) VALUES ('БГУИР','г.Минск,ул.Петруся Бровки 6','Богуш Владимир Анатольевич', 1964);


INSERT INTO faculty(university_id, name, dean, rating) VALUES (1,'ТОВ', 'Радченко Юрий Сергеевич', 9);
INSERT INTO faculty(university_id, name, dean, rating) VALUES (1,'ХТиТ', 'Радченко Юрий Сергеевич', 7);
INSERT INTO faculty(university_id, name, dean, rating) VALUES (2,'Биологический', 'Шупляк Сергей Петрович', 8);
INSERT INTO faculty(university_id, name, dean, rating) VALUES (2,'Исторический', 'Демидчик Вадим Викторович', 6);


INSERT INTO professor(faculty_id, full_name, age, email, work_experience) VALUES (1, 'Петров Петр Петрович', 42,'petrov@gmail.com', 10);
INSERT INTO professor(faculty_id, full_name, age, email, work_experience) VALUES (2, 'Иванов Иван Иванович', 48,'ivanov@gmail.com', 15);
INSERT INTO professor(faculty_id, full_name, age, email, work_experience) VALUES (3, 'Носов Олег Олегович', 39,'nosov@gmail.com', 9);
INSERT INTO professor(faculty_id, full_name, age, email, work_experience) VALUES (4, 'Рябинин Михаил Михайлович', 52,'ryabinin@gmail.com', 24);


INSERT INTO student(full_name, faculty_id, year_of_study, average_mark)  VALUES ('Попов Игорь Иванович', 2, 2, 7.5);
INSERT INTO student(full_name, faculty_id, year_of_study, average_mark)  VALUES ('Рудько Анна Валерьевна', 2, 4, 8.3);
INSERT INTO student(full_name, faculty_id, year_of_study, average_mark)  VALUES ('Шикун Ольга Сергеевна', 3, 1, 6.7);