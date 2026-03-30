package edu.jdc.spotify_java.album.infrastructure.controller;

import edu.jdc.spotify_java.album.application.AlbumService;
import edu.jdc.spotify_java.album.domain.Album;
import edu.jdc.spotify_java.album.dto.AlbumDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/album")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> findAll() {
        return albumService.findAll();
    }

    @PostMapping("/createAlbum")
    public Album create(@RequestBody AlbumDTO dto) {
        return albumService.create(dto);
    }

    @PutMapping("/updateAlbum/{id}")
    public Album update(@PathVariable Long id, @RequestBody AlbumDTO dto) {
        return albumService.update(id, dto);
    }

    @DeleteMapping("/deleteAlbum/{id}")
    public void delete(@PathVariable Long id) {
        albumService.delete(id);
    }

}
