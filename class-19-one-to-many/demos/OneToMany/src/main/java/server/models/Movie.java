package server.models;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue
    @SequenceGenerator(name="movie-generator")
    public Long id;

    @Column(name="name")
    public String title;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    public Genre genre;

    public String toString() {
        return this.title;
    }
}
