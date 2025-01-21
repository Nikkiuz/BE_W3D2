CREATE TABLE Evento(
id SERIAL PRIMARY KEY,
titolo VARCHAR(15),
data_evento DATE,
descrizione VARCHAR(150),
tipo_evento VARCHAR(10),
CHECK (tipo_evento IN ('pubblico','privato')),
numero_max_partecipanti INTEGER
)