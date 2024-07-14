-- CREATE SEQUENCE my_entity_sequence START WITH 10000 INCREMENT BY 1;


-- Insert dummy users into the app_user table
INSERT INTO app_user (id, name, date_of_birth) VALUES (NEXT VALUE FOR my_entity_sequence, 'John Doe', '1990-01-01');
INSERT INTO app_user (id, name, date_of_birth) VALUES (NEXT VALUE FOR my_entity_sequence, 'Jane Smith', '1985-05-15');