# Proyecto de Solicitud

Este proyecto es una aplicación de gestión de solicitudes construida con Spring Boot y PostgreSQL. A continuación, se proporcionan instrucciones para configurar y ejecutar el proyecto utilizando Docker Compose, así como información sobre las versiones de Java necesarias.

## Requisitos

- Java 17
- Docker
- Docker Compose

## Configuración

### Java

Asegúrate de tener Java 17 instalado. Puedes verificar tu versión de Java con el siguiente comando:

```sh
java -version
```

### Docker
Asegúrate de tener Docker y Docker Compose instalados. Puedes verificar la instalación de Docker con el siguiente comando:

```sh
docker --version
```

Y para Docker Compose:
```sh
docker-compose --version
```

### Levantar los Contenedores

Para levantar los contenedores, ejecuta el siguiente comando en el directorio raíz de tu proyecto, donde se encuentra el archivo docker-compose.yml:

```sh
docker-compose up -d
```

### Detener los Contenedores
```sh
docker-compose down
```