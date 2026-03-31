package edu.jdc.spotify_java.artista.application;

import edu.jdc.spotify_java.artista.domain.Artista;
import edu.jdc.spotify_java.artista.dto.ArtistaDTO;
import edu.jdc.spotify_java.artista.infrastructure.repository.JpaArtistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    private final JpaArtistaRepository jpaArtistaRepository;

    public ArtistaService(JpaArtistaRepository jpaArtistaRepository) {
        this.jpaArtistaRepository = jpaArtistaRepository;
    }

    public List<Artista> findAll() {
        return jpaArtistaRepository.findAll();
    }

    public Artista findById(Long id) {
        return jpaArtistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
    }

    public Artista create(ArtistaDTO dto){
        Artista artista = new Artista();
        artista.setNombreArtista(dto.getNombreArtista());
        artista.setDescripcionArtista(dto.getDescripcionArtista());
        return jpaArtistaRepository.save(artista);
    }

    public Artista update(Long id, ArtistaDTO dto) {
        Artista artista = findById(id);
        artista.setNombreArtista(dto.getNombreArtista());
        artista.setDescripcionArtista(dto.getDescripcionArtista());
        return jpaArtistaRepository.save(artista);
    }

    public void delete(Long id) {
        jpaArtistaRepository.deleteById(id);
    }
}
