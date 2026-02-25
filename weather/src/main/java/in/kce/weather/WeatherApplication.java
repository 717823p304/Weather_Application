package in.kce.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import in.kce.weather.entity.Weather;
import in.kce.weather.repository.WeatherRepository;

@SpringBootApplication
public class WeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(WeatherRepository repo) {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                repo.deleteAll();
                System.out.println("Old data deleted...");

                InputStream inputStream = 
                        getClass().getResourceAsStream("/weather.csv");

                if (inputStream == null) {
                    System.out.println(" weather.csv NOT FOUND in resources folder");
                    return;
                }

                System.out.println(" weather.csv FOUND");

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(inputStream)
                );

                String line;
                int count = 0;

                br.readLine(); // Skip header

                while ((line = br.readLine()) != null) {

                    String[] data = line.split(",");

                    Weather weather = new Weather(
                            LocalDate.parse(data[0]),
                            Double.parseDouble(data[1]),
                            Double.parseDouble(data[2]),
                            Double.parseDouble(data[3]),
                            Double.parseDouble(data[4]),
                            Double.parseDouble(data[5]),
                            Double.parseDouble(data[6]),
                            data[7]
                    );

                    repo.save(weather);
                    count++;
                }

                br.close();

                System.out.println(" Total Records Inserted: " + count);
            }
        };
    }
}