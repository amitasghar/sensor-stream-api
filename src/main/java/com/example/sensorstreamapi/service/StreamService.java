package com.example.sensorstreamapi.service;

import com.example.sensorstreamapi.model.SensorData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StreamService {
    private final List<SensorData> stream = new ArrayList<>();

    public void publish(SensorData data) {
        stream.add(data);
    }
}
