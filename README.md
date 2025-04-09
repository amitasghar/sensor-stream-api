# Sensor Stream API
by Amit - 2025

A Spring Boot application that:

- Accepts sensor data via REST API
- Publishes data to a simulated internal stream
- Persists data in a simulated NoSQL in-memory database
- Sends sensor data to an external API using Bearer token authentication

## API Endpoints

### POST /sensor-data

Accepts a sensor reading.

**Request Example:**

```json
{
  "sensorId": "sensor-1",
  "temperature": 23.5,
  "timestamp": "2025-04-01T15:00:00Z"
}
```

### GET /sensor-data

Returns all persisted sensor data.

## Configuration

Edit `src/main/resources/application.properties`:

```properties
external.api.url=https://webhook.site/<free mock HTTP endpoint>
external.api.token=<add token>
```

## Build and Run

```bash
./gradlew bootRun
```

Visit: `http://localhost:8080/sensor-data`