CREATE TABLE PRODUCTO(
  CODIGO NUMERIC(4) NOT NULL PRIMARY KEY,
  SERIE VARCHAR2(10) NOT NULL UNIQUE,
  DESCRIPCION VARCHAR2(280) NOT NULL,
	PRECIO NUMERIC(6,2) NOT NULL,
  MARCA VARCHAR2(30) NOT NULL,
  MODELO VARCHAR2(30) NOT NULL,
  ESTADO CHAR(1) DEFAULT '1' NOT NULL
);

ALTER TABLE PRODUCTO
ADD (AUD_TIPO CHAR(1),
    AUD_IDUSUARIO NUMERIC(4),
    AUD_SESION VARCHAR2(60),
    AUD_IP VARCHAR2(20),
    AUD_FECHA DATE);


CREATE TABLE USUARIO(
  ID_USUARIO NUMERIC(4) NOT NULL PRIMARY KEY,
  USUARIO VARCHAR2(20) NOT NULL UNIQUE,
  CLAVE VARCHAR2(80) NOT NULL,
  NOMBRE VARCHAR2(120) NOT NULL UNIQUE,
  ESTADO CHAR(1)DEFAULT '1' NOT NULL ,
  AUD_TIPO CHAR(1) NULL,
  AUD_IDUSUARIO NUMERIC(10,0) NULL,
  AUD_SESION VARCHAR(60) NULL,
  AUD_FECHA DATE NULL,
  AUD_IP VARCHAR(20) NULL
);

CREATE TABLE HISTORICO_PRECIO(
  CODIGO NUMERIC(4) NOT NULL PRIMARY KEY,
  CODIGO_PRODUCTO NUMERIC(4) REFERENCES PRODUCTO(CODIGO),
  PRECIO NUMERIC(6,2) NOT NULL,
  FECHA DATE NOT NULL ,
  ID_USUARIO NUMERIC(4) NOT NULL REFERENCES USUARIO(ID_USUARIO),
  ESTADO CHAR(1) DEFAULT '1' NOT NULL
);

-- SELECT * FROM V_PRODUCTO_PRECIO;

CREATE TABLE CLIENTE(
  ID_CLIENTE NUMERIC(6) NOT NULL PRIMARY KEY,
  RAZON_SOCIAL VARCHAR2(280) NOT NULL UNIQUE,
  RUC CHAR(11) NOT NULL UNIQUE,
  DIRECCION VARCHAR2(800) NOT NULL,
  
  ESTADO CHAR(1)DEFAULT '1' NOT NULL ,
  
  AUD_TIPO CHAR(1) NULL,
  AUD_IDUSUARIO NUMERIC(10,0) NULL,
  AUD_SESION VARCHAR(60) NULL,
  AUD_FECHA DATE NULL,
  AUD_IP VARCHAR(20) NULL
);
