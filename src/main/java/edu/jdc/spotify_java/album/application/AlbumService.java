package edu.jdc.spotify_java.album.application;

import edu.jdc.spotify_java.album.domain.Album;
import edu.jdc.spotify_java.album.dto.AlbumDTO;
import edu.jdc.spotify_java.album.infrastructure.repository.JpaAlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlbumService {

    private final JpaAlbumRepository jpaAlbumRepository;

    public AlbumService(JpaAlbumRepository jpaAlbumRepository) {
        this.jpaAlbumRepository = jpaAlbumRepository;
    }

    public List<Album> findAll() {
        return jpaAlbumRepository.findAll();
    }

    public Album create(AlbumDTO dto) {
        Album album = new Album();
        album.setNombreAlbum(dto.getNombreAlbum());
        return jpaAlbumRepository.save(album);
    }

    public Album findById(UUID id) {
        return jpaAlbumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album no encontrado"));
    }

    public Album update(UUID id, AlbumDTO dto) {
        Album album = findById(id);
        album.setNombreAlbum(dto.getNombreAlbum());
        return jpaAlbumRepository.save(album);
    }

    public void delete(UUID id) {
        jpaAlbumRepository.deleteById(id);
    }
}
