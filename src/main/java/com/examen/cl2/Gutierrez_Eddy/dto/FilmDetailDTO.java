package com.examen.cl2.Gutierrez_Eddy.dto;

import java.util.Date;

public record FilmDetailDTO(Integer filmId,
                            String title,
                            String description,
                            Integer releaseYear,
                            Integer rentalDuration,
                            Double rentalRate,
                            Integer length,
                            Double replacementCost,
                            String specialFeatures,
                            String language,
                            Date lastUpdate) {
}
