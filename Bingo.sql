CREATE DATABASE bingo

USE bingo

CREATE TABLE game(
	id_game INT IDENTITY NOT NULL PRIMARY KEY,
	board VARCHAR (50) NULL,
	state bit NULL,
	winner VARCHAR (50) NULL,
	create_at DATE NULL
);

CREATE TABLE ballot(
	id_ballot INT IDENTITY NOT NULL PRIMARY KEY,
	game_id INT NOT NULL,
	ballot VARCHAR(2) NULL,
);

CREATE TABLE player(
	id_user INT IDENTITY NOT NULL PRIMARY KEY,
	game_id INT NOT NULL,
	name VARCHAR(80) NULL,
	card VARCHAR(15) NULL,
	deleted bit NULL,
);



