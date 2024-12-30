# Documentación del servicio

  
Servicio Realizado por Juan Manuel Rodriguez Irausquin

Prueba inditex


Los owners del servicio son:

| Tipo Owner    |     Nombre     |                   Contacto |
| ------------- |:--------------:|---------------------------:|
| Técnico       | Juan Rodriguez | jrirausquin.1995@gmail.com |



Este servicio resume los puntos de entrada al servicio vía API Rest:

| Operación         | Método               | Path    | Descripción                                                 
|-------------------| --------------------  |---------|-------------------------------------------------------------|
| Obtener Precio    |  GET  | /prices | Obtiene el precio mediante<br/>los parametros seleccionados |

Este proyecto se construye mediante la herramienta Maven. Si se quieren ejecutar todas las fases, basta con ejecutar 
desde la ráiz del proyecto

````shell script
mvn clean install
````

El proyecto se ejecuta mediante la instrucción, utilizándose las propiedades del perfil local:

````shell script
mvn spring-boot:run -Dspring-boot.run.profiles=local
````

Una vez levantado, se ejecuta en local en el puerto 8080.
El api del servicio se puede consultar localmente en: http://localhost:8080/swagger-ui.html

# Información relevante

En la carpeta raiz del proyecto se adjuntó una colección de postman con los casos de prueba establecidos anteriormente
en la definición de la prueba.

Se utiliza la base da datos H2 para la gestión de los datos almacenados. Para revisar que registros se poseen se puede 
consultar localmente en: http://localhost:8080/h2-console O en scripts data.sql y schema.sql que encontrados en la
carpeta resources
