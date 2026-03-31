package edu.jdc.spotify_java.artista.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "artistas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_album")
    private Long idAlbum;

    @Column(name = "nombre_artista")
    private String nombreArtista;

    @Column(name = "descripcion_artista")
    private String descripcionArtista;
}
