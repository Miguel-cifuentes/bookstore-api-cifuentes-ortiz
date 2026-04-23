Bookstore API

API REST desarrollada con Spring Boot para la gestión de una tienda de libros. Incluye autenticación con JWT, gestión de usuarios, autores, categorías, libros y pedidos.

Tecnologías utilizadas

Java 17 o superior (compatible con Java 21/25), Spring Boot 4, Spring Security con JWT, Spring Data JPA (Hibernate), base de datos H2 en memoria, Maven y Lombok.

Estructura del proyecto

El proyecto sigue una arquitectura organizada en paquetes: controller, service, impl, repository, entity, dto, mapper, security, config y exception dentro del paquete base com.example.bookstoreapi.

Configuración del proyecto
Requisitos previos

Debes tener instalado JDK 17 o superior, Maven y opcionalmente un IDE como IntelliJ IDEA.

Base de datos (H2)

El proyecto utiliza una base de datos H2 en memoria, por lo que no necesitas instalar ningún motor adicional. Puedes acceder a la consola en la URL http://localhost:8080/h2-console
usando la configuración: JDBC URL jdbc:h2:mem:testdb, usuario "sa" y contraseña vacía.

Configuración JWT

En el archivo src/main/resources/application.properties debes definir las siguientes propiedades:

spring.application.name=bookstore-api
app.jwt.secret=TU_CLAVE_BASE64_SEGURA
app.jwt.expiration=86400000

Se recomienda generar una clave segura en formato Base64 de al menos 256 bits.

Ejecución del proyecto

Puedes ejecutar la aplicación de dos formas:

Desde IntelliJ IDEA, ejecutando la clase principal BookstoreApiApplication.java.

Desde terminal, utilizando los comandos:
mvn clean install
mvn spring-boot:run

Una vez iniciado, la API estará disponible en http://localhost:8080
.

Autenticación

Para utilizar la API es necesario registrarse y luego iniciar sesión.

Registro

Endpoint POST /auth/register con el siguiente cuerpo JSON:
{
"name": "Miguel",
"email": "miguel@test.com
",
"password": "123456"
}

Login

Endpoint POST /auth/login con el siguiente cuerpo JSON:
{
"email": "miguel@test.com
",
"password": "123456"
}

La respuesta incluirá un token JWT, el tiempo de expiración y el rol del usuario.

Uso del token

Para acceder a los endpoints protegidos debes incluir el token en los headers de la siguiente manera:

Authorization: Bearer TU_TOKEN
Content-Type: application/json

Endpoints principales

Libros (acceso público): GET /books, GET /books/author/{id}, GET /books/category/{id}, POST /books.
Autores (protegido): GET /authors, POST /authors, PUT /authors/{id}, DELETE /authors/{id}.
Categorías (protegido): GET /categories, POST /categories, PUT /categories/{id}, DELETE /categories/{id}.
Pedidos (protegido): POST /orders, GET /orders, GET /orders/{id}.

Manejo de errores

La API cuenta con un manejador global de excepciones que devuelve respuestas estructuradas en formato JSON con estado, código, mensaje y timestamp.

Pruebas

Se recomienda usar Postman. El flujo básico consiste en registrar un usuario, iniciar sesión, copiar el token y usarlo en los endpoints protegidos.

Modelo de datos

Las entidades principales del sistema son User, Role, Book, Author, Category, Order y OrderItem, con relaciones uno a muchos y muchos a muchos según corresponda.

Autores

Miguel Cifuentes - Mateo Ortiz - Ruben Viasus