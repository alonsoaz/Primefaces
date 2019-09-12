INSERT INTO PRODUCTO(CODIGO,SERIE,DESCRIPCION,PRECIO,MARCA,MODELO,ESTADO) 
VALUES (SEQ_PRODUCTO.NEXTVAL, 'PROD000001', 'Proyector ViewSonic', 1500.00, 'ViewSonic', 'PA503S',1);
INSERT INTO PRODUCTO(CODIGO,SERIE,DESCRIPCION,PRECIO,MARCA,MODELO,ESTADO) 
VALUES (SEQ_PRODUCTO.NEXTVAL, 'PROD000002', 'Laptop ASUS VivoBook Pro', 4500.00, 'ASUS', 'N580GB-DB84',1);
COMMIT;

SELECT CODIGO,SERIE,DESCRIPCION,PRECIO,MARCA,MODELO,ESTADO FROM PRODUCTO;

INSERT INTO USUARIO(ID_USUARIO,USUARIO,CLAVE,NOMBRE,ESTADO,AUD_TIPO,AUD_IDUSUARIO,AUD_SESION,AUD_FECHA,AUD_IP)
VALUES(SEQ_USUARIO.NEXTVAL,'ADMIN','KEu8xB5eqcs=','ADMINISTRADOR','1','I',1,'S1','17-03-2018','192.168.1.26');
INSERT INTO USUARIO(ID_USUARIO,USUARIO,CLAVE,NOMBRE,ESTADO,AUD_TIPO,AUD_IDUSUARIO,AUD_SESION,AUD_FECHA,AUD_IP)
VALUES(SEQ_USUARIO.NEXTVAL,'DEMO','KEu8xB5eqcs=','DEMOSTRACI�N','1','I',1,'S2','17-03-2018','192.168.1.26');
INSERT INTO USUARIO(ID_USUARIO,USUARIO,CLAVE,NOMBRE,ESTADO,AUD_TIPO,AUD_IDUSUARIO,AUD_SESION,AUD_FECHA,AUD_IP)
VALUES(SEQ_USUARIO.NEXTVAL,'INV','KEu8xB5eqcs=','INVITADO','1','I',1,'S2','17-03-2018','192.168.1.26');

COMMIT;

SELECT ID_USUARIO,USUARIO,CLAVE,NOMBRE,ESTADO FROM USUARIO;

Insert into HISTORICO_PRECIO (CODIGO,CODIGO_PRODUCTO,PRECIO,FECHA,ID_USUARIO,ESTADO) values ('1','1','2500',to_date('01/01/19','DD/MM/RR'),1,'1');
Insert into HISTORICO_PRECIO (CODIGO,CODIGO_PRODUCTO,PRECIO,FECHA,ID_USUARIO,ESTADO) values ('2','2','500',to_date('02/01/19','DD/MM/RR'),1,'1');
Insert into HISTORICO_PRECIO (CODIGO,CODIGO_PRODUCTO,PRECIO,FECHA,ID_USUARIO,ESTADO) values ('3','1','2600',to_date('11/01/19','DD/MM/RR'),2,'1');
Insert into HISTORICO_PRECIO (CODIGO,CODIGO_PRODUCTO,PRECIO,FECHA,ID_USUARIO,ESTADO) values ('4','1','2400',to_date('01/02/19','DD/MM/RR'),2, '1');
Insert into HISTORICO_PRECIO (CODIGO,CODIGO_PRODUCTO,PRECIO,FECHA,ID_USUARIO,ESTADO) values ('5','2','600',to_date('01/02/19','DD/MM/RR'),1,'1');

INSERT INTO CLIENTE(ID_CLIENTE,RAZON_SOCIAL,DIRECCION,RUC) 
VALUES (SEQ_CLIENTE.NEXTVAL, 'Telef�nica del Per� S.A.A.','Av. Arequipa N� 1155,
Santa Beatriz, Lima, Lima','20100017491');

INSERT INTO CLIENTE(ID_CLIENTE,RAZON_SOCIAL,DIRECCION,RUC) 
VALUES (SEQ_CLIENTE.NEXTVAL, 'Am�rica M�vil Per� SAC','Av. Nicol�s Arriola 480 � La Victoria, Lima.
','20467534026');

INSERT INTO CLIENTE(ID_CLIENTE,RAZON_SOCIAL,DIRECCION,RUC) 
VALUES (SEQ_CLIENTE.NEXTVAL,'Viettel Per� S.A.C.', 'Calle 21 N� 878, Urb. Corpac, San Isidro, Lima','20543254798');

COMMIT;

SELECT * FROM CLIENTE;