package in.kce.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import in.kce.weather.entity.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

	
    List<Weather> findByDate(LocalDate date);

    List<Weather> findByDateBetween(LocalDate start, LocalDate end);
    
    List<Weather> findByCondition(String condition);
}