package com.examen.cl2.Gutierrez_Eddy.service.impl;

import com.examen.cl2.Gutierrez_Eddy.dto.FilmCreateDTO;
import com.examen.cl2.Gutierrez_Eddy.dto.FilmDTO;
import com.examen.cl2.Gutierrez_Eddy.dto.FilmDeleteDTO;
import com.examen.cl2.Gutierrez_Eddy.dto.FilmDetailDTO;
import com.examen.cl2.Gutierrez_Eddy.entity.Film;
import com.examen.cl2.Gutierrez_Eddy.entity.Language;
import com.examen.cl2.Gutierrez_Eddy.repository.FilmRepository;
import com.examen.cl2.Gutierrez_Eddy.repository.LanguageRepository;
import com.examen.cl2.Gutierrez_Eddy.service.CrudMaintenanceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CrudMaintenanceServiceImpl implements CrudMaintenanceService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Override
    public List<FilmDTO> findAllFilms() {

        List<FilmDTO> films = new ArrayList<FilmDTO>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
            FilmDTO filmDTO = new FilmDTO(
                    film.getFilmId(),
                    film.getTitle(),
                    film.getDescription(),
                    film.getReleaseYear(),
                    film.getRentalDuration(),
                    film.getSpecialFeatures(),
                    film.getLanguage().getName());
            films.add(filmDTO);
        });
        return films;
    }

    @Override
    public FilmDetailDTO findFilmById(int id) {

        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(film -> new FilmDetailDTO(
                film.getFilmId(),
                film.getTitle(),
                film.getDescription(),
                film.getReleaseYear(),
                film.getRentalDuration(),
                film.getRentalRate(),
                film.getLength(),
                film.getReplacementCost(),
                film.getSpecialFeatures(),
                film.getLanguage().getName(),
                film.getLastUpdate())
        ).orElse(null);

    }

    @Override
    public Boolean updateFilm(FilmDetailDTO filmDetailDTO) {
        Optional<Film> optional = filmRepository.findById(filmDetailDTO.filmId());
        return optional.map(
                film -> {
                    film.setTitle(filmDetailDTO.title());
                    film.setDescription(filmDetailDTO.description());
                    film.setReleaseYear(filmDetailDTO.releaseYear());
                    film.setRentalDuration(filmDetailDTO.rentalDuration());
                    film.setRentalRate(filmDetailDTO.rentalRate());
                    film.setLength(filmDetailDTO.length());
                    film.setReplacementCost(filmDetailDTO.replacementCost());
                    film.setSpecialFeatures(filmDetailDTO.specialFeatures());
                    film.setLastUpdate(new Date());
                    filmRepository.save(film);
                    return true;
                }
        ).orElse(false);

    }

    @Override
    public Boolean deleteFilms(Integer id) {

        System.out.println(id);

        return true;
    }

    @Override
    public FilmCreateDTO getFilmCreate() {
        return new FilmCreateDTO(0, "", "", null, 0, null, 0, 0.0, 0, 0.0, "", "", new Date());
    }

    @Override
    public void postFilmCreate(FilmCreateDTO filmCreateDto) {

        Film film = new Film();
        //para language
        Language language = languageRepository.findById(filmCreateDto.languageId())
                .orElseThrow(() -> new EntityNotFoundException("ID de lenguaje no existente"));


        film.setTitle(filmCreateDto.title());
        film.setDescription(filmCreateDto.description());
        film.setReleaseYear(filmCreateDto.releaseYear());
        film.setLanguage(language);
        film.setLanguage2(null);
        film.setRentalDuration(filmCreateDto.rentalDuration());
        film.setRentalRate(filmCreateDto.rentalRate());
        film.setLength(filmCreateDto.length());
        film.setReplacementCost(filmCreateDto.replacementCost());
        film.setSpecialFeatures(filmCreateDto.specialFeatures());
        film.setLastUpdate(new Date());

        filmRepository.save(film);

    }

    @Override
    public FilmDeleteDTO getFilmDeleteById(int id) {
        Optional<Film> optional = filmRepository.findById(id);

        return optional.map(
                film -> new FilmDeleteDTO(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getLanguage().getLanguageId(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getSpecialFeatures())

        ).orElse(null);
    }

    @Override
    public void postFilmDeleteById(int id, FilmDeleteDTO FilmDeleteDTO) {
        Optional<Film> optional = filmRepository.findById(id);

        Film film = optional.orElseThrow(() -> new EntityNotFoundException("Film NO EXISTE"));

        filmRepository.delete(film);
    }
}
