# FitnessTracke - Full-Stack Fitness Monolith

A full-stack fitness application built with Spring Boot and Java 21 to track workouts, log daily exercise routines, and monitor fitness progress dynamically over time. The entire application infrastructure is containerized using Docker and Docker Compose for fast, effortless local deployment.

---

## 🛠️ Tech Stack & Architecture

- **Backend Framework:** Spring Boot (v4.1.0)
- **Language Level:** Java 21 (Eclipse Temurin distribution)
- **Database Engine:** MySQL 8.0
- **Object-Relational Mapping:** Hibernate / Spring Data JPA
- **Containerization:** Docker & Docker Compose (Multi-stage builds)

---

## 🚀 Getting Started (Quick Run via Docker Compose)

The easiest way to run the complete environment (the Java app and the MySQL database combined) is using Docker Compose. This completely eliminates the need to install Java or MySQL locally on your computer.

### Prerequisites
Make sure you have [Docker Desktop](https://docker.com) installed and running on your system.

### Running the Application

1. **Clone the repository:**
   ```bash
   git clone https://github.com
   cd FitnessTracke
   ```

2. **Boot the complete environment:**
   Run the compose orchestrator. It will automatically download the isolated database container, compile your Spring Boot Java source code internally using a multi-stage Docker environment, map the connection channels, and launch the server:
   ```powershell
   # If your CLI requires an explicit API version assignment:
   \$env:DOCKER_API_VERSION="1.41"; docker compose up --build
   ```

3. **Access the application:**
   Once the console displays the Spring Boot startup banner, open your web browser or Postman and hit:
    - Main Endpoint: `http://localhost:8080`

---

## 💾 Infrastructure Configurations

Docker Compose isolates the micro-network between your backend container and the relational storage layer automatically. The network properties track the following environmental variables:

| Environment Variable | Production Value | Purpose |
| :--- | :--- | :--- |
| `SPRING_DATASOURCE_URL` | `jdbc:mysql://db:3306/fitness` | Direct inner container bridge endpoint |
| `SPRING_DATASOURCE_USERNAME` | `root` | Master database administrative profile |
| `SPRING_DATASOURCE_PASSWORD` | `Pas1818wan@123` | Secured access parameter |

*Note: Data persists across container teardowns using a dedicated named Docker volume volume (`mysql_data`).*

---

## 🐋 Standalone Docker Image Management (With Docker Only)

If you need to build, run, or export the application image independently without using the full orchestration layer of Docker Compose, use the following native commands:

### 1. Build the Isolated Image
Compile and wrap the application using the multi-stage Dockerfile environment (bypasses local Java compiler restrictions entirely):
```powershell
\$env:DOCKER_API_VERSION="1.41"; docker build -t fitness-monolith-app .
```

### 2. Run the Container Separately
Launch the standalone application container and route it directly to your computer's local network mapping:
```powershell
\$env:DOCKER_API_VERSION="1.41"; docker run -p 8080:8080 --name fitness-app-running -e SPRING_DATASOURCE_URL="jdbc:mysql://host.docker.internal:3306/fitness" -e SPRING_DATASOURCE_USERNAME="root" -e SPRING_DATASOURCE_PASSWORD="Pas1818wan@123" fitness-monolith-app
```

### 3. Extract the Compiled JAR from the Image
If you need the raw executable `.jar` file on your host machine without installing Maven or a JDK, pull it directly out of the built image filesystem:
```powershell
docker run --rm --entrypoint /bin/sh fitness-monolith-app -c "cat /app/app.jar" > target/fitness-monolith-0.0.1-SNAPSHOT.jar
```
