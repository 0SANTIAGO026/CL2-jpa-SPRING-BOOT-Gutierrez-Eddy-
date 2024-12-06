package com.examen.cl2.Gutierrez_Eddy.service;

import com.examen.cl2.Gutierrez_Eddy.dto.FilmCreateDTO;
import com.examen.cl2.Gutierrez_Eddy.dto.FilmDTO;
import com.examen.cl2.Gutierrez_Eddy.dto.FilmDeleteDTO;
import com.examen.cl2.Gutierrez_Eddy.dto.FilmDetailDTO;

import java.util.List;

public interface CrudMaintenanceService {

    List<FilmDTO> findAllFilms();

    FilmDetailDTO findFilmById(int id);

    Boolean updateFilm(FilmDetailDTO filmDetailDTO);

    Boolean deleteFilms(Integer id);

    // Para Crear / Insertar
    FilmCreateDTO getFilmCreate();

    public void postFilmCreate(FilmCreateDTO filmCreateDto);

    //Para Eliminar
    FilmDeleteDTO getFilmDeleteById(int id);

    public void postFilmDeleteById(int id, FilmDeleteDTO FilmDeleteDTO);
}
