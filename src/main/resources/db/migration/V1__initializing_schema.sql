CREATE TABLE book
(
    bookId  VARCHAR(10) PRIMARY KEY,
    bookName VARCHAR(255)   NOT NULL,
    author   VARCHAR(255)   NOT NULL,
    price    DECIMAL(10, 2) NOT NULL

)