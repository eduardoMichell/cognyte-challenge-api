
# Event Manager API

This API is developed as part of a technical challenge for a Fullstack Developer role. The project focuses on managing events, providing essential CRUD functionalities (Create, Read, Update, Delete) for events.
## Technologies Used

- **Java 17**: Programming language used to develop the API.
- **Spring Boot**: Framework used to build the RESTful API.
- **Hibernate**: ORM used to map entities to the database.
- **PostgreSQL**: Relational database used to store data.
- **Docker**: Tool used to containerize the application.

## Prerequisites

Before starting, make sure you have the following items installed on your machine:

- **JDK 17**: [Install JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- **Docker**: [Install Docker](https://www.docker.com/)

## How to Download and Run the API

### 1. Clone the Repository

First, clone the repository:

```bash
git clone https://github.com/eduardoMichell/cognyte-challenge-api.git
cd cognyte-challenge-api
```

### 2. Configure the `.env` File

Create a `.env` file in the root of the project with the following environment variables. These variables will be used to configure the PostgreSQL database:

```bash
DATABASE_URL=jdbc:postgresql://db:5432/event_manager
DATABASE_USERNAME=admin
DATABASE_PASSWORD=admin
```

> **Note**: Docker will create a PostgreSQL database for you.

### 3. Run the Docker

To run the application using Docker, you need to first ensure Docker is installed on your machine. Once Docker is set up, follow the steps below to start the API and the PostgreSQL database in separate containers.

Run the following command:

```bash
docker-compose up --build
```

This command will:
- **Build** the API image and pull the PostgreSQL image.
- **Run** the API and database containers.

### 4. Access the API

After the above command, the API will be running on port **8080**.

You can access the API using the following endpoint:

```
http://localhost:8080/api/events
```

### 5. Stop the Containers

To stop the containers, run:

```bash
docker-compose down
```

## Main Endpoints

- **GET** `/api/events`: Lists all events.
- **POST** `/api/events`: Creates a new event.
- **GET** `/api/events/{id}`: Shows the details of a specific event.
- **PUT** `/api/events/{id}`: Updates an existing event.
- **DELETE** `/api/events/{id}`: Deletes an event.

## Environment Variables

Here are the environment variables you can configure:

- `DATABASE_URL`: PostgreSQL database connection URL.
- `DATABASE_USERNAME`: Database username.
- `DATABASE_PASSWORD`: Database password.

## Docker

The application uses two Docker containers:

1. **cognyte-challenge-api**: API container.
2. **PostgreSQL**: PostgreSQL database container.

### Useful Docker Commands

- **Build the application**:
  ```bash
  docker-compose up --build
  ```

- **Stop the containers**:
  ```bash
  docker-compose down
  ```

- **View container logs**:
  ```bash
  docker-compose logs
  ```

## Database Schema

If you need to run the application locally and require the database schema, there is a `schema.sql` file located in the `resources` folder of the project. This file contains the necessary schema to create the database tables.
