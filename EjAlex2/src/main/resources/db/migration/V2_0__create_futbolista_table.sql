CREATE TABLE IF NOT EXISTS FUTBOLISTA (
    id_futbolista int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(20),
    nacionalidad varchar(40),
	edad int,
	equipo int,
	FOREIGN KEY (equipo) REFERENCES equipo(id_equipo)
);