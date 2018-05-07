
CREATE TABLE generators (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description TEXT NULL,
	rate INTEGER NULL,
	base_cost INTEGER NULL,
	unlock_at INTEGER NULL
);


CREATE TABLE events (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description TEXT NULL,
	trigger_at INTEGER NULL
);





INSERT INTO generators (id, name, description, rate, base_cost, unlock_at) VALUES (1, "Grandma", "Grandma likes to make cookies", 5, 10, 10), (2, "Factory", "Factory to produce cookies", 10, 50, 50), (3, "Mine", "Mining cookies", 20, 200, 200);



INSERT INTO events (id, name, description, trigger_at) VALUES (1, "Grandma shows up", "You always know grandma likes to make cookies", 10), (2, "You can construct factory now!", "Factory to produce cookies", 50), (3, "We've found cookies in deep mountain ... in the mine?", "Mining cookies", 200);






