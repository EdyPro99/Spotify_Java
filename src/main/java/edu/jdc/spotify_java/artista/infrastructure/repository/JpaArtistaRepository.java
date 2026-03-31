package edu.jdc.spotify_java.artista.infrastructure.repository;

import edu.jdc.spotify_java.artista.domain.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaArtistaRepository extends JpaRepository<Artista, Long> {

}
