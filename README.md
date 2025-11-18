# UQ Fit Manager
### Sistema de Gestión para el Gimnasio UQ Fit  
**Proyecto Final - Programación I (2025-2)**  
Universidad del Quindío

---

### Integrantes del equipo
- MinusAndrew – Frontend, JavaFX, Controladores, Interfaz Gráfica, Pruebas Unitarias, Excepciones.
- Jacobo Londoño – Backend, Lógica de Negocio, Modelos.

---

### Descripción del Proyecto

UQ Fit Manager es una aplicación de escritorio desarrollada en **Java + JavaFX** que permite modernizar la administración del Gimnasio UQ Fit. 
Reemplaza procesos manuales por un sistema digital seguro, intuitivo y con control de roles.

#### Funcionalidades implementadas
- Registro y gestión completa de usuarios (Estudiantes UQ, Trabajadores UQ, Externos con descuentos automáticos)
- Membresías: Básica, Premium y VIP y fechas de vencimiento
- Reserva de clases grupales con control de cupos y entrenador asignado
- Control de acceso mediante cédula
- Autenticación por roles (Recepcionista / Administrador)
- Reportes básicos (usuarios activos, clases más populares, vencimientos de membrecia próximos)
- Excepciones personalizadas con mensajes amigables
- Arquitectura MVC estricta*
- Pruebas unitarias con JUnit 5 (cobertura parcial del modelo)
- Control de versiones completo con Git + GitHub (commits de ambos integrantes)

#### Funcionalidades Faltantes
- Persistencia de datos (serialización / base de datos)
- Fotos de perfil de usuarios
- Estilización avanzada con CSS (interfaz funcional pero básica)
- Reportes avanzados del administrador (ingresos, gráficos, estadísticas históricas)
- Uso completo de las fachadas `Admin.java` y `Receptionist.java` (acoplamiento directo desde controladores)

> Estas limitaciones se reconocen explícitamente en la documentación entregada y representan valiosas lecciones de planificación y alcance realista.

---

### Tecnologías utilizadas
- **Java 17+**
- **JavaFX** (FXML + Scene Builder)
- **JUnit 5** (pruebas unitarias)
- **Git & GitHub** (control de versiones)
- **Jira** (gestión de tareas y sprints)
- **IntelliJ IDEA** (IDE principal)

---
