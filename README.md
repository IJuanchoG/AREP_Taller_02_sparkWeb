#Aplicacion SparkWebAPP con servicio como Calculadora de estadística

Esta libreria está implementada en **JAVA** para la materia de **AREP**

Su principal funcionamiento se centra en una Calculadora de estadistica WEB con las funciones de **promedio** y **desviación media** implementadas, se ha realizado la construcción de una **Linked  List** a partir de la teoría conocida y por la cual se generan los calculos necesarios. el servicio web se encuentra alojado en Heroku.

Para conocer mayor información de la implementación del sistema puede ver el documento [INFORME](AREP_TALLER02.pdf)

## Getting Started

Principalmente se recomienda clonar el repositorio a su computadora, como opción puede realizarlo por medio del siguiente comando:

``` git clone https://github.com/IJuanchoG/AREP_Taller_02_sparkWeb.git```

La construcción del proyecto se ha realizado por medio de **MAVEN**, es por este motivo que puede ser necesario tener la herramienta en su dispositivo. 

Para compilar el proyecto, ejecute el siguiente comando:

```mvn compile```

posteriormente puede hacer el empaquetado:

``` mvn package```

para verificar el correcto funcionamiento de las librerias es recomendable ejecutar las pruebas presentes en estos,
se pueden ejecutar desde el IDE de preferencia o desde comandos MVN tales como 

```mvn surefire:test```

Con el fin de correr el programa ejecute la siguiente instrucción:

###Windows:
```
java -cp target/classes;target/dependency/* edu.eci.arep.sparkwebapp.SparkWebApp
```

###Linux:
```
java -cp target/classes:target/dependency/* edu.eci.arep.sparkwebapp.SparkWebApp
```

##Información de la lista encadenada creada: ejemplo.

 <img width="796" alt="LinkedLinkExample" src="https://user-images.githubusercontent.com/49318314/90288675-fdc3e080-de3f-11ea-856a-19bfed8bea59.png">
 
 Igualmente, los valores calculados por parte de la sección dinámica.
 
 <img width="165" alt="Desviacion" src="https://user-images.githubusercontent.com/49318314/90288600-d240f600-de3f-11ea-9111-1e5e5edcc77e.png">
 
 ### Prerequisitos.

Es necesario/recomendable que posea las siguientes herramientas:

- git instalado en su computador.
- Maven configurado en sus **Variables de Entorno**.
- Interprete de lenguaje de programacion **JAVA** (Eclipse, netbeans, Intellij, etc.)

si necesita instalar algunos de los servicios mencionados puede encontrarlos aquí:

- **Git** puede descargarlo [aqui.](https://git-scm.com/downloads)

- **Maven** puede descargarlo [aqui.](https://maven.apache.org/download.cgi)

- **IntelliJ** puede descargarlo [aqui.](https://www.jetbrains.com/es-es/idea/download/)

- **Heroku** puede descargarlo [aqui.](https://devcenter.heroku.com/articles/heroku-cli#download-and-install)

 ## Running the tests
Las pruebas se corren por medio del comando:
```
mvn surefire:test
```

como resultado se ve lo siguiente:

<img width="634" alt="pruebas" src="https://user-images.githubusercontent.com/49318314/90284000-d61c4a80-de36-11ea-83cd-441c4ecdb6c5.png">


Estas pruebas son automáticas, si desea realizar más pruebas puede hacerlo manualmente o agregando más cualquiera de los archivos encontrados en la ruta **src\test\java\edu\eci\arep\msc\mystatcal**
o en la ruta  **src\test\java\edu\eci\arep\msc\sparkwebapp**

Las pruebas fueron realizadas a partir de casos de usos que seguramente se verían envueltos en el funcionamiento del programa. entre ellos tenemos pruebas como:

```
@Test
    public void shouldAssignTypeDouble(){
        MyOwnLinkedList parse = DataTypePersistence.parse(dataDouble);
        assert parse != null;
        Assert.assertEquals(parse.getDataType(),"double");
    }
```

 En la que se evalúa el correcto funcionamiento del programa a la hora de realizar un *parse* a los valores de los nodos
 
Las pruebas buscan de manera efectiva probar el funcionamiento del programa y como se desempeñaría en otros casos de uso



## Built With

* [IntelliJ](https://www.jetbrains.com/es-es/idea/) - The develop enviroment
* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](https://junit.org/junit5/) - Used to generate Unitary Test
* [Heroku](https://devcenter.heroku.com/) - used to deploy

## Authors

* **Juan Carlos García** - *Initial work* - [IJuanchoG](https://github.com/IJuanchoG)


## License

Este proyecto es de libre uso y distribución, para más detalles vea el archivo [LICENSE.md](LICENSE.md).

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
