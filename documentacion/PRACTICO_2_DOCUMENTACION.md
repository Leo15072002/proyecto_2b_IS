# Práctico 2B: Documentación y Análisis de Diseño

Este repositorio contiene el trabajo práctico 2B, fork del proyecto base de la cátedra.

**Grupo:**
* Agostina Cruceño
* Ana Luz Masoero
* Leonardo Campos
* Yaideem Testa
* Tomas Monzon
* Manuel Barbieri Pariani

---

## Análisis del Código Base y Patrones de Diseño

A continuación, se documenta el análisis solicitado sobre el patrón de diseño identificado en el código base proporcionado por la cátedra.

### 1. ¿Qué patrón identificaron?

El patrón de diseño que identificamos en el código base es el **[Nombre del Patrón]**. 
(Por ejemplo: *Patrón DAO (Data Access Object)*, *Patrón Singleton*, *Patrón Factory Method*, *Patrón MVC*, etc.)

### 2. ¿Dónde y cómo se aplica en el código?

Se ve reflejado principalmente en la clase DBConfigSingleton, ya que posee el constructor privado "DBConfigSingleton()" y ademas tambien el getInstance() de tipo DBConfigSingleton (la misma clase), donde corrobora que la instancia esté creada o la crea, en caso contrario, retorna dicha instanciaa
Este patrón se puede observar principalmente en las siguientes clases y paquetes:
* ⁠⁠ src/main/java/com/paquete/is1/proyecto/config/DBConfigSingleton ⁠

Luego, App usa esta instancia para abrir y cerrar la conexión de ActiveJDBC (Base.open y Base.close) dentro de los filtros before y after de Spark, asegurando que todos los procesos utilicen la misma configuración.

### 3. ¿Qué problema resuelve este patrón en ese contexto?

En el contexto específico del sistema de gestión estudiantil (particularmente en el login y gestión de usuarios), este patrón resuelve el problema de...
(Por ejemplo: *...asegurar una única conexión a la base de datos*, o *...desacoplar la lógica de la aplicación de cómo se guardan los datos*, o *...centralizar la creación de objetos de tipo Usuario*).