package edu.jdc.spotify_java.artista.infrastructure.controller;

import edu.jdc.spotify_java.artista.application.ArtistaService;
import edu.jdc.spotify_java.artista.domain.Artista;
import edu.jdc.spotify_java.artista.dto.ArtistaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/artista")
public class ArtistaController {

    private final ArtistaService artistaService;

    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @GetMapping
    public List<Artista> getAll() {
        return artistaService.findAll();
    }

    @PostMapping("/createArtista")
    public Artista create(@RequestBody ArtistaDTO dto) {
        return artistaService.create(dto);
    }

    @PutMapping("/updateArtista/{id}")
    public Artista update(@PathVariable Long id, @RequestBody ArtistaDTO dto) {
        return artistaService.update(id, dto);
    }

    @DeleteMapping("/deleteArtista/{id}")
    public void delete(@PathVariable Long id) {
        artistaService.delete(id);
    }
}
