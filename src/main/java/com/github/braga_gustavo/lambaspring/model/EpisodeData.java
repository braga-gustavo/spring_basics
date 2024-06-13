package com.github.braga_gustavo.lambaspring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodeData(@JsonAlias("Title") String title, @JsonAlias("Episode") String episodeNumber,
                          @JsonAlias("imdbRating") String rating,
                          @JsonAlias("Released") String releaseDate) {
}
