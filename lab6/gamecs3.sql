/* https://github.com/csula/cs3220-spring-2018/blob/master/notes/labs/lab6.md
*/
CREATE TABLE users (
     id INTEGER AUTO_INCREMENT PRIMARY KEY,
     username VARCHAR(255) NOT NULL,
     password VARCHAR(255) NOT NULL
);
DESCRIBE users;



CREATE TABLE generators (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description TEXT NULL,
	rate INTEGER NULL,
	base_cost INTEGER NULL,
	unlock_at INTEGER NULL,
	created_by INTEGER NULL,
	FOREIGN KEY(created_by) REFERENCES users(id)
);
DESCRIBE generators;



CREATE TABLE events (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description TEXT NULL,
	trigger_at INTEGER NULL,
	created_by INTEGER NULL,
	FOREIGN KEY(created_by) REFERENCES users(id)
);
DESCRIBE events;



CREATE TABLE quantities (
	generator_id INTEGER NOT NULL,
	token VARCHAR(255) NULL,
	quantity INTEGER NULL DEFAULT 0,
	CONSTRAINT uc_quantities UNIQUE(generator_id, token)
);
DESCRIBE quantities;


INSERT INTO users (id, username, password) VALUES (1, "admin", "cs3220password"), (2, "me", "notapassword");
SELECT * FROM users;


INSERT INTO generators (id, name, description, rate, base_cost, unlock_at, created_by) VALUES (1, "Grandma", "Grandma likes to make cookies", 5, 10, 10, 1), (2, "Factory", "Factory to produce cookies", 10, 50, 50, 1), (3, "Mine", "Mining cookies", 20, 200, 200, 2);
SELECT * FROM generators;


INSERT INTO events (id, name, description, trigger_at, created_by) VALUES (1, "Grandma shows up", "You always know grandma likes to make cookies", 10, 1), (2, "You can construct factory now!", "Factory to produce cookies", 50, 1), (3, "We've found cookies in deep mountain ... in the mine?",	"Mining cookies", 200, 2), (4, "sample event", "This is a sample event. Please delete me", 99999, 2);
SELECT * FROM events;


INSERT INTO quantities (generator_id, token, quantity) VALUES (1, "c7a69d44e0b9b415b2d9956cb26b944a", 2), (2, "c7a69d44e0b9b415b2d9956cb26b944a", 1), (1, "80516ce4663c3bd0c8385309a2fe226e", 20), (2, "80516ce4663c3bd0c8385309a2fe226e", 30);
SELECT * FROM quantities;


UPDATE generators SET unlock_at=10, rate=1 WHERE name="Grandma";
SELECT * FROM generators;


SELECT generators.name, generators.description, generators.rate, generators.base_cost, generators.unlock_at, quantities.quantity
FROM generators
INNER JOIN quantities ON quantities.generator_id = generators.id 
WHERE token="80516ce4663c3bd0c8385309a2fe226e";



SELECT id, name, description, rate, base_cost, unlock_at, created_by FROM generators WHERE unlock_at = (SELECT max(unlock_at) FROM generators);


SELECT * FROM generators order by unlock_at ASC;

DELETE FROM events WHERE name="sample event";
SELECT * FROM events;







