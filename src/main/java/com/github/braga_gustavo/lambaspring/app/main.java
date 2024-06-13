package com.github.braga_gustavo.lambaspring.app;

import com.github.braga_gustavo.lambaspring.service.MovieApiIntegration;

import java.util.Scanner;

public class main {

    private final String API_ADDRESS = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=2b301e2f";

    private MovieApiIntegration integration = new MovieApiIntegration();
    Scanner scanner = new Scanner(System.in);

    public void showMenu(){
        System.out.println("Series name: ");
        var series = scanner.nextLine();
        String json = integration.getData(API_ADDRESS.concat(series.replace("", "+")).concat(API_KEY));
    }

    //TODO: modelar o



}
