# 🗺️ MetaMapa — Sistema de gestión de mapeos colaborativos

> Trabajo Práctico Anual Integrador — Diseño de Sistemas de Información — UTN FRBA 2025

MetaMapa es un sistema de código abierto para la **recopilación, visualización y mapeo colaborativo de información**. Fue diseñado para que ONGs, universidades y organismos estatales puedan instalarlo en sus propios servidores y ofrecerlo a sus comunidades. Permite reportar y visualizar hechos geolocalizados como focos de incendio, desapariciones, contaminación ambiental y más.

---

## 🧩 Funcionalidades implementadas

### Gestión de fuentes y colecciones
- **Fuentes estáticas**: importación de hechos desde archivos CSV con más de 10.000 registros
- **Fuentes dinámicas**: carga colaborativa de hechos por contribuyentes anónimos o registrados
- **Fuentes proxy**: integración con sistemas externos (Fuente Demo y otras instancias MetaMapa vía REST)
- **Fuente agregadora**: combina múltiples fuentes con copias locales actualizadas periódicamente
- **Colecciones**: conjuntos de hechos con criterios de pertenencia configurables por administradores

### Algoritmos de consenso
- Múltiples menciones, mayoría simple y absoluta
- Modos de navegación: irrestricto y curado

### Persistencia y datos
- ORM con Hibernate + JPA sobre MySQL 8
- Búsqueda por texto libre (Full Text Search)
- Estadísticas periódicas por provincia, categoría, hora del día y solicitudes spam
- Exportación de estadísticas en formato CSV

### Interfaz web MVC
- Cliente liviano renderizado del lado del servidor con Javalin + Handlebars
- Navegación y filtrado de colecciones y hechos
- Panel de administración: fuentes, colecciones y solicitudes de eliminación
- Soporte para carga de contenido multimedia

### Automatización
- Detección automática de solicitudes de eliminación spam
- Tareas calendarizadas para actualización de fuentes y recálculo de estadísticas

---

## 🛠️ Stack tecnológico

| Tecnología | Uso |
|---|---|
| Java 17 | Lenguaje principal |
| Javalin 6 | Servidor web |
| Hibernate + JPA | ORM y persistencia |
| MySQL 8 | Base de datos |
| Handlebars | Motor de templates |
| Docker + Docker Compose | Contenedorización y despliegue |
| Maven | Gestión de dependencias y build |

---

## 🚀 Cómo levantar el proyecto

### Requisitos
- [Docker Desktop](https://www.docker.com/get-started) instalado y corriendo

### 1. Clonar el repositorio

```bash
git clone https://github.com/<tu-usuario>/metamapa-dds-2025
cd metamapa-dds-2025
```

### 2. Configurar variables de entorno

```bash
cp .env.example .env
```

> Los valores por defecto funcionan para desarrollo local, no es necesario cambiarlos.

### 3. Levantar con Docker

```bash
docker compose up --build
```

La primera vez puede tardar unos minutos. Descarga MySQL, compila la app y carga los datos iniciales automáticamente.

### 4. Acceder

```
http://localhost:9001
```

---

## ⚙️ Comandos útiles

| Comando | Descripción |
|---|---|
| `docker compose up --build` | Primera vez o tras cambios en el código |
| `docker compose up` | Levantar sin recompilar |
| `docker compose down` | Bajar los contenedores |
| `docker compose down -v` | Bajar y resetear la base de datos |
| `docker compose logs -f app` | Ver logs en tiempo real |

---

## 📁 Estructura del proyecto

```
src/main/java/ar/edu/utn/frba/dds/
├── controllers/     # Controladores HTTP (Javalin)
├── model/           # Dominio: hechos, fuentes, colecciones, criterios
├── repositorios/    # Acceso a datos (JPA)
├── scripts/         # Bootstrap 
└── server/          # Punto de entrada, rutas y configuración del servidor
```

---

## 🎓 Contexto académico

| | |
|---|---|
| Materia | Diseño de Sistemas de Información |
| Universidad | UTN FRBA |
| Año | 2025 |
| Modalidad | Trabajo grupal |

### Entregas
1. Fuentes estáticas, colecciones, hechos y solicitudes de eliminación
2. Fuentes dinámicas, fuentes proxy, detección de spam
3. Servicio agregador, algoritmos de consenso, tareas asíncronas
4. Persistencia con ORM, estadísticas, búsqueda full text
5. Interfaz web MVC y contenido multimedia
6. Despliegue con Docker y Docker Compose
