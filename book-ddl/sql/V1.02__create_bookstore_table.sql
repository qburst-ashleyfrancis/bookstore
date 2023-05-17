--book table
CREATE TABLE book.bookstore
  (
     book_id                        serial,
     title                          varchar(100),
     author                         varchar(100),
     isbn                           varchar(100) NOT NULL UNIQUE,
     publication_date               date NOT NULL,
     price                          numeric(20,4),
     created_datetime               timestamp with time zone NOT NULL,
     created_by                     varchar(20) ,
     updated_datetime               timestamp with time zone,
     updated_by                     varchar(20) ,
     PRIMARY KEY (book_id)
  );
