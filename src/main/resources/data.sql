DROP TABLE IF EXISTS Topic;

CREATE TABLE Topic (priority INT AUTO_INCREMENT,
name VARCHAR(250) NOT NULL,
author VARCHAR(250) NOT NULL,
code VARCHAR(250) DEFAULT NULL,
primary key (priority)
);

INSERT INTO Topic(name, author, code) VALUES 
('a','a','a'),
('b','b','b'),
('c','c','c'),
('d','d','d');