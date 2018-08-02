package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
