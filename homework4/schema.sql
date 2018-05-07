
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


CREATE TABLE events (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description TEXT NULL,
	trigger_at INTEGER NULL,
	created_by INTEGER NULL,
	FOREIGN KEY(created_by) REFERENCES users(id)
);





INSERT INTO generators (id, name, description, rate, base_cost, unlock_at, created_by) VALUES (1, "Grandma", "Grandma likes to make cookies", 5, 10, 10, 1), (2, "Factory", "Factory to produce cookies", 10, 50, 50, 1), (3, "Mine", "Mining cookies", 20, 200, 200, 2);
SELECT * FROM generators;


INSERT INTO events (id, name, description, trigger_at, created_by) VALUES (1, "Grandma shows up", "You always know grandma likes to make cookies", 10, 1), (2, "You can construct factory now!", "Factory to produce cookies", 50, 1), (3, "We've found cookies in deep mountain ... in the mine?",	"Mining cookies", 200, 2), (4, "sample event", "This is a sample event. Please delete me", 99999, 2);






