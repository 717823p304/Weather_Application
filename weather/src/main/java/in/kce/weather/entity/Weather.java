package in.kce.weather.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weather_date", nullable = false)
    private LocalDate date;

    private double temperature;
    private double humidity;
    private double pressure;
    private double heatIndex;
    private double windSpeed;
    private double visibility;
    private String condition;

    public Weather() {
    }

    public Weather(LocalDate date, double temperature, double humidity,
                   double pressure, double heatIndex,
                   double windSpeed, double visibility,
                   String condition) {

        this.date = date;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.heatIndex = heatIndex;
        this.windSpeed = windSpeed;
        this.visibility = visibility;
        this.condition = condition;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(double heatIndex) {
        this.heatIndex = heatIndex;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}