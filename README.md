# library-api

API GraphQL que gestiona información de libros y autores.

# Estructura de archivos

src
├── main
│ ├── java
│ │ └── com.example.libraryapi
│ │ ├── model # Clases de modelo como Book y Author
│ │ ├── repository # Repositorios para acceder a los datos
│ │ ├── service # Lógica de negocio
│ │ └── resolver # Resolvers para las operaciones GraphQL
│ └── resources
│ ├── application.properties # Configuración de la base de datos
│ └── schema.graphqls # Archivo del esquema GraphQL
