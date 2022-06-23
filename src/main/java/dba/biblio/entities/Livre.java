package dba.biblio.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livre implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;
    private String titre;
    @ManyToOne
    private Genre genre;
    private String photoName;
    private int quantite = 0;

    @ManyToOne(fetch = FetchType.EAGER)
    private Auteur auteur;

    @ManyToOne
    private Editeur editeur;

    @ManyToOne
    private Rayon rayon;






}
