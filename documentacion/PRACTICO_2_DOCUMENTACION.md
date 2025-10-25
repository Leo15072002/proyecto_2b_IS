# Práctico 2B: Documentación y Análisis de Diseño

Este repositorio contiene el trabajo práctico 2B, fork del proyecto base de la cátedra.

**Grupo:**
* Agostina Cruceño
* Ana Luz Masoero
* Leonardo Campos
* Yaideem Testa
* Tomas Monzon
* Manuel Barbieri

---

## Análisis del Código Base y Patrones de Diseño

A continuación, se documenta el análisis solicitado sobre el patrón de diseño identificado en el código base proporcionado por la cátedra.

### 1. ¿Qué patrón identificaron?

El patrón de diseño que identificamos en el código base es el **[Nombre del Patrón]**. 
(Por ejemplo: *Patrón DAO (Data Access Object)*, *Patrón Singleton*, *Patrón Factory Method*, *Patrón MVC*, etc.)

### 2. ¿Dónde y cómo se aplica en el código?

Este patrón se puede observar principalmente en las siguientes clases y paquetes:
* `src/main/java/com/paquete/ejemplo/ClaseDondeEstaElPatron.java`
* `src/main/java/com/paquete/ejemplo/OtraClaseQueLoUsa.java`

Se implementa de la siguiente manera: 
(Aquí explican con sus palabras cómo funciona. Por ejemplo: *La clase `X` tiene un método estático `getInstance()` que asegura que solo exista una instancia...* o *La clase `UsuarioDAO` implementa una interfaz `DAO` que define los métodos CRUD (Crear, Leer, Actualizar, Borrar) para separar la lógica de negocio del acceso a la base de datos...*)

### 3. ¿Qué problema resuelve este patrón en ese contexto?

En el contexto específico del sistema de gestión estudiantil (particularmente en el login y gestión de usuarios), este patrón resuelve el problema de garantizar una unica fuente de configuración: la aplicación solo necesita una configuración de base de datos (una URL, un driver, un usuario). Si permitieras crear múltiples instancias (new DBConfigSingleton()), podrías tener accidentalmente diferentes partes de tu aplicación intentando conectarse a bases de datos distintas o con credenciales diferentes. El Singleton fuerza a que solo exista un objeto de configuración.