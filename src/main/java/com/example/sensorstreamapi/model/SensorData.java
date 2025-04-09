package com.example.sensorstreamapi.model;

public class SensorData {
    private String sensorId;
    private double temperature;
    private String timestamp;

    // ✅ No-args constructor needed by Jackson
    public SensorData() {}

    // All-args constructor (optional)
    public SensorData(String sensorId, double temperature, String timestamp) {
        this.sensorId = sensorId;
        this.temperature = temperature;
        this.timestamp = timestamp;
    }

    // ✅ Standard getters and setters
    public String getSensorId() { return sensorId; }
    public void setSensorId(String sensorId) { this.sensorId = sensorId; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
