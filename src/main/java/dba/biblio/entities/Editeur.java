package dba.biblio.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.Collection;

@Setter
@EqualsAndHashCode
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Editeur {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Long id;
    private String libelle;

    @OneToMany(mappedBy = "editeur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Livre> livres;
}
