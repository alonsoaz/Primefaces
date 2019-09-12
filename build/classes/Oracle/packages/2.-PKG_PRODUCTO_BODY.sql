create or replace PACKAGE BODY PKG_PRODUCTO AS

  PROCEDURE SP_LISTAR(
     P_CURSOR OUT SYS_REFCURSOR,
     P_DESCRIPCION IN  PRODUCTO.DESCRIPCION%TYPE
  ) AS
  BEGIN
      OPEN 
            P_CURSOR
        FOR
            SELECT  
                    CODIGO,
                    SERIE,
                    DESCRIPCION,
                    PRECIO,
                    MARCA,
                    MODELO
            FROM 
                    PRODUCTO
            WHERE 
                        UPPER(DESCRIPCION) LIKE '%'||UPPER(P_DESCRIPCION)||'%'
                    AND ESTADO='1';
  END SP_LISTAR;
  
   PROCEDURE SP_LISTAR_PRECIOS
    (
        P_CURSOR    OUT SYS_REFCURSOR,
        P_DESCRIPCION    IN  PRODUCTO.DESCRIPCION%TYPE
    )AS
    BEGIN
      OPEN 
            P_CURSOR
        FOR
            SELECT 
                CODIGO,
                DESCRIPCION,
                PRECIO,
                FECHA,
                USUARIO,
                NOMBRE_USUARIO
            FROM 
                V_PRODUCTO_PRECIO
            WHERE
                 UPPER(DESCRIPCION) LIKE '%'||UPPER(P_DESCRIPCION)||'%';

    END SP_LISTAR_PRECIOS;

     PROCEDURE SP_LISTAR_PRECIOS_X_CODIGO
    (
        P_CURSOR    OUT SYS_REFCURSOR,
        P_CODIGO    IN  PRODUCTO.CODIGO%TYPE
    )AS
    BEGIN
      OPEN 
            P_CURSOR
        FOR
            SELECT 
                CODIGO,
                DESCRIPCION,
                PRECIO,
                FECHA,
                USUARIO,
                NOMBRE_USUARIO
            FROM 
                V_PRODUCTO_PRECIO
            WHERE
                 UPPER(CODIGO_PRODUCTO) =P_CODIGO;
    END SP_LISTAR_PRECIOS_X_CODIGO;
    
    PROCEDURE SP_BUSCAR_X_ID
    (
        P_CURSOR    OUT SYS_REFCURSOR,
        P_CODIGO    IN  PRODUCTO.CODIGO%TYPE
    )AS
    BEGIN
    OPEN 
            P_CURSOR
        FOR
            SELECT  
                    CODIGO,
                    SERIE,
                    DESCRIPCION,
                    PRECIO,
                    MARCA,
                    MODELO
            FROM 
                    PRODUCTO
            WHERE 
                    CODIGO  =  P_CODIGO;

    END SP_BUSCAR_X_ID;

  PROCEDURE SP_INSERTAR
    (
        P_CODIGO        OUT PRODUCTO.CODIGO%TYPE,
        P_SERIE         IN  PRODUCTO.SERIE%TYPE,
        P_DESCRIPCION   IN  PRODUCTO.DESCRIPCION%TYPE,
        P_PRECIO        IN  PRODUCTO.PRECIO%TYPE,
        P_MARCA         IN  PRODUCTO.MARCA%TYPE,
        P_MODELO        IN  PRODUCTO.MODELO%TYPE,
        -- Auditoria
        P_AUD_IDUSUARIO IN  PRODUCTO.AUD_IDUSUARIO%TYPE,
        P_AUD_SESION    IN  PRODUCTO.AUD_SESION%TYPE,
        P_AUD_IP        IN  PRODUCTO.AUD_IP%TYPE
    ) AS
  BEGIN

    SELECT
        SEQ_PRODUCTO.NEXTVAL
    INTO
        P_CODIGO
    FROM
        DUAL;

    INSERT INTO PRODUCTO(
        CODIGO,
        SERIE,
        DESCRIPCION,
        PRECIO,
        MARCA,
        MODELO,
        ESTADO,
        -- Auditoria
        AUD_TIPO,
        AUD_IDUSUARIO,
        AUD_SESION,
        AUD_IP,
        AUD_FECHA
    )
    VALUES
    (
        P_CODIGO,
        P_SERIE,
        P_DESCRIPCION,
        P_PRECIO,
        P_MARCA,
        P_MODELO,
        '1',
        -- Auditoria
        'I',
        P_AUD_IDUSUARIO,
        P_AUD_SESION,
        P_AUD_IP,
        sysdate

    );

  END SP_INSERTAR;

  PROCEDURE SP_ACTUALIZAR
    (
        P_CODIGO        OUT PRODUCTO.CODIGO%TYPE,
        P_SERIE         IN  PRODUCTO.SERIE%TYPE,
        P_DESCRIPCION   IN  PRODUCTO.DESCRIPCION%TYPE,
        P_PRECIO        IN  PRODUCTO.PRECIO%TYPE,
        P_MARCA         IN  PRODUCTO.MARCA%TYPE,
        P_MODELO        IN  PRODUCTO.MODELO%TYPE,
        -- Auditoria
        P_AUD_IDUSUARIO IN  PRODUCTO.AUD_IDUSUARIO%TYPE,
        P_AUD_SESION    IN  PRODUCTO.AUD_SESION%TYPE,
        P_AUD_IP        IN  PRODUCTO.AUD_IP%TYPE
    ) AS
  BEGIN

    UPDATE 
        PRODUCTO
    SET
        SERIE           =   P_SERIE,
        DESCRIPCION     =   P_DESCRIPCION,
        PRECIO          =   P_PRECIO,
        MARCA           =   P_MARCA,
        MODELO          =   P_MODELO,
        -- Auditoria
        AUD_TIPO        =   'A',
        AUD_IDUSUARIO   =   P_AUD_IDUSUARIO,
        AUD_SESION      =   P_AUD_SESION,
        AUD_IP          =   P_AUD_IP,
        AUD_FECHA       =   sysdate
    WHERE
        CODIGO          =   P_CODIGO;

  END SP_ACTUALIZAR;

    PROCEDURE SP_ELIMINAR
    (
        P_CODIGO        IN  PRODUCTO.CODIGO%TYPE,

        -- Auditoria
        P_AUD_IDUSUARIO IN  PRODUCTO.AUD_IDUSUARIO%TYPE,
        P_AUD_SESION    IN  PRODUCTO.AUD_SESION%TYPE,
        P_AUD_IP        IN  PRODUCTO.AUD_IP%TYPE
    ) AS
  BEGIN

    UPDATE 
        PRODUCTO
    SET
        ESTADO          =   '0',

        -- Auditoria
        AUD_TIPO        =   'E',
        AUD_IDUSUARIO   =   P_AUD_IDUSUARIO,
        AUD_SESION      =   P_AUD_SESION,
        AUD_IP          =   P_AUD_IP,
        AUD_FECHA       =   sysdate
    WHERE
        CODIGO          =   P_CODIGO;

  END SP_ELIMINAR;


END PKG_PRODUCTO;
