package com.examen.cl2.Gutierrez_Eddy.dto;

public record FilmDTO(Integer filmId,
                      String title,
                      String description,
                      Integer releaseYear,
                      Integer rentalDuration,
                      String specialFeatures,
                      String language) {
}
