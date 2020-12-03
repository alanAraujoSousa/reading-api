CREATE TABLE `user` (
    id BIGINT auto_increment,
    name VARCHAR(255) NOT NULL,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE `book` (
    id BIGINT auto_increment,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    reviewTitle VARCHAR(255),
    reviewContent VARCHAR(1024),
    currentPage INT(11),
    currentRating INT(11),
    finalRating INT(11),
    pages INT(11) NOT NULL,
    startReadingDate TIMESTAMP without time zone,
    endReadingDate TIMESTAMP without time zone,
    PRIMARY KEY (id),
    CONSTRAINT FK_PersonBook FOREIGN KEY (user_id) REFERENCES user(id)
);
