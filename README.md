# Foro Hub

Foro Hub es una API para registrar tópicos, autores de tópicos, respuestas a los tópicos, cursos y perfiles de usuario.
Esta API está construida usando Spring Boot y diversas tecnologías para garantizar seguridad y eficiencia en el manejo
de datos.

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para la construcción de la aplicación.
- **JWT (JSON Web Tokens)**: Utilizado para la autenticación y autorización de usuarios.
- **Spring Security**: Framework de seguridad para gestionar la autenticación y autorización.
- **PostgreSQL**: Base de datos relacional utilizada para almacenar los datos.
- **JPA (Java Persistence API)**: Para la gestión de la persistencia de datos.
- **FlywayDB**: Herramienta para la migración de esquemas de bases de datos.

## Funcionalidades

- **Tópicos**: Registro y gestión de tópicos.
- **Autores de Tópicos**: Registro y gestión de autores de tópicos.
- **Respuestas a Tópicos**: Registro y gestión de respuestas a los tópicos.
- **Cursos**: Registro y gestión de cursos.
- **Perfiles de Usuario**: Registro y gestión de perfiles de usuario.

## Requisitos Previos

- Java 11 o superior
- Maven 3.6.0 o superior
- PostgreSQL 12 o superior

## Instalación

1. Clona el repositorio:

   ```bash
   git clone url_de_este_repositorio
   cd foro-hub

## Configuracion de Variables de entorno

2. Configura las variables de entorno para la base de datos PostgreSQL. Añade las siguientes variables a tu entorno:

    ```bash
    export DB_HOST=jdbc:postgresql://localhost:5432/foro_hub_db
    export DB_USER=tu_usuario
    export DB_PASSWORD=tu_contraseña
    export JWTSecret=tu_secret_jwt

3. Asegúrate de que el archivo application.properties está configurado para usar estas variables de entorno:

   ```properties
   spring.datasource.url=${DB_URL}
   spring.datasource.username=${DB_USERNAME}
   spring.datasource.password=${DB_PASSWORD}
    
4. Compila y ejecuta la aplicación:

   ```bash
   mvn spring-boot:run

5. Pruebas Postman/Insomnia

   Puedes realizar pruebas usando el archivo de request ubicado en **/resources/postman** importandolo en tu cliente
   http

## Uso

Cada endpoint de la API requiere un token JWT válido para poder acceder y registrar datos. Para obtener un token, los
usuarios deben autenticarse usando las credenciales adecuadas.

Endpoints

- /topico: Gestión de tópicos.
- /usuario: Gestión de autores de tópicos.
- /respuesta: Gestión de respuestas a los tópicos.
- /curso: Gestión de cursos.
- /perfil: Gestión de perfiles de usuario.

## Autenticación

Para autenticarse, los usuarios deben enviar sus credenciales a /token. Si las credenciales son válidas, recibirán un
token JWT que debe ser incluido en las cabeceras de las solicitudes subsiguientes:

   ```http
   Authorization: Bearer <tu-token-jwt>
   ```

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue para discutir cualquier cambio significativo antes de
enviar un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Para más detalles, consulta el archivo LICENSE.


