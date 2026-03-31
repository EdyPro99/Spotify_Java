package edu.jdc.spotify_java.cancion.infrastructure.repository;

import edu.jdc.spotify_java.cancion.domain.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaCancionRepository extends JpaRepository<Cancion, Long> {

    @Query("SELECT c FROM Cancion c JOIN FETCH c.album JOIN FETCH c.artista")
    List<Cancion> findAllWithRelations();
}
