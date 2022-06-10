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

}
