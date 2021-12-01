CREATE TABLE users(
	id serial PRIMARY KEY,
	first_name varchar(50),
	last_name varchar(50)
);
CREATE TABLE accounts(
	id serial PRIMARY KEY,
	account_type varchar(50),
	balance double PRECISION DEFAULT 0.00,
	users_id_fk int REFERENCES users(id)	
);

INSERT INTO users(first_name,last_name) VALUES('Bob', 'Bobby');
INSERT INTO users(first_name,last_name) VALUES('Dave', 'Davie');
INSERT INTO users(first_name,last_name) VALUES('Jose', 'Jole');

INSERT INTO accounts (users_id_fk) VALUES (7);

SELECT * FROM users;

SELECT * FROM accounts;

DELETE FROM accounts WHERE id=5;