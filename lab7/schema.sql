DROP TABLE IF EXISTS events;

CREATE TABLE events (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description TEXT NULL,
	trigger_at INTEGER NULL
);



INSERT INTO events (id, name, description, trigger_at) VALUES 
(1, "Grandma shows up", "You always know grandma likes to make cookies", 10), 
(2, "You can construct factory now!", "Factory to produce cookies", 50),
(3, "We've found cookies in deep mountain ... in the mine?",	"Mining cookies", 200);











