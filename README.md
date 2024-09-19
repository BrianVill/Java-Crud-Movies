# 🎥 Movie Voting API 🎬

Esta es una API REST que permite a los usuarios buscar, votar y gestionar películas. Las películas tienen un sistema de ranking basado en los votos de los usuarios. El backend permite realizar todas las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las películas.

## 🚀 Funcionalidades principales

-   **Buscar películas**: Encuentra películas por nombre o ID.
-   **Votar películas**: Los usuarios pueden votar por sus películas favoritas.
-   **Ranking de películas**: Ordena las películas según los votos recibidos.
-   **Operaciones CRUD**: Añade, actualiza o elimina películas del sistema.

## 🛠️ Tecnologías utilizadas

-   **Java 22** y **Spring Boot**.
-   **Spring Data JPA** para la gestión de base de datos.
-   **MySQL** como base de datos.
-   **Maven** para la gestión de dependencias.

## 📚 Endpoints principales

### Películas

-   **GET /api/movies**: Lista todas las películas.
-   **GET /{id}**: Obtiene una película por su ID.
-   **POST /api/movies**: Crea una nueva película.
-   **PUT /{id}**: Actualiza los datos de una película.
-   **DELETE /{id}**: Elimina una película.

### Votaciones

-   **POST /vote/{id}**: Vota por una película.

### Ranking

-   **GET /vote/{id}/{rating}**: Lista las películas ordenadas por votos.

## ⚙️ Instalación

1.  Clona este repositorio:
    
    `git clone https://github.com/BrianVill/Java-Crud-Movies.git
    cd Java-Crud-Movies` 
    
2.  Configura la base de datos en `application.properties` para conectar a MySQL:
    
    `spring.datasource.url=jdbc:mysql://localhost:3306/nombre_base_datos
    spring.datasource.username=usuario
    spring.datasource.password=contraseña` 
    
3.  Ejecuta el proyecto:
    
    
    `./mvnw spring-boot:run` 
    

## 🧪 Pruebas

Prueba los endpoints usando herramientas como **Postman** o **cURL**.
