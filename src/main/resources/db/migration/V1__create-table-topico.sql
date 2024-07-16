CREATE TABLE topico (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(500) NOT NULL,
    fechaDeCreacion TIMESTAMP NOT NULL,
    status VARCHAR(100) NOT NULL,
    autor VARCHAR(20) NOT NULL,
    curso BIGINT NOT NULL
);
