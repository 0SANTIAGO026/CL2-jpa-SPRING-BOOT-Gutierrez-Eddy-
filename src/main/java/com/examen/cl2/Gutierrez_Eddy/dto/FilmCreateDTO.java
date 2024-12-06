package com.examen.cl2.Gutierrez_Eddy.dto;

import java.util.Date;

public record FilmCreateDTO( Integer filmId,
                             String title,
                             String description,
                             Integer releaseYear,
                             Integer languageId,
                             Integer originalLanguageId,
                             Integer rentalDuration,
                             Double rentalRate,
                             Integer length,
                             Double replacementCost,
                             String rating,
                             String specialFeatures,
                             Date lastUpdate) {
}
