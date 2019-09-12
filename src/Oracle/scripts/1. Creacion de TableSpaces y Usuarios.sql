
-- Creacion de tablespaces

CREATE TABLESPACE tsExamenGalaxy_data
   DATAFILE 'C:\oraclexe\app\oracle\oradata\XE\tsExamenGalaxy_data.dbf'
   SIZE 10M REUSE
   AUTOEXTEND ON NEXT 1M MAXSIZE unlimited
   EXTENT MANAGEMENT LOCAL
   SEGMENT SPACE MANAGEMENT AUTO;
   
-- Creé este usuario para importar el .dmp del último proyecto
   
CREATE TABLESPACE tsExamenGalaxy_indx
   DATAFILE 'C:\oraclexe\app\oracle\oradata\XE\tsExamenGalaxy_indx.dbf'
   SIZE 10M REUSE
   AUTOEXTEND ON NEXT 1M MAXSIZE unlimited
   EXTENT MANAGEMENT LOCAL
   SEGMENT SPACE MANAGEMENT AUTO;

CREATE USER JW22SP2 IDENTIFIED BY 123456
   DEFAULT TABLESPACE tsExamenGalaxy_data  
   TEMPORARY TABLESPACE temp
   QUOTA UNLIMITED ON tsExamenGalaxy_data;
   
grant all privileges to JW22SP2;   

grant dba, connect to JW22SP2;   

-- Creé este usuario para que sea aquí donde se desarolle mi examen

CREATE USER AZALDEGUI IDENTIFIED BY 123456
   DEFAULT TABLESPACE tsExamenGalaxy_data  
   TEMPORARY TABLESPACE temp
   QUOTA UNLIMITED ON tsExamenGalaxy_data;
   
grant all privileges to AZALDEGUI;   

grant dba, connect to AZALDEGUI;   
   

   
   
