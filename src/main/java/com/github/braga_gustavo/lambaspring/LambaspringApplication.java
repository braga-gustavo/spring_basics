package com.github.braga_gustavo.lambaspring;

import com.github.braga_gustavo.lambaspring.model.DataConverter;
import com.github.braga_gustavo.lambaspring.model.SeriesData;
import com.github.braga_gustavo.lambaspring.service.MovieApiIntegration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LambaspringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LambaspringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MovieApiIntegration apiService = new MovieApiIntegration();
        var json = apiService.getData("https://www.omdbapi.com/?t=breaking+bad&apikey=2b301e2f");
        System.out.println(json);
        DataConverter converter = new DataConverter();
        SeriesData data = converter.getData(json, SeriesData.class);
        System.out.println(data);


    }
}
