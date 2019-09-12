CREATE OR REPLACE
PACKAGE BODY PKG_CLIENTE AS

  PROCEDURE SP_LISTAR
    (
        P_CURSOR          OUT SYS_REFCURSOR,
        P_RAZON_SOCIAL    IN  CLIENTE.RAZON_SOCIAL%TYPE
    ) AS
  BEGIN
     OPEN 
            P_CURSOR
        FOR
            SELECT  
                    ID_CLIENTE,
                    RAZON_SOCIAL,
                    RUC
            FROM 
                    CLIENTE
            WHERE 
                        UPPER(RAZON_SOCIAL) LIKE '%'||UPPER(P_RAZON_SOCIAL)||'%'
                    AND ESTADO='1';
  END SP_LISTAR;

END PKG_CLIENTE;
