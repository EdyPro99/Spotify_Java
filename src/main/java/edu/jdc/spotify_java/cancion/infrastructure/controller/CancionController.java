package edu.jdc.spotify_java.cancion.infrastructure.controller;

import edu.jdc.spotify_java.cancion.application.CancionService;
import edu.jdc.spotify_java.cancion.domain.Cancion;
import edu.jdc.spotify_java.cancion.dto.CancionDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cancion")
public class CancionController {

    private final CancionService cancionService;

    public CancionController(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    @GetMapping
    public List<Cancion> getAll() {
        return cancionService.findAll();
    }

    @PostMapping("/createCancion")
    public Cancion create(@RequestBody CancionDTO dto) {
        return cancionService.create(dto);
    }

    @PutMapping("/updateCancion/{id}")
    public Cancion update(@PathVariable Long id, @RequestBody CancionDTO dto) {
        return cancionService.update(id, dto);
    }

    @DeleteMapping("/deleteCancion/{id}")
    public void delete(@PathVariable Long id) {
        cancionService.delete(id);
    }

}
