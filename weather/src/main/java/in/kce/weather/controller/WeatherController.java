package in.kce.weather.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

import in.kce.weather.entity.Weather;
import in.kce.weather.repository.WeatherRepository;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherRepository repo;

    public WeatherController(WeatherRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Weather> getAll() {
        return repo.findAll();
    }

    @GetMapping("/date")
    public List<Weather> getByDate(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {

        return repo.findByDate(date);
    }

    @GetMapping("/month")
    public List<Weather> getByMonth(@RequestParam int year,
                                    @RequestParam int month) {

        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        return repo.findByDateBetween(start, end);
    }
    
    @GetMapping("/condition")
    public List<Weather> getByCondition(@RequestParam String value) {
        return repo.findByCondition(value);
    }
}