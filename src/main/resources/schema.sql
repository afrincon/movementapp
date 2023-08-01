CREATE TABLE IF NOT EXISTS suscriptor(
    idSuscriptor SERIAL,
    nombre VARCHAR(150) NOT NULL,
    identificacion VARCHAR(15) UNIQUE NOT NULL,
    direccion VARCHAR(60),
    telefono VARCHAR(10),
    PRIMARY KEY(idSuscriptor)
);

CREATE TABLE IF NOT EXISTS suscripcion(
  idSuscipcion SERIAL PRIMARY KEY,
  idSuscriptor SERIAL NOT NULL,
  fechaInicio DATE NOT NULL,
  fechaFinalizacion DATE NOT NULL,
  estado BOOLEAN DEFAULT true,
  PRIMARY KEY(idSuscipcion),
  CONSTRAINT fk_suscripcion
    FOREIGN KEY(idSuscriptor)
    REFERENCES suscriptor(idSuscriptor)
);

CREATE TABLE IF NOT EXISTS pagos(
  idPago SERIAL PRIMARY KEY,
  idSuscriptor SERIAL NOT NULL,
  valorPago INT NOT NULL CHECK (valorPago >= 0),
  fechaPago DATE NOT NULL,
  PRIMARY KEY(idPago),
    CONSTRAINT fk_pago
    FOREIGN KEY(idSuscriptor)
    REFERENCES suscriptor(idSuscriptor)
);