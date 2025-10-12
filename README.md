# Guía Paso a Paso: Creando un Proyecto Spark Java con Maven
Este documento te guiará a través del proceso  Seguiremos las convenciones estándar para asegurar que nuestro proyecto sea fácil de mantener y escalar.

## Prerrequisitos

* JDK (Java Development Kit), versión 8 o superior.

* Apache Maven.

Puedes verificar si están instalados ejecutando java -version y mvn -version en tu terminal.

### Paso 1: Generar la Estructura del Proyecto con un Arquetipo

Usaremos un arquetipo de Maven para crear la estructura de directorios estándar de un proyecto Java. Esto nos ahorra el trabajo de crear todas las carpetas manualmente.

-  Abre tu terminal o línea de comandos.

- Navega hasta el directorio donde quieres crear tu proyecto.

Ejecuta el siguiente comando. Este comando le dice a Maven que genere un proyecto a partir de la plantilla maven-archetype-quickstart de forma no interactiva.
```shell
mvn archetype:generate -DgroupId=com.miempresa.sparkapp \
                       -DartifactId=mi-proyecto-spark \
                       -DarchetypeArtifactId=maven-archetype-quickstart \
                       -DarchetypeVersion=1.4 \
                       -DinteractiveMode=false
```

Desglose del comando:

-DgroupId: El identificador de tu organización (generalmente un dominio invertido).

-DartifactId: El nombre de tu proyecto.

-DarchetypeArtifactId: La plantilla que usaremos (quickstart es ideal para una app Java simple).

Al finalizar, tendrás una nueva carpeta llamada mi-proyecto-spark con la estructura base de Maven.

### Paso 2: Configurar el pom.xml para Spark Java
El pom.xml generado es muy básico. Necesitamos editarlo para añadir las dependencias de Spark Java y configurar el plugin que nos permitirá crear un archivo JAR ejecutable.

Reemplaza el contenido de tu pom.xml con el siguiente código:
``` xml

<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
         
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.miempresa.sparkapp</groupId>
    <artifactId>mi-proyecto-spark</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- 1. Dependencia principal de Spark Java -->
        <dependency>
            <groupId>com.sparkjava</groupId>
            <artifactId>spark-core</artifactId>
            <version>2.9.4</version>
        </dependency>

        <!-- 2. Implementación simple de logging -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>1.7.32</version>
        </dependency>

        <!-- 3. Dependencia para tests -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Ejecutar la app con mvn exec:java -->
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.5.1</version>
                <configuration>
                    <mainClass>com.miempresa.sparkapp.App</mainClass>
                </configuration>
            </plugin>

            <!-- Crear un JAR ejecutable con dependencias -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.2.4</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>com.miempresa.sparkapp.App</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>


``` 

### Paso 3: Escribir el Código de la Aplicación

Ahora, vamos a modificar el archivo App.java que Maven creó para nosotros.

Navega a src/main/java/com/miempresa/sparkapp/App.java.

Reemplaza su contenido con este código para crear un servidor "Hola Mundo":

``` java
package com.miempresa.sparkapp;

import static spark.Spark.*; // Importamos los métodos estáticos de Spark

public class App {
    public static void main(String[] args) {
        // Establecemos el puerto en el que correrá la aplicación
        port(4567);

        // Creamos una ruta (endpoint) para la URL "/hello"
        // Cuando se reciba una petición GET, se ejecutará esta función lambda
        get("/hello", (req, res) -> "¡Hola Mundo desde Spark Java!");

        System.out.println("Servidor corriendo en http://localhost:4567");
    }
}
```

### Paso 4: Construir y Ejecutar el Proyecto
Ahora vamos a compilar, empaquetar y ejecutar nuestra aplicación.

Construir el proyecto: Vuelve a la raíz de tu proyecto en la terminal y ejecuta:
```shell 
mvn clean package
```
Este comando compilará tu código y creará un archivo JAR ejecutable en la carpeta target/.

Ejecutar la aplicación: Una vez que la construcción sea exitosa, ejecuta el JAR con el siguiente comando:

```shell 
java -jar target/mi-proyecto-spark-1.0-SNAPSHOT.jar
```

o también
```shell 
mvn exec:java
```



Verificar: Abre tu navegador web y ve a la dirección http://localhost:4567/hello.

¡Deberías ver el mensaje "¡Hola Mundo desde Spark Java!" en tu pantalla! Con esto, has creado y ejecutado exitosamente tu primera aplicación con Spark Java y Maven.