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

       get("/login", (req, res) -> "¡ventana de login!");

        System.out.println("Servidor corriendo en http://localhost:4567");



    }
}