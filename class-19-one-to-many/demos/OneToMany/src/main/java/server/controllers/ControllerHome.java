package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import server.models.Genre;
import server.models.Movie;
import server.repositories.GenreRepository;
import server.repositories.MovieRepository;

import java.util.List;

@Controller
@RequestMapping
public class ControllerHome {
    @Autowired
    GenreRepository genreRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping
    public String homepage(Model model) {
        List<Genre> genres = genreRepository.findAll();
        List<Movie> movies = movieRepository.findAll();

        model.addAttribute("genres", genres);
        model.addAttribute("movies", movies);

        return "index";
    }
}
