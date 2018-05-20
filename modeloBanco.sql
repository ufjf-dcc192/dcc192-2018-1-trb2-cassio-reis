
CREATE TABLE PARTICIPANTE (
    PARTICIPANTECOD INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    NOME VARCHAR(255),
    EMAIL VARCHAR(255),
    SENHA VARCHAR(255),
    PRIMARY KEY (PARTICIPANTECOD)

);


CREATE TABLE atividade (
    atvcod INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY ,
    PARTICIPANTECOD INTEGER NOT NULL ,
    eventocod INTEGER NOT NULL ,
    PRIMARY KEY (atvcod),
    FOREIGN KEY (eventocod) REFERENCES Evento(eventocod),
    FOREIGN KEY (PARTICIPANTECOD) REFERENCES PARTICIPANTE(PARTICIPANTECOD)
    
);
