DROP TABLE IF EXISTS PERSON;

CREATE TABLE PERSON (
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
	email VARCHAR(250) NOT NULL
);


DROP TABLE IF EXISTS BOOK;

CREATE TABLE BOOK (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
	author VARCHAR(250) NOT NULL,
	publishing_company VARCHAR(250) NOT NULL,
	publishing_year INT NOT NULL,
	location VARCHAR(250) NOT NULL,
	person_id INT
);
