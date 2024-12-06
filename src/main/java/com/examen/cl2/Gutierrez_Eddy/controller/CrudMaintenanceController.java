package com.examen.cl2.Gutierrez_Eddy.controller;

import com.examen.cl2.Gutierrez_Eddy.dto.FilmCreateDTO;
import com.examen.cl2.Gutierrez_Eddy.dto.FilmDTO;
import com.examen.cl2.Gutierrez_Eddy.dto.FilmDetailDTO;
import com.examen.cl2.Gutierrez_Eddy.service.CrudMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/CrudMaintenance")
public class CrudMaintenanceController {

    @Autowired
    CrudMaintenanceService crudMaintenanceService;

    @GetMapping("/listarFilm")
    public String listarFilm(Model model){
        List<FilmDTO> films = crudMaintenanceService.findAllFilms();
        model.addAttribute("films", films);

        return "CrudMaintenance";
    }

    @GetMapping("/detailFilms/{id}")
    public String detailFilms(@PathVariable Integer id, Model model){
        FilmDetailDTO filmDetailDTO = crudMaintenanceService.findFilmById(id);
        model.addAttribute("filmDetailDTO", filmDetailDTO);

        return "CrudMaintenanceDetail";
    }

    @GetMapping("/create")
    public String create(Model model) {

        FilmCreateDTO filmCreateDto = crudMaintenanceService.getFilmCreate();
        model.addAttribute("filmCreateDto", filmCreateDto);
        return "CrudMaintenanceCreate";
    }

    @PostMapping("/create")
    public String createFilm(@ModelAttribute FilmCreateDTO filmCreateDto) {
        crudMaintenanceService.postFilmCreate(filmCreateDto);
        return "redirect:/CrudMaintenance/listarFilm";
    }

    @GetMapping("/editFilms/{id}")
    public String editFilms(@PathVariable Integer id, Model model){
        FilmDetailDTO filmDetailDTO = crudMaintenanceService.findFilmById(id);
        model.addAttribute("filmDetailDTO", filmDetailDTO);

        return "CrudMaintenanceEdit";
    }

    @PostMapping("/editConfirm")
    public String editConfirm(@ModelAttribute FilmDetailDTO filmDetailDTO, Model model){
        crudMaintenanceService.updateFilm(filmDetailDTO);
        return "redirect:/CrudMaintenance/listarFilm";
    }

    @PostMapping("/removeFilms")
    public String removeFilms(@PathVariable Integer id, Model model){
        crudMaintenanceService.deleteFilms(id);
        return "redirect:/CrudMaintenance/listarFilm";
    }

}
