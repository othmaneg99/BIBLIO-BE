package dba.biblio.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @OneToMany(mappedBy = "auteur", fetch= FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Livre> livres;
}
