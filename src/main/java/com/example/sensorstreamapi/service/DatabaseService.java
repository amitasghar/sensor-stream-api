package com.example.sensorstreamapi.service;

import com.example.sensorstreamapi.model.SensorData;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class DatabaseService {
    private final Map<String, SensorData> database = new HashMap<>();

    public void save(SensorData data) {
        database.put(data.getSensorId(), data);
    }

    public Collection<SensorData> findAll() {
        return database.values();
    }
}
