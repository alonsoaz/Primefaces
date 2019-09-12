spool  pruebaEjec.SPListarDetalle00.log
set pagesize 250;
set linesize 250;
set serveroutput on;
set verify off;

--****************************************************--
/* 
 FUNCIONALIDAD: Ejm que invoca a un paquete.sp que realiza:
 La busqueda de paises cladificados por rango de fechas P_FECHA_INI, P_FECHA_FIN
 
 SALIDA: De ser exitoso sera devuelto en un cursor AVANZADO que contienen el listado de paises de clasificados, cada registro del cursor tiene 5 campos
 
 NOTA:   Se hace un claro ejemplo del uso de cursores y bucles para recorrer el cursor
*/
--****************************************************--
DECLARE

--variables de Entrada
    P_CODIGO  PRODUCTO.CODIGO%TYPE;
    P_CURSOR 	SYS_REFCURSOR;
    
    vcodigo        PRODUCTO.CODIGO%TYPE;
    vserie              PRODUCTO.SERIE%TYPE;
    vdescripcion   PRODUCTO.DESCRIPCION%TYPE;
    vprecio           PRODUCTO.PRECIO%TYPE;
    vmarca           PRODUCTO.MARCA%TYPE;
    vmodelo        PRODUCTO.MODELO%TYPE;

begin
  --seteo de parametros de entrada
  P_CODIGO      := 21;
  
  PKG_PRODUCTO.SP_BUSCAR_X_ID(
      P_CURSOR,
      P_CODIGO
  );

  --pintado de variables de salidA

  
  --Recorrido del cursor
    FETCH P_CURSOR INTO vcodigo, vserie, vdescripcion, vprecio, vmarca, vmodelo;
     
     WHILE P_CURSOR%FOUND LOOP
           dbms_output.put_line(vcodigo       || ' | ' || vserie              || ' | ' || vdescripcion   || ' | ' ||
                                vprecio          || ' | ' || vmarca            || ' | ' || vmodelo  || CHR(10));
        FETCH P_CURSOR INTO vcodigo, vserie, vdescripcion, vprecio, vmarca, vmodelo;
    END LOOP;
       
    CLOSE P_CURSOR;
     
end;
/
