CREATE TABLE schools
(
    school_id    BIGINT AUTO_INCREMENT NOT NULL,
    school_name  VARCHAR(255) NULL,
    postal_code  VARCHAR(255) NULL,
    city         VARCHAR(255) NULL,
    street       VARCHAR(255) NULL,
    house_number INT NULL,
    CONSTRAINT pk_schools PRIMARY KEY (school_id)
);

CREATE TABLE students
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    name_of_student   VARCHAR(255) NULL,
    date_of_birth     date NULL,
    school_age_status VARCHAR(255) NULL,
    school_id         BIGINT NULL,
    CONSTRAINT pk_students PRIMARY KEY (id)
);

ALTER TABLE students
    ADD CONSTRAINT FK_STUDENTS_ON_SCHOOL FOREIGN KEY (school_id) REFERENCES schools (school_id);