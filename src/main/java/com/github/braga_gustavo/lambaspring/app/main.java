package com.github.braga_gustavo.lambaspring.app;

import com.github.braga_gustavo.lambaspring.model.SeasonData;
import com.github.braga_gustavo.lambaspring.model.SeriesData;
import com.github.braga_gustavo.lambaspring.service.DataConverter;
import com.github.braga_gustavo.lambaspring.service.MovieApiIntegration;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    private final String API_ADDRESS = "https://www.omdbapi.com/?t=";
    private String season = "&season=";
    private final String API_KEY = "&apikey=2b301e2f";
    private DataConverter converter = new DataConverter();
    private MovieApiIntegration apiService = new MovieApiIntegration();
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("Series name: ");
        var series = scanner.nextLine();
        String encodedSeries = URLEncoder.encode(series, StandardCharsets.UTF_8);

        String json = apiService.getData(API_ADDRESS.concat(encodedSeries).concat(API_KEY));
        SeriesData seriesData = converter.getData(json, SeriesData.class);
        System.out.println(json);

        List<SeasonData> seasons = new ArrayList<>();
        for (int i = 1; i <= seriesData.numberOfSeasons(); i++) {
            json = apiService.getData(API_ADDRESS
                    .concat(encodedSeries)
                    .concat(season)
                    .concat(String.valueOf(i))
                    .concat(API_KEY));
            SeasonData seasonData = converter.getData(json, SeasonData.class);
            seasons.add(seasonData);
        }

        seasons.forEach(System.out::println);
    }



}
