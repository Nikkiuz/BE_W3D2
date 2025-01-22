/*CREATE TABLE Evento(
id SERIAL PRIMARY KEY,
titolo VARCHAR(15),
data_evento DATE,
descrizione VARCHAR(150),
tipo_evento VARCHAR(10),
CHECK (tipo_evento IN ('pubblico','privato')),
numero_max_partecipanti INTEGER
)*/

/*ALTER TABLE Evento
ADD COLUMN location_id INT;*/


ALTER TABLE Evento
ADD CONSTRAINT fk_location FOREIGN KEY (location_id) REFERENCES Location(id) ON DELETE CASCADE;
