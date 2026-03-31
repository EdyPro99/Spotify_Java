package edu.jdc.spotify_java.cancion.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.jdc.spotify_java.album.domain.Album;
import edu.jdc.spotify_java.artista.domain.Artista;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "canciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCancion;

    @Column(name = "nombre_cancion")
    private String nombreCancion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_album")
    private Album album;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_artista")
    private Artista artista;
}
