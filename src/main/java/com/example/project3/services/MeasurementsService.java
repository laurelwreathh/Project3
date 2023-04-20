package com.example.project3.services;

import com.example.project3.models.Measurement;
import com.example.project3.repositories.MeasurementsRepository;
import com.example.project3.util.MeasurementNotCreatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@Transactional(readOnly = true)
public class MeasurementsService {


    private final MeasurementsRepository measurementsRepository;

    private final SensorsService sensorsService;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository, SensorsService sensorsService) {
        this.measurementsRepository = measurementsRepository;
        this.sensorsService = sensorsService;
    }

    @Transactional
    public void save(Measurement measurement){

        if(sensorsService.isExists(measurement.getSensor())){
            measurement.setCreatedAt(LocalDateTime.now());
            measurementsRepository.save(measurement);
        } else {
            throw new MeasurementNotCreatedException("Sensor doesn't exists");
        }

    }
}
