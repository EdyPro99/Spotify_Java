package edu.jdc.spotify_java.cancion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CancionDTO {
    private String nombreCancion;
    private Long idAlbum;
    private Long idArtista;
}
