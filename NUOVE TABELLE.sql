CREATE TABLE Persona (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    data_di_nascita DATE NOT NULL,
    sesso VARCHAR(2) CHECK(sesso IN ('m','f')) NOT NULL,
	lista_partecipazioni TEXT[]
);

CREATE TABLE Partecipazione (
    id SERIAL PRIMARY KEY,
    persona_id INT REFERENCES Persona(id) ON DELETE CASCADE,
    evento_id INT REFERENCES Evento(id) ON DELETE CASCADE,
    stato VARCHAR(20) CHECK(stato IN ('confermato','da_confermare')) NOT NULL,
    UNIQUE (persona_id, evento_id)
);

CREATE TABLE Location (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    citta VARCHAR(50) NOT NULL
);
