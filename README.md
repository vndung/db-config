## db-config

_**db-config** utility used to migrate sql schema, data._
 
 ##### db-config.properties
 This file contains configured properties:
 
  - _config-properties-file:_ properties file contains jdbc connection, username, password
  - _db-migration-dir:_ where contains SQL scripts
  
For example:
If you want to migrate sql scripts to H2 database, you will config

    config-properties-file=../conf/application.properties
    db-migration-dir=../conf/db/
    
In file **../conf/application.properties**

    sonar.jdbc=jdbc:h2:file:./target/foobar
    sonar.user=sa
    sonar.password=
    
In **../conf/db/** folder

_V1__Create_person_table.sql_

    create table PERSON (
        ID int not null,
        NAME varchar(100) not null
    );
    
This is just an example that read config data from a properties file 
and migrate these data into database.


 