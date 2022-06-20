package dba.biblio.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;


@Setter
@EqualsAndHashCode
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Auteur {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long Id;
    private String prenom;
    private String nom;
    @OneToMany(mappedBy = "auteur")
    private Collection<Livre> livres;
}
