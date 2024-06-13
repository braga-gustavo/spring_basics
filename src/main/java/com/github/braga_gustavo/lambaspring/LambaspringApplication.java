package com.github.braga_gustavo.lambaspring;

import com.github.braga_gustavo.lambaspring.model.EpisodeData;
import com.github.braga_gustavo.lambaspring.model.SeasonData;
import com.github.braga_gustavo.lambaspring.service.DataConverter;
import com.github.braga_gustavo.lambaspring.model.SeriesData;
import com.github.braga_gustavo.lambaspring.service.MovieApiIntegration;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LambaspringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LambaspringApplication.class, args);
    }

    @Override
    public void run(String... args) {
        MovieApiIntegration apiService = new MovieApiIntegration();
        var jsonSeries = apiService.getData("https://www.omdbapi.com/?t=breaking+bad&apikey=2b301e2f");
//        System.out.println(jsonSeries);

        DataConverter converter = new DataConverter();
        SeriesData series = converter.getData(jsonSeries, SeriesData.class);
//        System.out.println(series);

        var jsonEpisodes = apiService.getData("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=2b301e2f");
        EpisodeData episode = converter.getData(jsonEpisodes, EpisodeData.class);
        System.out.println(jsonEpisodes);

        List<SeasonData> seasons = new ArrayList<>();
        for (int i = 1; i <= series.numberOfSeaons(); i++) {
            var jsonSeasons = apiService.getData("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=2b301e2f");
            SeasonData seasonData = converter.getData(jsonSeasons, SeasonData.class);
            seasons.add(seasonData);
        }

        seasons.forEach(System.out::println);
    }
}
