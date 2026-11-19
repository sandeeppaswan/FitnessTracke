# 🏋️ Fitness Tracker (`FitnessTracke`)

A full-stack fitness application to track workouts, log daily exercise routines, and monitor fitness progress over time, backed by **MySQL**.

## ✨ Features
* **Workout Tracking:** Log daily exercises, sets, reps, and weights in one place.
* **Routine Management:** Organize structured workout routines tailored to your fitness goals.
* **Progress Monitoring:** Track workout consistency and performance improvements over time.
* **Persistent Storage:** Stores user routines and workout history reliably using **MySQL**.
* **Monolithic Architecture:** Clean, unified project structure inside the `fitness-monolith` module.
* **Containerized Deployment:** Ready to run anywhere using Docker.

## 🛠️ Tech Stack
* **Backend:** Java, Spring Boot (`fitness-monolith`)
* **Database:** MySQL
* **Build Tool:** Apache Maven
* **Containerization:** Docker

## 🐳 Docker Hub
* **Docker Hub Image:** [sandeep2026paswan/fitness-mono](https://docker.com)

### Quick Start with Docker
Ensure you have a running MySQL database, then pull and run the container locally on port `8080` by passing your database credentials:

```bash
docker run -d \
  -p 8080:8080 \
  -e SPRING_DATASOURCE_URL="jdbc:mysql://host.docker.internal:3306/fitness_db?createDatabaseIfNotExist=true" \
  -e SPRING_DATASOURCE_USERNAME="root" \
  -e SPRING_DATASOURCE_PASSWORD="your_mysql_password" \
  --name fitness-tracker \
  sandeep2026paswan/fitness-mono:latest
```

Once running, access the application in your browser at **`http://localhost:8080`**.

## 💻 Running Locally from Source

### Prerequisites
* **Java Development Kit (JDK) 17 or 21** installed
* **MySQL Server** running locally on port `3306`
* **Maven** (or use the included Maven Wrapper)

### Setup Steps
1. **Clone the repository:**
   ```bash
   git clone https://github.com
   cd FitnessTracke/fitness-monolith
   ```
2. **Configure MySQL in `src/main/resources/application.properties`:**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/fitness_db?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=your_mysql_password
   spring.jpa.hibernate.ddl-auto=update
   ```
3. **Build and run the application:**
   * **Windows:**
     ```powershell
     .\mvnw spring-boot:run
     ```
   * **Mac / Linux:**
     ```bash
     ./mvnw spring-boot:run
     ```

## 📬 Connect
* **GitHub:** [sandeeppaswan](https://github.com)
* **Docker Hub:** [sandeep2026paswan](https://docker.com)
