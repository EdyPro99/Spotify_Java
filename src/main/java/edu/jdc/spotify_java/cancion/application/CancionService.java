package edu.jdc.spotify_java.cancion.application;

import edu.jdc.spotify_java.album.domain.Album;
import edu.jdc.spotify_java.album.infrastructure.repository.JpaAlbumRepository;
import edu.jdc.spotify_java.artista.application.ArtistaService;
import edu.jdc.spotify_java.artista.domain.Artista;
import edu.jdc.spotify_java.artista.infrastructure.repository.JpaArtistaRepository;
import edu.jdc.spotify_java.cancion.domain.Cancion;
import edu.jdc.spotify_java.cancion.dto.CancionDTO;
import edu.jdc.spotify_java.cancion.infrastructure.repository.JpaCancionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class CancionService {

    private final JpaCancionRepository cancionRepository;
    private final JpaArtistaRepository artistaRepository;
    private final JpaAlbumRepository albumRepository;
    private final JpaCancionRepository jpaCancionRepository;

    public CancionService(JpaCancionRepository cancionRepository, JpaArtistaRepository artistaRepository, JpaAlbumRepository albumRepository, JpaCancionRepository jpaCancionRepository) {
        this.cancionRepository = cancionRepository;
        this.artistaRepository = artistaRepository;
        this.albumRepository = albumRepository;
        this.jpaCancionRepository = jpaCancionRepository;
    }

    public List<Cancion> findAll() {
        return cancionRepository.findAllWithRelations();

    }

    public Cancion findById(Long id) {
        return jpaCancionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cancion not found"));
    }

    public Cancion create(CancionDTO dto) {

        Album album = albumRepository.findById(dto.getIdAlbum())
                .orElseThrow(() -> new RuntimeException("Album no encontrado"));

        Artista artista = artistaRepository.findById(dto.getIdArtista())
                .orElseThrow(() -> new RuntimeException("Artista no encontrado"));

        Cancion cancion = new Cancion();
        cancion.setNombreCancion(dto.getNombreCancion());
        cancion.setAlbum(album);
        cancion.setArtista(artista);

        return cancionRepository.save(cancion);
    }

    public Cancion update(Long id, CancionDTO dto) {
        Cancion cancion = findById(id);
        cancion.setNombreCancion(dto.getNombreCancion());
        return cancionRepository.save(cancion);
    }

    public void delete(Long id) {
        jpaCancionRepository.deleteById(id);
    }

}
