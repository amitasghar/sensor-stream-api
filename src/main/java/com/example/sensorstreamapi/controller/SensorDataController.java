package com.example.sensorstreamapi.controller;

import com.example.sensorstreamapi.model.SensorData;
import com.example.sensorstreamapi.service.DatabaseService;
import com.example.sensorstreamapi.service.ExternalApiService;
import com.example.sensorstreamapi.service.StreamService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/sensor-data")
public class SensorDataController {

    private final StreamService streamService;
    private final DatabaseService databaseService;
    private final ExternalApiService externalApiService;

    public SensorDataController(StreamService streamService, DatabaseService databaseService, ExternalApiService externalApiService) {
        this.streamService = streamService;
        this.databaseService = databaseService;
        this.externalApiService = externalApiService;
    }

    @PostMapping
    public String receiveSensorData(@RequestBody SensorData data) {
        streamService.publish(data);
        databaseService.save(data);
        externalApiService.sendSensorData(data);
        return "Sensor data received successfully!";
    }

    @GetMapping
    public Collection<SensorData> getAllSensorData() {
        return databaseService.findAll();
    }
}
