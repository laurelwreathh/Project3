package com.example.project3.dto;

import com.example.project3.models.Sensor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.NotFound;

import java.time.LocalDateTime;

public class MeasurementDTO {

    @NotNull
    @Min(value = -100, message = "Temperature should be hotter than -100")
    @Max(value = 100, message = "Temperature should be colder than -100")
    private double temperature;

    @NotNull
    private boolean raining;

    private Sensor sensor;

    public MeasurementDTO(double temperature, boolean raining, Sensor sensor) {
        this.temperature = temperature;
        this.raining = raining;
        this.sensor = sensor;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public MeasurementDTO() {
    }
}
