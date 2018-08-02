package server.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import server.repositories.MovieRepository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genres")
public class Genre {
    @Autowired
    @Transient
    MovieRepository movieRepository;

    @Id
    @GeneratedValue
    @SequenceGenerator(name="genre-generator")
    public Long id;
    public String genre;

    @OneToMany
    @JoinColumn(name = "genre_id")
    public List<Movie> movies;

    public String toString() {
        return genre;
    }
}
