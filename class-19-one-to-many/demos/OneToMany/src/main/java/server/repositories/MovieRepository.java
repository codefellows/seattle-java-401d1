package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
