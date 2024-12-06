package com.examen.cl2.Gutierrez_Eddy.dto;

public record FilmDeleteDTO(Integer filmId,
                            String title,
                            String description,
                            Integer releaseYear,
                            Integer languageId,
                            Integer rentalDuration,
                            Double rentalRate,
                            Integer length,
                            Double replacementCost,
                            String specialFeatures) {
}
