package edu.jdc.spotify_java.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "albums")
public class AlbumEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlbum")
    private Long idAlbum;

    @NotNull
    @Column(name = "nombre_album")
    private String nombreAlbum;
}
