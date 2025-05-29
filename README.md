# FortBank ATM

FortBank ATM es una aplicación web desarrollada en Java con Spring Boot que simula el funcionamiento de un cajero automático bancario. Permite la gestión de clientes, cuentas, movimientos y operaciones bancarias básicas, tanto para administradores como para cajeros.

## Características principales

- **Gestión de clientes:** Crear, editar, desbloquear y administrar clientes del banco.
- **Gestión de cuentas:** Crear cuentas bancarias, asociarlas a clientes y consultar información relevante.
- **Operaciones bancarias:** Realizar depósitos, retiros, transferencias y consultar movimientos de cuenta.
- **Roles diferenciados:** Interfaz y funcionalidades separadas para administradores y cajeros.
- **Seguridad:** Inicio de sesión para ambos roles y control de acceso a las funcionalidades.

## Estructura del proyecto

```
ATM/
├── src/
│   ├── main/
│   │   ├── java/com/fortbank/ATM/
│   │   │   ├── controller/         # Controladores web (Admin, Cajero)
│   │   │   ├── dto/                # Objetos de transferencia de datos
│   │   │   ├── entity/             # Entidades JPA (Cliente, Cuenta, Movimiento, etc.)
│   │   │   ├── repository/         # Repositorios Spring Data JPA
│   │   │   └── services/           # Lógica de negocio
│   │   └── resources/
│   │       ├── static/styles/      # Archivos CSS
│   │       └── templates/          # Vistas Thymeleaf (HTML)
│   └── test/                       # Pruebas unitarias
├── pom.xml                         # Dependencias Maven
└── README.md                       # Este archivo
```

## Requisitos previos

- Java 17 o superior
- Maven 3.6+

## Instalación y ejecución

1. Clona el repositorio:
   ```bash
   git clone <URL-del-repositorio>
   cd ATM
   ```
2. Compila y ejecuta la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```
   O bien, usando Maven instalado globalmente:
   ```bash
   mvn spring-boot:run
   ```
3. Accede a la aplicación en tu navegador en:
   - [http://localhost:8080/admin](http://localhost:8080/admin) (Administrador)
   - [http://localhost:8080/cajero/login](http://localhost:8080/cajero/login) (Cajero)

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- H2 Database (por defecto, para pruebas)
- HTML5, CSS3

## Capturas de pantalla

A continuación se muestran algunas vistas de la aplicación:

![Menú de administración](./capturas/Menu-administracion.png)
![Login](./capturas/Login.png)
![Menú de cajero](./capturas/Menu-Cajero.png)

## Créditos

Desarrollado por Kevin Velez y el docente Daniel para la materia de Construcción de Software.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

---

Si tienes dudas, sugerencias o encuentras algún error, por favor abre un issue o contacta al autor.
