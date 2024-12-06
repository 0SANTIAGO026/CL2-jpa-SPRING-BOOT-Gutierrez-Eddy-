package com.examen.cl2.Gutierrez_Eddy;

import com.examen.cl2.Gutierrez_Eddy.entity.Film;
import com.examen.cl2.Gutierrez_Eddy.repository.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class GutierrezEddyApplication implements CommandLineRunner {

	private final FilmRepository filmRepository;

	public GutierrezEddyApplication(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(GutierrezEddyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Logica del cache @Santiago
		Iterable<Film> iterable = filmRepository.findAll();
		iterable.forEach((film) -> {
			String message = String.format("%s:%s", film.getFilmId(), film.getTitle());
		});

		Iterable<Film> iterable2 = filmRepository.findAll();
		iterable2.forEach((film) -> {
			String message = String.format("%s:%s", film.getFilmId(), film.getTitle());
			System.out.print(message);

		});

		Optional<Film> optional = filmRepository.findById(1);
		optional.ifPresentOrElse(
				(film) -> {
					film.setTitle("Termineitor 7");
					filmRepository.save(film);
				},
				() -> {
					System.out.println("Film no existe");
				}
		);
		Iterable<Film> iterable3 = filmRepository.findAll();
		iterable3.forEach((film) -> {
			String message = String.format("%s:%s", film.getFilmId(), film.getTitle());

			System.out.print(message);

		});
		//Logica del cache @Santiago
	}
}
