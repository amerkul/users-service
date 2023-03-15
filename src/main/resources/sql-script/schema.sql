CREATE TABLE users (
                           id BIGSERIAL PRIMARY KEY NOT NULL,
                           name VARCHAR(30) NOT NULL,
                           email VARCHAR(50) NOT NULL,
                           age INT NOT NULL
);