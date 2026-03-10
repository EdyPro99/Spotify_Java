package edu.jdc.spotify_java.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "canciones")
@Data
public class CancionEntity implements Serializable {


}
