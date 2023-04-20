package com.example.project3.services;

import com.example.project3.models.Sensor;
import com.example.project3.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SensorsService {

    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    @Transactional
    public void save(Sensor sensor){
        sensorsRepository.save(sensor);
    }

    public boolean isExists(Sensor sensor){
        return sensorsRepository.existsSensorByName(sensor.getName());
    }
}
