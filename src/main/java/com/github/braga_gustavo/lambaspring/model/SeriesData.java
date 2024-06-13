package com.github.braga_gustavo.lambaspring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//It is possible to pass and array to the @JsonAlias, so it will search and read its values in the json
@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesData(@JsonAlias({"title", "Title"}) String title, @JsonAlias("imdbRating") String rating,
                         @JsonAlias("totalSeasons") Integer numberOfSeaons) {
}
