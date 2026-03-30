package edu.jdc.spotify_java.album.infrastructure.repository;

import edu.jdc.spotify_java.album.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaAlbumRepository extends JpaRepository<Album, UUID> {

}
