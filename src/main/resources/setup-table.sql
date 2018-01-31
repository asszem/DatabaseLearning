CREATE TABLE testdatabase.testtable(
           id INT NOT NULL AUTO_INCREMENT,
           name VARCHAR(100) NOT NULL,
           location VARCHAR(40) NOT NULL,
           number DECIMAL(13,2),
           creation_date DATE,
           PRIMARY KEY (id)
        );
